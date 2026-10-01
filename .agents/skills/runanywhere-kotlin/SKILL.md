---
name: runanywhere-kotlin
description: Build, review, and debug on-device AI features on Android with the RunAnywhere Kotlin SDK (io.github.sanchitmonga22:runanywhere-sdk, llamacpp, onnx, qhexrt). Covers Gradle setup, initialization, the RunAnywhere.* namespaces (llm, vlm, stt, tts, vad, voice, rag, models, embeddings, rerank, lora, images, diarization, segmentation), model download/load/unload, streaming Flows, tool calling, structured output, SDKException handling, and Qualcomm Hexagon NPU (QHexRT). Use whenever code imports com.runanywhere.sdk, mentions RunAnywhere, or the user wants local/offline LLM chat, speech-to-text, text-to-speech, a voice agent, on-device RAG, or GGUF/ONNX models running on an Android phone, even if they do not name the SDK.
---

# RunAnywhere Kotlin SDK

Android-only library (not KMP) that runs LLM, speech, vision, and retrieval models on device.
Docs snapshot: SDK 0.20.27, QHexRT 0.20.19 (fetched 2026-10-01). If the project's version
catalog pins a different version, trust the installed artifact's API over this snapshot and
check it with the IDE before writing calls.

## Rules that prevent most mistakes

1. **Two imports, always.** Namespaces are extension properties; without the second import
   `RunAnywhere.llm` is an unresolved reference and the error points at the property, not the
   import.
   ```kotlin
   import com.runanywhere.sdk.public.RunAnywhere
   import com.runanywhere.sdk.public.api.*
   ```
2. **Use namespaces, not flat verbs.** `RunAnywhere.generate`, `RunAnywhere.loadModel`, etc. are
   deprecated. Use `RunAnywhere.llm.generate`, `RunAnywhere.models.load`, ...
   `isInitialized`/`areServicesReady`/`isActive` are deprecated; use `isReady`.
3. **Initialize once in `Application.onCreate()`**:
   `RunAnywhere.initialize(apiKey = "", baseUrl = "")`.
   Empty key = keyless local mode. Phase 2 (auth, telemetry) runs in background;
   `completeServicesInitialization()` awaits it only when needed.
4. **Suspend vs Flow.** `generate`, `transcribe`, `synthesize`, `models.load` are `suspend`.
   `generateStream`, `models.download`, `synthesizeStream`, `transcribeStream` return `Flow`
   and are *not* suspending. `tts.speak` and `stt.openStream` are not suspending either.
5. **Errors are `SDKException`**, thrown from the call or from the Flow collector. Switch on
   `e.code` (`ProtoErrorCode.ERROR_CODE_*`). Never swallow `CancellationException` — rethrow it
   or use Flow `.catch {}`.
6. **Generation auto-loads and auto-downloads** when `LlmOptions(model = "id")` names a model.
   Use `RunAnywhere.models` only to control *when* that cost is paid, show download progress,
   or let a person pick.
7. **Memory is the constraint.** Unload before loading another model of the same category;
   two resident LLMs → `ERROR_CODE_INSUFFICIENT_MEMORY`. Size `LoadOptions.contextLength` to
   real need.
8. **Close what holds hardware or models:** `VoiceSession.close()`, `RagSession.close()`,
   `SttStream`/`VadStream` (`flush()`, `finish()`, `close()`), `AudioRecord`, `AudioTrack` —
   in `finally` or the owner's teardown.
9. **`StructuredOutputMode.CONSTRAINED` throws** (`unsupportedCapability`). Use
   `VALIDATION_ONLY` (default) or `REPAIR`, with low temperature (0.1–0.3).
10. **Check availability before offering a feature:** `RunAnywhere.capabilities()` and its
    `unavailable` list. A namespace existing does not mean a backend or catalog entry serves it
    (especially `images`, `segmentation`, QHexRT).
11. **Device reality:** QHexRT is arm64-v8a only, validated on Hexagon V75/V79/V81, and throws
    rather than falling back when pinned. x86_64 emulators can't run it; measure performance
    on a physical ARM64 device.
12. **Secrets:** `RunAnywhere.setHfToken(token)` for gated Hugging Face repos (including
    `runanywhere/*_HNPU` NPU bundles). Load the token from encrypted storage; never put it in
    source, assets, or logs.
13. **Quote default constants** (`LlmOptions.DEFAULT_MAX_OUTPUT_TOKENS`, `TtsOptions.DEFAULT_SPEED`,
    ...) rather than inventing literal defaults — they come from proto defaults.

## Core shapes

```kotlin
// One-shot
val r = RunAnywhere.llm.generate(prompt, LlmOptions(model = "qwen3-0.6b", maxOutputTokens = 200))
r.text; r.tokensPerSecond

// Stream (collect in a lifecycle-owned scope so cancellation stops generation)
RunAnywhere.llm.generateStream(prompt, options).collect { event ->
    when (event) {
        is GenerationEvent.Token -> append(event.text)
        is GenerationEvent.Completed -> metrics(event.result)
        else -> {}
    }
}

// Chat: System -> systemPrompt, trailing User -> prompt, the rest -> history.
// No user turn throws. Explicit options.systemPrompt beats a System message.
RunAnywhere.llm.generate(
    listOf(
        ChatMessage(ChatRole.System, "..."),
        ChatMessage(ChatRole.User, "...")
    )
)
```

Output caps: classification/extraction 20–50 tokens, chat 150–300, spoken reply ~100,
summary ~150. Small models follow short, concrete system prompts best.

## Gradle

Coordinates live under `io.github.sanchitmonga22`: `runanywhere-sdk` (required),
`runanywhere-llamacpp` (LLM/VLM, GGUF), `runanywhere-onnx` (STT/TTS/VAD/embeddings),
`runanywhere-qhexrt-android` (NPU, separate version 0.20.19). Add only the backends needed —
each AAR is 49–101 MB. Requirements: minSdk 24, compile/target 37, JDK 17, Kotlin 2.4. No NDK.
Manifest: `INTERNET` for downloads, `RECORD_AUDIO` (plus runtime request) for mic input.
If the project uses a version catalog, add entries there and reference aliases from build
scripts. Full snippets: `references/setup-and-configuration.md`.

## Adapting to the host architecture

Doc examples use `ViewModel` + `viewModelScope`. Translate to whatever the project uses
(Circuit presenter, repository in a data layer, Hilt-injected class) rather than introducing
ViewModels. Keep SDK calls behind the project's data/infrastructure boundary when it has one;
the essential properties to preserve are: a lifecycle-owned coroutine scope for collection,
teardown that closes sessions/streams, and SDK exceptions mapped at the boundary.

## Reference routing

Read only the file for the task at hand; each is the docs text for that area.

| Task                                                                                                                                                                                                | Read                                      |
|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|-------------------------------------------|
| Gradle, version catalog, init overloads, `isReady`, events, capabilities, `reset()`                                                                                                                 | `references/setup-and-configuration.md`   |
| List/download (with progress)/load/unload/delete/register models, `LoadOptions`, NPU pinning, HF token, model picker                                                                                | `references/models.md`                    |
| `generate`, `generateStream`, chat history and trimming, system prompts, `generateStructured`, reasoning, tool calling (`llm.tools.register`)                                                       | `references/text-llm.md`                  |
| `transcribe`, `AudioInput`, streaming STT (push `openStream` / pull `transcribeStream`), `SttOptions`, TTS `synthesize`/`speak`/streams/voices, VAD, `voice.createSession` voice agent, diarization | `references/speech.md`                    |
| VLM (`ImageInput`, photo picker, CameraX throttling), image generation, segmentation                                                                                                                | `references/vision.md`                    |
| RAG sessions, embeddings, rerank, LoRA adapters                                                                                                                                                     | `references/retrieval-and-lora.md`        |
| `SDKException` members, error codes and recovery, cancellation, best practices                                                                                                                      | `references/errors-and-best-practices.md` |

When the docs don't show something (e.g. `JsonSchema` construction details, exact result
field names on `SegmentationResult` or structured results), don't guess: inspect the SDK
classes in the IDE/decompiled AAR and say what was verified.
