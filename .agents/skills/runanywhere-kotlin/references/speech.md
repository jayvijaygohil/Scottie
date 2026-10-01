Contents (search for the `# ` heading): transcribe(), Streaming STT, STT Options, synthesize(),
Streaming TTS, Voices, Voice Activity Detection, Voice Agent, Diarization

# transcribe()

> Convert speech to text on-device

```kotlin theme={null}
import com.runanywhere.sdk.public.RunAnywhere
import com.runanywhere.sdk.public.api.*

val transcription = RunAnywhere.stt.transcribe(AudioInput.file(path))
println(transcription.text)
```

## Signature

```kotlin theme={null}
suspend fun transcribe(audio: AudioInput, options: SttOptions? = null): Transcription
```

## Building an AudioInput

```kotlin theme={null}
AudioInput.pcm16(bytes: ByteArray, sampleRate: Int = 16000, channels: Int = 1)
AudioInput.float32(samples: FloatArray, sampleRate: Int = 16000, channels: Int = 1)
AudioInput.float32Bytes(bytes: ByteArray, sampleRate: Int = 16000, channels: Int = 1)
AudioInput.wav(bytes: ByteArray)
AudioInput.file(path: String)
```

From a recording:

```kotlin theme={null}
val transcription = RunAnywhere.stt.transcribe(AudioInput.file(file.absolutePath))
```

From `AudioRecord` samples:

```kotlin theme={null}
val buffer = ShortArray(bufferSize)
recorder.read(buffer, 0, buffer.size)

val bytes = ByteBuffer.allocate(buffer.size * 2)
    .order(ByteOrder.LITTLE_ENDIAN)
    .apply { asShortBuffer().put(buffer) }
    .array()

val transcription = RunAnywhere.stt.transcribe(AudioInput.pcm16(bytes))
```

`float32Bytes` is the raw-bytes form of `float32`, for when you already hold little-endian
float samples rather than a `FloatArray`.

## With options

```kotlin theme={null}
val transcription = RunAnywhere.stt.transcribe(
    AudioInput.file(path),
    SttOptions(language = "en", punctuation = true, wordTimestamps = true)
)
```

See [STT options](/kotlin/stt/options).

## Checking readiness

```kotlin theme={null}
val state = RunAnywhere.stt.state()
```

## Permission

Recording needs `RECORD_AUDIO` at runtime:

```kotlin theme={null}
if (ContextCompat.checkSelfPermission(context, Manifest.permission.RECORD_AUDIO)
    != PackageManager.PERMISSION_GRANTED) {
    launcher.launch(Manifest.permission.RECORD_AUDIO)
}
```

# Streaming STT

> Transcribe speech as it arrives

Two shapes. Pick by where your audio comes from.

## Push: openStream

You hold a handle and push frames as `AudioRecord` produces them.

```kotlin theme={null}
val stream = RunAnywhere.stt.openStream(
    AudioFormatSpec(encoding = AudioEncoding.PcmF32Le, sampleRate = 16000, channels = 1)
)

// per buffer
stream.pushFrame(AudioFrame(samples = bytes, sampleCount = count))

// when the utterance ends
stream.flush()
stream.finish()
stream.close()
```

## Pull: transcribeStream

You already have a `Flow<AudioInput>`.

```kotlin theme={null}
RunAnywhere.stt.transcribeStream(audioFlow).collect { event ->
    when (event) {
        is TranscriptionEvent.Partial -> preview = event.text
        is TranscriptionEvent.Final -> transcript += event.transcription.text
        else -> {}
    }
}
```

## Signatures

```kotlin theme={null}
fun openStream(format: AudioFormatSpec, options: SttOptions? = null): SttStream
fun transcribeStream(audio: Flow<AudioInput>, options: SttOptions? = null): Flow<TranscriptionEvent>
```

## Driving it from AudioRecord

```kotlin theme={null}
class LiveTranscriber : ViewModel() {
    private val _text = MutableStateFlow("")
    val text = _text.asStateFlow()

    fun start() {
        viewModelScope.launch(Dispatchers.IO) {
            val stream = RunAnywhere.stt.openStream(
                AudioFormatSpec(AudioEncoding.PcmF32Le, 16000, 1)
            )

            val recorder = AudioRecord(/* … */)
            recorder.startRecording()

            try {
                val buffer = ByteArray(4096)
                while (isActive) {
                    val read = recorder.read(buffer, 0, buffer.size)
                    if (read > 0) {
                        stream.pushFrame(AudioFrame(buffer.copyOf(read), read / 4))
                    }
                }
            } finally {
                stream.flush()
                stream.finish()
                stream.close()
                recorder.stop()
                recorder.release()
            }
        }
    }
}
```

Always release the recorder and close the stream in a `finally`. A leaked `AudioRecord` holds
the microphone for the whole process.

## Choosing between them

Push suits a live microphone, since `AudioRecord` already hands you buffers in a loop. Pull
suits a source you can express as a `Flow`, such as a file read in chunks or audio arriving
over the network.

# STT Options

> Configure transcription

```kotlin theme={null}
val options = SttOptions(
    language = "en",
    punctuation = true,
    wordTimestamps = true,
    diarization = false,
    maxSpeakers = null,
    translateToEnglish = false
)

val transcription = RunAnywhere.stt.transcribe(audio, options)
```

## Fields

| Field                | Type      | Default                   | Meaning                          |
|----------------------|-----------|---------------------------|----------------------------------|
| `language`           | `String?` | none, auto-detect         | BCP-47 code such as `"en"`       |
| `punctuation`        | `Boolean` | `DEFAULT_PUNCTUATION`     | Insert punctuation and casing    |
| `wordTimestamps`     | `Boolean` | `DEFAULT_WORD_TIMESTAMPS` | Per-word timings                 |
| `diarization`        | `Boolean` | `false`                   | Attribute speech to speakers     |
| `maxSpeakers`        | `Int?`    | none                      | Cap the speaker count            |
| `translateToEnglish` | `Boolean` | `false`                   | Translate rather than transcribe |

The two defaults are public constants read from the proto defaults, so reference them rather
than a literal:

```kotlin theme={null}
SttOptions.DEFAULT_PUNCTUATION
SttOptions.DEFAULT_WORD_TIMESTAMPS
```

## Language

Leave `language` unset to auto-detect. Set it when you know the language: detection costs time
and picks wrong on short clips.

## Word timestamps

```kotlin theme={null}
SttOptions(wordTimestamps = true)
```

Use these for captions, or to seek a player to a spoken word.

## Diarization

`diarization = true` labels speakers inside the transcription. For a standalone "who spoke
when" answer over a recording, use the diarization namespace:

```kotlin theme={null}
val result = RunAnywhere.diarization.diarize(AudioInput.file(path))
```

## Translation

`translateToEnglish = true` returns English regardless of the source language.

# synthesize()

> Turn text into audio

```kotlin theme={null}
// Get the audio back
val audio = RunAnywhere.tts.synthesize("Hello from RunAnywhere")

// Play it
val handle = RunAnywhere.tts.speak("Hello from RunAnywhere")
```

## Signatures

```kotlin theme={null}
suspend fun synthesize(text: String, options: TtsOptions? = null): Audio
fun synthesizeStream(text: String, options: TtsOptions? = null): Flow<AudioChunk>
fun speak(text: String, options: TtsOptions? = null): SpeechHandle
suspend fun stop()
suspend fun voices(): List<Voice>
```

`synthesize` returns audio to save or feed elsewhere. `speak` plays it and returns a handle.
`speak` is **not** suspending; it returns immediately.

## Options

```kotlin theme={null}
val audio = RunAnywhere.tts.synthesize(
    "Hello",
    TtsOptions(voice = "en_US-amy-medium", speed = 1.1f)
)
```

| Field        | Type          | Default               |
|--------------|---------------|-----------------------|
| `voice`      | `String?`     | none, model default   |
| `language`   | `String`      | `DEFAULT_LANGUAGE`    |
| `speed`      | `Float`       | `DEFAULT_SPEED`       |
| `pitch`      | `Float`       | `DEFAULT_PITCH`       |
| `format`     | `AudioFormat` | `DEFAULT_FORMAT`      |
| `sampleRate` | `Int`         | `DEFAULT_SAMPLE_RATE` |

All five defaults are public constants on `TtsOptions`, read from the proto defaults.

## Stopping

```kotlin theme={null}
RunAnywhere.tts.stop()
```

Stops whatever is speaking, without needing the handle.

## Saving to a file

```kotlin theme={null}
val audio = RunAnywhere.tts.synthesize("Save me")
File(context.filesDir, "out.wav").writeBytes(audio.samples)
```

# Streaming TTS

> Start speaking before the whole text is synthesized

`synthesizeStream` emits `AudioChunk` values as they are produced, so playback starts on the
first chunk instead of the last.

```kotlin theme={null}
RunAnywhere.tts.synthesizeStream(longText).collect { chunk ->
    player.enqueue(chunk)
}
```

## Signature

```kotlin theme={null}
fun synthesizeStream(text: String, options: TtsOptions? = null): Flow<AudioChunk>
```

## When it is worth it

For a sentence, `speak` is simpler and the latency difference is invisible. For a paragraph,
or for a model reply being streamed as it generates, streaming synthesis is what keeps the gap
between "the model finished" and "the user hears something" short.

## Pairing it with a streaming completion

Speak each sentence as the model finishes it:

```kotlin theme={null}
val sentence = StringBuilder()

RunAnywhere.llm.generateStream(prompt).collect { event ->
    if (event !is GenerationEvent.Token) return@collect
    sentence.append(event.text)

    if (event.text.any { it in ".!?" }) {
        RunAnywhere.tts.speak(sentence.toString())
        sentence.clear()
    }
}

if (sentence.isNotEmpty()) RunAnywhere.tts.speak(sentence.toString())
```

For a full conversation rather than one reply, use the [voice session](/kotlin/voice-agent),
which handles turn-taking and interruption for you.

## Feeding AudioTrack

```kotlin theme={null}
val track = AudioTrack.Builder()
    .setAudioFormat(
        AudioFormat.Builder()
            .setEncoding(AudioFormat.ENCODING_PCM_FLOAT)
            .setSampleRate(22050)
            .setChannelMask(AudioFormat.CHANNEL_OUT_MONO)
            .build()
    )
    .setTransferMode(AudioTrack.MODE_STREAM)
    .build()

track.play()

RunAnywhere.tts.synthesizeStream(text).collect { chunk ->
    track.write(chunk.samples, 0, chunk.samples.size, AudioTrack.WRITE_BLOCKING)
}

track.stop()
track.release()
```

Release the track when you are done. It holds an audio output.

# Voices

> List and select a speaking voice

```kotlin theme={null}
val voices = RunAnywhere.tts.voices()
```

## Signature

```kotlin theme={null}
suspend fun voices(): List<Voice>
```

The list reflects the loaded speech model, so call it after the model is in place rather than
at launch. Load a different TTS model and the list changes.

## Selecting one

```kotlin theme={null}
val handle = RunAnywhere.tts.speak(
    "Hello",
    TtsOptions(voice = "en_US-amy-medium")
)
```

With `voice` unset, the model's own default is used.

## Language and voice are separate

`language` sets the language code; `voice` picks a speaker. A multi-voice model exposes
several speakers for one language, and a single-voice model ignores `voice` entirely.

```kotlin theme={null}
TtsOptions(
    voice = "en_US-amy-medium",
    language = "en-US",
    speed = 1.0f,
    pitch = 1.0f
)
```

## Letting a person choose

```kotlin theme={null}
class VoicePicker : ViewModel() {
    private val _voices = MutableStateFlow<List<Voice>>(emptyList())
    val voices = _voices.asStateFlow()

    var selected: String? = null

    fun load() {
        viewModelScope.launch {
            _voices.value = RunAnywhere.tts.voices()
        }
    }

    fun preview() {
        val voice = selected ?: return
        viewModelScope.launch {
            RunAnywhere.tts.speak("This is how I sound.", TtsOptions(voice = voice))
        }
    }
}
```

# Voice Activity Detection

> Find speech in audio

`RunAnywhere.vad` answers "is someone talking right now". It is what a voice interface uses to
decide when a turn has ended.

```kotlin theme={null}
val result = RunAnywhere.vad.detect(AudioInput.file(path))
```

## Signatures

```kotlin theme={null}
suspend fun detect(audio: AudioInput, options: VadOptions? = null): VadResult
fun openStream(format: AudioFormatSpec, options: VadOptions? = null): VadStream
fun detectStream(audio: Flow<AudioInput>, options: VadOptions? = null): Flow<VadEvent>
```

## Streaming from a microphone

```kotlin theme={null}
val stream = RunAnywhere.vad.openStream(
    AudioFormatSpec(AudioEncoding.PcmF32Le, 16000, 1)
)

// per buffer
stream.pushFrame(AudioFrame(bytes, count))

// when done
stream.flush()
stream.finish()
stream.close()
```

## Streaming from a Flow

```kotlin theme={null}
RunAnywhere.vad.detectStream(audioFlow).collect { event ->
    when (event) {
        is VadEvent.SpeechStart -> isSpeaking = true
        is VadEvent.SpeechEnd -> isSpeaking = false
        else -> {}
    }
}
```

## Options

```kotlin theme={null}
val options = VadOptions(
    activationThreshold = 0.5f,
    minSpeechMs = 250,
    minSilenceMs = 500,
    prefixPaddingMs = 300
)
```

| Field                 | Default                  | Meaning                                  |
|-----------------------|--------------------------|------------------------------------------|
| `activationThreshold` | model default            | How confident before it counts as speech |
| `minSpeechMs`         | `DEFAULT_MIN_SPEECH_MS`  | Ignore bursts shorter than this          |
| `minSilenceMs`        | `DEFAULT_MIN_SILENCE_MS` | Silence before a turn is over            |
| `prefixPaddingMs`     | proto default            | Audio kept from before speech started    |

`minSilenceMs` is the one to tune. Too short and the assistant interrupts someone who paused
to think; too long and it feels sluggish.

`prefixPaddingMs` matters because detection lags the first syllable. Without padding, "hello"
reaches the transcriber as "ello".

## You may not need this

For a spoken conversation, use the [voice session](/kotlin/voice-agent). It runs VAD,
transcription, generation, and speech together, with turn-taking and interruption already
wired up.

# Voice Agent

> A full spoken conversation

`RunAnywhere.voice` assembles speech-to-text, a language model, and text-to-speech into one
session that listens, thinks, and answers out loud. It owns the microphone while it runs.

```kotlin theme={null}
val session = RunAnywhere.voice.createSession(
    stt = ModelRef("whisper-base"),
    llm = ModelRef("qwen3-0.6b"),
    tts = ModelRef("piper-en-amy")
)

session.start()

session.events.collect { event ->
    when (event) {
        is VoiceEvent.UserTranscript -> transcript += "user: ${event.text}"
        is VoiceEvent.AssistantText -> transcript += "assistant: ${event.text}"
        else -> {}
    }
}
```

## Signature

```kotlin theme={null}
suspend fun createSession(
    stt: ModelRef,
    llm: ModelRef,
    tts: ModelRef,
    vad: VadOptions? = null,
    turnHandling: TurnHandlingOptions? = null,
    generation: LlmOptions? = null,
    downloadIfNeeded: Boolean = true
): VoiceSession
```

Leaving `vad` unset ensures the catalogued default Silero VAD. `downloadIfNeeded` defaults to
`true`, so any of the three models that is missing is fetched first.

## VoiceSession

```kotlin theme={null}
val events: Flow<VoiceEvent>
fun start()
fun say(text: String): SpeechHandle
suspend fun interrupt()
fun close()
```

`say` speaks a line without waiting for the user, which is how you greet someone.
`interrupt` cuts off whatever is being spoken.

Always `close()` the session. It holds the microphone.

## Turn handling

```kotlin theme={null}
val session = RunAnywhere.voice.createSession(
    stt = sttModel,
    llm = llmModel,
    tts = ttsModel,
    turnHandling = TurnHandlingOptions(
        endpointing = Endpointing(minDelayMs = 500, maxDelayMs = 3000),
        interruption = Interruption(enabled = true, minDurationMs = 500)
    )
)
```

| Setting                      | Default | Meaning                                    |
|------------------------------|---------|--------------------------------------------|
| `endpointing.minDelayMs`     | 500     | Shortest silence that ends a turn          |
| `endpointing.maxDelayMs`     | 3000    | Longest wait before ending it anyway       |
| `interruption.enabled`       | true    | A person talking over the model stops it   |
| `interruption.minDurationMs` | 500     | Speech this long counts as an interruption |

Raise `interruption.minDurationMs` in a noisy room, or a cough cuts the model off.

## Steering the replies

```kotlin theme={null}
generation = LlmOptions(
    systemPrompt = "You are a voice assistant. Answer in one or two sentences.",
    maxOutputTokens = 100
)
```

Spoken replies want to be short. A model that writes four paragraphs is unbearable to listen
to, so cap `maxOutputTokens` lower than you would for a chat interface.

## A complete ViewModel

```kotlin theme={null}
class VoiceAgentViewModel(app: Application) : AndroidViewModel(app) {
    private val _transcript = MutableStateFlow<List<Pair<String, String>>>(emptyList())
    val transcript = _transcript.asStateFlow()

    private var session: VoiceSession? = null

    fun start() {
        viewModelScope.launch {
            val s = RunAnywhere.voice.createSession(
                stt = ModelRef("whisper-base"),
                llm = ModelRef("qwen3-0.6b"),
                tts = ModelRef("piper-en-amy"),
                generation = LlmOptions(
                    systemPrompt = "Answer in one or two sentences.",
                    maxOutputTokens = 100
                )
            )
            session = s

            s.start()
            s.say("Hello. What can I help with?")

            s.events.collect { event ->
                when (event) {
                    is VoiceEvent.UserTranscript ->
                        _transcript.value += "user" to event.text
                    is VoiceEvent.AssistantText ->
                        _transcript.value += "assistant" to event.text
                    else -> {}
                }
            }
        }
    }

    override fun onCleared() {
        session?.close()
        session = null
        super.onCleared()
    }
}
```

Closing in `onCleared` is what stops the microphone when the screen goes away.

## Permission

`RECORD_AUDIO` has to be granted at runtime before `start()`:

```kotlin theme={null}
if (ContextCompat.checkSelfPermission(context, Manifest.permission.RECORD_AUDIO)
    != PackageManager.PERMISSION_GRANTED) {
    launcher.launch(Manifest.permission.RECORD_AUDIO)
}
```

## Diarization

To answer "who spoke when" over a recording rather than run a live conversation:

```kotlin theme={null}
val result = RunAnywhere.diarization.diarize(AudioInput.file(path))
```

# Diarization

> Work out who spoke when

Diarization segments a recording by speaker. It answers "who spoke when", not "what did they
say"; pair it with [transcription](/kotlin/stt/transcribe) for both.

```kotlin theme={null}
val result = RunAnywhere.diarization.diarize(AudioInput.file(path))
```

## Options

| Field               | Meaning                                                        |
|---------------------|----------------------------------------------------------------|
| `threshold`         | How different two voices must be to count as separate speakers |
| `minimumDurationMs` | Ignore segments shorter than this                              |
| `mergeGapMs`        | Join two segments from one speaker separated by less than this |

`mergeGapMs` is the one to tune. Natural speech has pauses inside a turn, and without merging
you get one speaker fragmented into a dozen segments.

## Diarization inside transcription

For a transcript labelled by speaker rather than a separate segment list, ask the STT namespace
instead:

```kotlin theme={null}
val transcription = RunAnywhere.stt.transcribe(
    audio,
    SttOptions(diarization = true, maxSpeakers = 2)
)
```

Use the STT route when you want a readable transcript. Use the diarization namespace when you
want timing, for example to drive a speaker timeline or to split a recording into per-speaker
files.

## Knowing the speaker count helps

`maxSpeakers` on the STT path, and a sensible `threshold` here, both improve accuracy a lot
when you know how many people are in the room. Diarization over-segments when left to guess.

Kotlin has no streaming diarizer. Diarize a completed recording, or use the STT path with
`diarization = true` for live labelling.
