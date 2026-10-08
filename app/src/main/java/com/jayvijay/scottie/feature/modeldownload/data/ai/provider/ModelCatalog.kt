@file:Suppress("MaxLineLength", "MagicNumber")

package com.jayvijay.scottie.feature.modeldownload.data.ai.provider

import ai.runanywhere.proto.v1.ArchiveStructure
import ai.runanywhere.proto.v1.ArchiveType
import ai.runanywhere.proto.v1.InferenceFramework
import ai.runanywhere.proto.v1.ModelCategory
import com.jayvijay.scottie.feature.modeldownload.domain.entities.Model
import com.jayvijay.scottie.feature.modeldownload.domain.entities.ModelType

/** One downloadable catalog row and the shape its runtime registers it with. */
sealed interface CatalogModel {
  val id: String
  val name: String
  val type: ModelType

  /** RAM needed to run the model; 0 or less when unknown. */
  val memoryBytes: Long

  /** Null when unknown. */
  val downloadBytes: Long?
}

/** A LiteRT general (CPU) build. [id] is the local file name and the Koog `LLModel.id`. */
data class LiteRtModel(
  override val id: String,
  override val name: String,
  val url: String,
  override val downloadBytes: Long,
  override val memoryBytes: Long,
  val requiresToken: Boolean,
) : CatalogModel {
  override val type: ModelType
    get() = ModelType.TEXT
}

data class ModelFile(
  val url: String,
  val filename: String,
  val sizeBytes: Long? = null,
  val checksumSha256: String? = null,
)

/** Sherpa-ONNX rows on RunAnywhere; all are speech-to-text. */
data class ArchiveModel(
  override val id: String,
  override val name: String,
  val url: String,
  val framework: InferenceFramework,
  val category: ModelCategory,
  override val memoryBytes: Long,
  val archiveType: ArchiveType,
  val structure: ArchiveStructure,
) : CatalogModel {
  override val downloadBytes: Long? = null
  override val type: ModelType
    get() = ModelType.SPEECH_RECOGNITION
}

data class MultiFileModel(
  override val id: String,
  override val name: String,
  val framework: InferenceFramework,
  val category: ModelCategory,
  override val memoryBytes: Long,
  override val downloadBytes: Long = memoryBytes,
  val files: List<ModelFile>,
) : CatalogModel {
  override val type: ModelType
    get() = ModelType.SPEECH_RECOGNITION
}

fun CatalogModel.toModel(): Model =
  Model(
    id = id,
    name = displayTitle(id, name),
    type = type,
    downloadBytes = downloadBytes,
    description = familyDescription("$id $name"),
    memoryBytes = memoryBytes.takeIf { it > 0 },
    requiresToken = this is LiteRtModel && requiresToken,
  )

object StaticModelCatalog {
  private val SHERPA = InferenceFramework.INFERENCE_FRAMEWORK_SHERPA
  private val STT = ModelCategory.MODEL_CATEGORY_SPEECH_RECOGNITION
  private val TAR_GZ = ArchiveType.ARCHIVE_TYPE_TAR_GZ

  /** A pinned `litert-community` file; sizes are the repo's `lfs.size`. */
  private fun hf(
    name: String,
    repo: String,
    commit: String,
    file: String,
    sizeBytes: Long,
    requiresToken: Boolean = false,
  ) =
    LiteRtModel(
      id = file,
      name = name,
      url = "https://huggingface.co/litert-community/$repo/resolve/$commit/$file",
      downloadBytes = sizeBytes,
      // ponytail: heuristic until LiteRT publishes RAM needs
      memoryBytes = (sizeBytes * 13) / 10,
      requiresToken = requiresToken,
    )

  private val litert: List<CatalogModel> =
    listOf(
      hf(
        "Gemma 4 E2B",
        "gemma-4-E2B-it-litert-lm",
        "b3ca0d2f076785a8f4b2219ddbd2bdb99954eae1",
        "gemma-4-E2B-it.litertlm",
        2_588_147_712,
      ),
      hf(
        "Gemma 4 E4B",
        "gemma-4-E4B-it-litert-lm",
        "2eee7ac325f20eb8c9ac1d0e972f7c84663062da",
        "gemma-4-E4B-it.litertlm",
        3_659_530_240,
      ),
      hf(
        "Gemma 4 12B",
        "gemma-4-12B-it-litert-lm",
        "7a0b1ce0ea821bcd01c5f72af84155e02191152f",
        "gemma-4-12B-it.litertlm",
        6_883_278_368,
      ),
      hf(
        "Qwen3 0.6B",
        "Qwen3-0.6B",
        "a3c5d805ae362dff7f580bc25f2dfb9a5a7eaa76",
        "Qwen3-0.6B.litertlm",
        614_236_160,
      ),
      hf(
        "Qwen3.5 2B",
        "Qwen3.5-2B",
        "4327b7425533c26da2aec1d7b915e9742eead2cb",
        "Qwen3.5-2B_int8.litertlm",
        2_116_592_816,
      ),
      hf(
        "DeepSeek R1 Distill Qwen 1.5B",
        "DeepSeek-R1-Distill-Qwen-1.5B",
        "2f8b8ee90d8f93b15305b699e8772b277d074a9a",
        "DeepSeek-R1-Distill-Qwen-1.5B_multi-prefill-seq_q8_ekv4096.litertlm",
        1_833_451_520,
      ),
      hf(
        "MiniCPM5 2B",
        "MiniCPM5-2B",
        "f6dd64ef6e117fc6e8af6891ae2096caa3e85a4e",
        "MiniCPM5-2B_int4.litertlm",
        1_553_670_064,
      ),
      hf(
        "Gemma 3 1B",
        "Gemma3-1B-IT",
        "a6306a4e292016480083b73b8dc6f3f939ae04c3",
        "gemma3-1b-it-int4.litertlm",
        584_417_280,
        requiresToken = true,
      ),
      hf(
        "Gemma 3 270M",
        "gemma-3-270m-it",
        "9d2093270fb5aa49a986b49b5779d763dde7b630",
        "gemma3-270m-it-q8.litertlm",
        304_005_120,
        requiresToken = true,
      ),
      hf(
        "FunctionGemma 270M",
        "functiongemma-270m-ft-mobile-actions",
        "f752a74080682b379823794defdbbdf8c2663609",
        "mobile_actions_q8_ekv1024.litertlm",
        288_964_608,
        requiresToken = true,
      ),
    )

  private val stt: List<CatalogModel> =
    listOf(
      // --- STT (Sherpa-ONNX) ------------------------------------------------
      // Canary (NVIDIA)
      MultiFileModel(
        "sherpa-nemo-canary-180m-flash-int8",
        "NVIDIA Canary 180M Flash INT8 (Sherpa-ONNX)",
        SHERPA,
        STT,
        207_170_046,
        files =
          listOf(
            ModelFile(
              "https://huggingface.co/csukuangfj/sherpa-onnx-nemo-canary-180m-flash-en-es-de-fr-int8/resolve/9077164e0d3dd1d5353743e89ceaa1d3a770838c/encoder.int8.onnx",
              "encoder.int8.onnx",
              132_678_643,
            ),
            ModelFile(
              "https://huggingface.co/csukuangfj/sherpa-onnx-nemo-canary-180m-flash-en-es-de-fr-int8/resolve/9077164e0d3dd1d5353743e89ceaa1d3a770838c/decoder.int8.onnx",
              "decoder.int8.onnx",
              74_437_848,
            ),
            ModelFile(
              "https://huggingface.co/csukuangfj/sherpa-onnx-nemo-canary-180m-flash-en-es-de-fr-int8/resolve/9077164e0d3dd1d5353743e89ceaa1d3a770838c/tokens.txt",
              "tokens.txt",
              53_555,
            ),
          ),
      ),
      // Parakeet (NVIDIA)
      // Official sherpa-onnx exports of the NVIDIA NeMo parakeet-tdt_ctc
      // checkpoints, published upstream with complete metadata. Only the CTC
      // branch is exported, so the single `model[.int8].onnx` + `tokens.txt`
      // layout routes through the backend's NeMo CTC path.
      MultiFileModel(
        "sherpa-nemo-parakeet-tdt-ctc-110m-en-int8",
        "NVIDIA Parakeet TDT-CTC 110M EN (Sherpa-ONNX)",
        SHERPA,
        STT,
        memoryBytes = 1_024L * 1_024L * 1_024L,
        downloadBytes = 458_170_974,
        files =
          listOf(
            ModelFile(
              "https://huggingface.co/csukuangfj/sherpa-onnx-nemo-parakeet_tdt_ctc_110m-en-36000/resolve/3af92f152d32c836acabf38f4c993bc96b80eb2d/model.onnx",
              "model.onnx",
              458_161_021,
              "936806cf3dd0db5aba53f8c7410bb5632d7a8ad6b2c51009f5e4fc0890ec76bf",
            ),
            ModelFile(
              "https://huggingface.co/csukuangfj/sherpa-onnx-nemo-parakeet_tdt_ctc_110m-en-36000/resolve/3af92f152d32c836acabf38f4c993bc96b80eb2d/tokens.txt",
              "tokens.txt",
              9_953,
            ),
          ),
      ),
      MultiFileModel(
        "sherpa-nemo-parakeet-tdt-ctc-0.6b-ja-int8",
        "NVIDIA Parakeet TDT-CTC 0.6B Japanese INT8 (Sherpa-ONNX)",
        SHERPA,
        STT,
        memoryBytes = 1_536L * 1_024L * 1_024L,
        downloadBytes = 655_571_161,
        files =
          listOf(
            ModelFile(
              "https://huggingface.co/csukuangfj/sherpa-onnx-nemo-parakeet-tdt_ctc-0.6b-ja-35000-int8/resolve/bef18eb066808c90bd0f5df5be685767b0732de8/model.int8.onnx",
              "model.int8.onnx",
              655_542_604,
              "3addd00ef5bd1742078389e540b77394e4a508bdf2f4c9ad1b4a76d93e76598e",
            ),
            ModelFile(
              "https://huggingface.co/csukuangfj/sherpa-onnx-nemo-parakeet-tdt_ctc-0.6b-ja-35000-int8/resolve/bef18eb066808c90bd0f5df5be685767b0732de8/tokens.txt",
              "tokens.txt",
              28_557,
            ),
          ),
      ),
      MultiFileModel(
        "sherpa-nemo-parakeet-tdt-0.6b-v2-int8",
        "NVIDIA Parakeet TDT 0.6B v2 INT8 (Sherpa-ONNX)",
        SHERPA,
        STT,
        661_190_513,
        files =
          listOf(
            ModelFile(
              "https://huggingface.co/csukuangfj/sherpa-onnx-nemo-parakeet-tdt-0.6b-v2-int8/resolve/1ab9323565ddb038682214b292f588070a538ce2/encoder.int8.onnx",
              "encoder.int8.onnx",
              652_184_296,
            ),
            ModelFile(
              "https://huggingface.co/csukuangfj/sherpa-onnx-nemo-parakeet-tdt-0.6b-v2-int8/resolve/1ab9323565ddb038682214b292f588070a538ce2/decoder.int8.onnx",
              "decoder.int8.onnx",
              7_257_753,
            ),
            ModelFile(
              "https://huggingface.co/csukuangfj/sherpa-onnx-nemo-parakeet-tdt-0.6b-v2-int8/resolve/1ab9323565ddb038682214b292f588070a538ce2/joiner.int8.onnx",
              "joiner.int8.onnx",
              1_739_080,
            ),
            ModelFile(
              "https://huggingface.co/csukuangfj/sherpa-onnx-nemo-parakeet-tdt-0.6b-v2-int8/resolve/1ab9323565ddb038682214b292f588070a538ce2/tokens.txt",
              "tokens.txt",
              9_384,
            ),
          ),
      ),
      MultiFileModel(
        "sherpa-nemo-parakeet-tdt-0.6b-v3-int8",
        "NVIDIA Parakeet TDT 0.6B v3 INT8 (Sherpa-ONNX)",
        SHERPA,
        STT,
        670_478_772,
        files =
          listOf(
            ModelFile(
              "https://huggingface.co/csukuangfj/sherpa-onnx-nemo-parakeet-tdt-0.6b-v3-int8/resolve/2bda32ec70b097a55adaa07d9a7173915b43cc78/encoder.int8.onnx",
              "encoder.int8.onnx",
              652_184_281,
            ),
            ModelFile(
              "https://huggingface.co/csukuangfj/sherpa-onnx-nemo-parakeet-tdt-0.6b-v3-int8/resolve/2bda32ec70b097a55adaa07d9a7173915b43cc78/decoder.int8.onnx",
              "decoder.int8.onnx",
              11_845_275,
            ),
            ModelFile(
              "https://huggingface.co/csukuangfj/sherpa-onnx-nemo-parakeet-tdt-0.6b-v3-int8/resolve/2bda32ec70b097a55adaa07d9a7173915b43cc78/joiner.int8.onnx",
              "joiner.int8.onnx",
              6_355_277,
            ),
            ModelFile(
              "https://huggingface.co/csukuangfj/sherpa-onnx-nemo-parakeet-tdt-0.6b-v3-int8/resolve/2bda32ec70b097a55adaa07d9a7173915b43cc78/tokens.txt",
              "tokens.txt",
              93_939,
            ),
          ),
      ),
      // The upstream OpenVoiceOS export omits three metadata_props entries
      // Sherpa requires, so it cannot be loaded as published. This repo is
      // that export with the entries added; provenance and a reproduction
      // script live in its model card. Runtime RAM is based on the observed
      // Android PSS (~1,760,875 KB), not the smaller aggregate download size.
      MultiFileModel(
        "sherpa-nemo-parakeet-ctc-1.1b-int8",
        "NVIDIA Parakeet CTC 1.1B INT8 (Sherpa-ONNX)",
        SHERPA,
        STT,
        memoryBytes = 2L * 1_024L * 1_024L * 1_024L,
        downloadBytes = 1_110_024_519,
        files =
          listOf(
            ModelFile(
              "https://huggingface.co/runanywhere/sherpa-onnx-nemo-parakeet-ctc-1.1b-int8/resolve/48a549f552774db3cd09dd1548f3d1a2b37bc7c5/model.int8.onnx",
              "model.int8.onnx",
              1_110_014_145,
              "62f73c17a5301c048c7273cf24ef1cd0c3621d3625c5415fbafe5633d7bf2f98",
            ),
            ModelFile(
              "https://huggingface.co/runanywhere/sherpa-onnx-nemo-parakeet-ctc-1.1b-int8/resolve/48a549f552774db3cd09dd1548f3d1a2b37bc7c5/tokens.txt",
              "tokens.txt",
              10_374,
              "ed16e1a4e3a3aa379138c0b1888e5d49f993c9d512b2be4d46e90a87afd54921",
            ),
          ),
      ),
      // Whisper
      ArchiveModel(
        "sherpa-onnx-whisper-tiny.en",
        "Sherpa Whisper Tiny (ONNX)",
        "https://github.com/RunanywhereAI/sherpa-onnx/releases/download/runanywhere-models-v1/sherpa-onnx-whisper-tiny.en.tar.gz",
        SHERPA,
        ModelCategory.MODEL_CATEGORY_SPEECH_RECOGNITION,
        75_000_000,
        TAR_GZ,
        ArchiveStructure.ARCHIVE_STRUCTURE_NESTED_DIRECTORY,
      ),
    )

  /** LiteRT text rows, then the speech-to-text rows. */
  val models: List<CatalogModel> = litert + stt
}
