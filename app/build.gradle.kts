plugins {
  alias(libs.plugins.android.application)
  alias(libs.plugins.kotlin.compose)
  alias(libs.plugins.kotlin.serialization)
  alias(libs.plugins.kotlin.parcelize)
  alias(libs.plugins.ksp)
  alias(libs.plugins.hilt)
  alias(libs.plugins.detekt)
}

detekt {
  buildUponDefaultConfig = true
  config.setFrom(files("$rootDir/config/detekt/detekt.yml"))
}

android {
  namespace = "com.jayvijay.scottie"

  compileSdk {
    version =
        release(37) {
          minorApiLevel = 1
        }
  }

  defaultConfig {
    applicationId = "com.jayvijay.scottie"
    minSdk = 26
    targetSdk = 37
    versionCode = 1
    versionName = "0.1.0"

    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
  }

  buildTypes {
    release {
      optimization {
        enable = false
      }
    }
  }

  compileOptions {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
  }

  buildFeatures {
    compose = true
  }

  testOptions {
    unitTests {
      isReturnDefaultValues = true
      isIncludeAndroidResources = true
    }
  }

  packaging {
    jniLibs {
      useLegacyPackaging = true
    }
  }
}

ksp {
  arg("circuit.codegen.mode", "hilt")
}

dependencies {
  detektPlugins(libs.compose.rules.detekt)

  implementation(libs.androidx.core.ktx)
  implementation(libs.androidx.lifecycle.runtime.ktx)

  implementation(libs.androidx.activity.compose)
  implementation(libs.androidx.compose.material3)
  implementation(libs.compose.icons.core)
  implementation(libs.compose.icons.extended)
  implementation(libs.androidx.compose.ui)
  implementation(libs.androidx.compose.ui.graphics)
  implementation(libs.androidx.compose.ui.tooling.preview)

  implementation(libs.bundles.circuit)
  implementation(libs.bundles.circuitx)
  implementation(libs.circuit.codegen.annotations)
  ksp(libs.circuit.codegen)

  @Suppress("AvoidDuplicateDependencies")
  ksp(libs.hilt.compiler)
  implementation(libs.hilt.android)

  implementation(libs.koog.agents)
  implementation(libs.koog.agents.additions)

  implementation(libs.a2ui.material3)
  implementation(libs.a2ui.compose.runtime)
  implementation(libs.a2ui.compose.ui)
  implementation(libs.a2ui.engine)
  implementation(libs.a2ui.model)

  implementation(libs.runanywhere.sdk)
  implementation(libs.runanywhere.onnx)

  testImplementation(libs.junit)

  @Suppress("AvoidDuplicateDependencies")
  kspTest(libs.hilt.compiler)
  testImplementation(libs.hilt.android.testing)

  testImplementation(libs.koog.agents.test)

  testImplementation(libs.circuit.test)
  testImplementation(libs.turbine)

  testImplementation(libs.kotlinx.coroutines.test)
  testImplementation(libs.androidx.test.core)
  @Suppress("AvoidDuplicateDependencies")
  testImplementation(libs.androidx.compose.ui.test.junit4)

  androidTestImplementation(libs.androidx.junit)
  androidTestImplementation(libs.androidx.espresso.core)
  @Suppress("AvoidDuplicateDependencies")
  androidTestImplementation(libs.androidx.compose.ui.test.junit4)
  androidTestImplementation(libs.a2ui.compose.ui.testing)

  debugImplementation(libs.androidx.compose.ui.tooling)
  debugImplementation(libs.androidx.compose.ui.test.manifest)
}
