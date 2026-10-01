package com.jayvijay.scottie.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.runtime.remember
import com.jayvijay.scottie.presentation.features.modeldownload.ModelDownloadScreen
import com.jayvijay.scottie.presentation.ui.ScottieTheme
import com.slack.circuit.backstack.rememberSaveableBackStack
import com.slack.circuit.foundation.Circuit
import com.slack.circuit.foundation.CircuitCompositionLocals
import com.slack.circuit.foundation.NavigableCircuitContent
import com.slack.circuit.foundation.rememberCircuitNavigator
import com.slack.circuit.sharedelements.SharedElementTransitionLayout
import com.slack.circuitx.android.rememberAndroidScreenAwareNavigator
import com.slack.circuitx.gesturenavigation.GestureNavigationDecorationFactory
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
  @Inject lateinit var circuit: Circuit

  @OptIn(ExperimentalSharedTransitionApi::class)
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    enableEdgeToEdge()
    setContent {
      ScottieTheme {
        CircuitCompositionLocals(circuit) {
          val backStack = rememberSaveableBackStack(root = ModelDownloadScreen)
          val navigator =
            rememberAndroidScreenAwareNavigator(
              delegate = rememberCircuitNavigator(backStack, onRootPop = { finish() }),
              context = this@MainActivity,
            )
          val decoratorFactory = remember { GestureNavigationDecorationFactory() }
          SharedElementTransitionLayout {
            NavigableCircuitContent(
              navigator = navigator,
              backStack = backStack,
              decoratorFactory = decoratorFactory,
            )
          }
        }
      }
    }
  }
}
