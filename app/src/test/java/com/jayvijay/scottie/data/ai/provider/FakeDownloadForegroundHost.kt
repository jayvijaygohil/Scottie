package com.jayvijay.scottie.data.ai.provider

class FakeDownloadForegroundHost(var startResult: Boolean = true) : DownloadForegroundHost {
  var startCount = 0
    private set

  override fun start(): Boolean {
    startCount++
    return startResult
  }
}
