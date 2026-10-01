# Vision Language Models

> Ask a model about an image

```kotlin theme={null}
val result = RunAnywhere.vlm.generate(
    image = ImageInput.bitmap(bitmap),
    prompt = "What is in this photo?"
)

println(result.text)
```

## Signatures

```kotlin theme={null}
suspend fun generate(
    image: ImageInput,
    prompt: String,
    options: LlmOptions? = null
): GenerationResult
fun generateStream(
    image: ImageInput,
    prompt: String,
    options: LlmOptions? = null
): Flow<GenerationEvent>
```

## Building an ImageInput

```kotlin theme={null}
ImageInput.file(path: String)
ImageInput.bytes(data: ByteArray)
ImageInput.rawRgb(data: ByteArray, width: Int, height: Int)
ImageInput.rawRgba(data: ByteArray, width: Int, height: Int)
ImageInput.bitmap(bitmap: Bitmap)
```

`ImageInput.bitmap` is the Android-native path and the one you will use most.

## From the photo picker

```kotlin theme={null}
val launcher = rememberLauncherForActivityResult(
    ActivityResultContracts.PickVisualMedia()
) { uri ->
    uri ?: return@rememberLauncherForActivityResult
    viewModel.describe(uri)
}
```

```kotlin theme={null}
fun describe(uri: Uri) {
    viewModelScope.launch {
        val bitmap = context.contentResolver.openInputStream(uri).use {
            BitmapFactory.decodeStream(it)
        } ?: return@launch

        val result = RunAnywhere.vlm.generate(
            image = ImageInput.bitmap(bitmap),
            prompt = "Describe this image in one sentence."
        )
        _caption.value = result.text
    }
}
```

## From CameraX

```kotlin theme={null}
imageAnalysis.setAnalyzer(executor) { proxy ->
    val bitmap = proxy.toBitmap()
    proxy.close()

    if (inFlight.compareAndSet(false, true)) {
        viewModelScope.launch {
            try {
                val result = RunAnywhere.vlm.generate(
                    image = ImageInput.bitmap(bitmap),
                    prompt = "What do you see?"
                )
                _caption.value = result.text
            } finally {
                inFlight.set(false)
            }
        }
    }
}
```

Throttle it. A VLM pass costs far more than a camera frame interval, so run one at a time and
drop frames that arrive while a pass is in flight. The `inFlight` guard above is the minimum.

Always `close()` the `ImageProxy`, or the analyzer stalls after a few frames.

## Streaming

```kotlin theme={null}
RunAnywhere.vlm.generateStream(ImageInput.bitmap(bitmap), "Describe this in detail.")
    .collect { event ->
        if (event is GenerationEvent.Token) caption += event.text
    }
```

## Options

`vlm` takes the same `LlmOptions` as `llm`, so `maxOutputTokens`, `temperature`, and
`systemPrompt` all apply.

## Models

VLM runs on the llama.cpp backend, so the model must be a GGUF vision model with its
projector. Add `runanywhere-llamacpp` and pick a VLM entry from the catalog.

# Image Generation

> Generate images on-device

`RunAnywhere.images` generates an image from a prompt.

```kotlin theme={null}
val result = RunAnywhere.images.generate(
    "A lighthouse at dusk, oil painting",
    ImageOptions(
        negativePrompt = "blurry, text, watermark",
        width = 512,
        height = 512,
        steps = 20,
        seed = 42
    )
)
```

## Options

| Field            | Default       | Meaning                                            |
|------------------|---------------|----------------------------------------------------|
| `negativePrompt` | none          | What to avoid                                      |
| `width`          | model default | Output width                                       |
| `height`         | model default | Output height                                      |
| `steps`          | model default | Denoising steps; more is slower and usually better |
| `guidanceScale`  | model default | How closely to follow the prompt                   |
| `seed`           | random        | Fix it to reproduce an image                       |
| `mode`           | generate      | Generate or inpaint                                |
| `reportPartials` | `false`       | Emit intermediate images while streaming           |

## Watching it appear

With `reportPartials` on, the stream emits intermediate images, so you can show the picture
resolving rather than a spinner.

```kotlin theme={null}
RunAnywhere.images.generateStream(
    "A lighthouse at dusk",
    ImageOptions(steps = 20, reportPartials = true)
).collect { event ->
    when (event) {
        is ImageEvent.Partial -> preview = event.image
        is ImageEvent.Completed -> final = event.result
        else -> {}
    }
}
```

## Reproducing an image

Fix the seed and every other option, and the same prompt produces the same image. Without a
fixed seed, it will not.

## Cost

Image generation is the heaviest thing in the SDK. A 512×512 image at 20 steps takes far longer
than a text completion and warms the device noticeably. Run one at a time, show progress, allow
cancellation, and do not put it on a timer.

## Availability

Check before offering it:

```kotlin theme={null}
val capabilities = RunAnywhere.capabilities()
```

A diffusion model has to be registered and a backend has to serve it. The namespace existing
does not mean the catalog has an entry.

# Segmentation

> Find and label regions in an image

Segmentation outlines objects in an image and labels them. Where a
[vision model](/kotlin/vlm) describes a picture in words, segmentation gives you the regions
themselves: a mask per object, with a class and a confidence.

```kotlin theme={null}
val result = RunAnywhere.segmentation.segment(
    ImageInput.bitmap(bitmap),
    SegmentationOptions(includeDiagnosticImage = true)
)
```

## Building the input

```kotlin theme={null}
ImageInput.bitmap(bitmap)      // the Android-native path
ImageInput.file(path)
ImageInput.bytes(data)
ImageInput.rawRgb(data, width, height)
```

## Options

| Field                    | Default | Meaning                                         |
|--------------------------|---------|-------------------------------------------------|
| `includeDiagnosticImage` | `false` | Return a rendered overlay alongside the regions |

Turn the diagnostic image on while you are building the feature: it shows you what the model
actually found, which is much faster than reasoning about mask arrays. Turn it off in
production, since rendering it costs time and memory.

## What comes back

A `SegmentationResult` holds the regions found. Each carries its class label, a confidence,
and the mask itself, so you can draw an outline, crop to the object, or count instances.

## Segmentation or a vision model

| You want                            | Use                |
|-------------------------------------|--------------------|
| A sentence about the picture        | [VLM](/kotlin/vlm) |
| "Is there a dog in this"            | VLM                |
| The exact pixels of the dog         | Segmentation       |
| Object counts, or a crop            | Segmentation       |
| Anything you will draw on the image | Segmentation       |

## Availability

Segmentation needs a registered segmentation model and a backend that serves it. The namespace
existing does not mean the catalog has an entry, so check capabilities before putting it in
front of a user.
