# agents / agents-features / agents-features-trace

Additional Kotlin contracts from the supplied Dokka build. Read [API coverage](../../api-index.md) before use.

## ai.koog.agents.features.tracing.writer.TraceFeatureMessageRemoteWriter.TraceFeatureMessageRemoteWriter

Module: `agents-features-trace`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-trace/ai.koog.agents.features.tracing.writer/-trace-feature-message-remote-writer/-trace-feature-message-remote-writer.html`

### :agents:agents-features:agents-features-trace/commonMain

```kotlin
constructor(connectionConfig: ServerConnectionConfig? = null)
```

- connectionConfig — Optional configuration for the remote server connection. If null, default connection settings will be used.

Referenced packages: `ai.koog.agents.core.feature.remote.server.config`.

## ai.koog.agents.features.tracing.writer.TraceFeatureMessageRemoteWriter

Module: `agents-features-trace`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-trace/ai.koog.agents.features.tracing.writer/-trace-feature-message-remote-writer/index.html`

### :agents:agents-features:agents-features-trace/commonMain

```kotlin
class TraceFeatureMessageRemoteWriter constructor(connectionConfig: ServerConnectionConfig? = null) : FeatureMessageRemoteWriter
```

A message processor that sends trace events to a remote server.

This writer captures all trace events and sends them to a configured remote server. Remote tracing is crucial for evaluation and analysis of the working agent in distributed environments.

Tracing to remote servers is particularly useful for:

Centralized collection and analysis of trace data from multiple agents

Real-time monitoring of agent behavior across distributed systems

Integration with specialized analysis and visualization tools

Sharing trace data with team members or other stakeholders

Example usage:

- connectionConfig — Optional configuration for the remote server connection. If null, default connection settings will be used.

Referenced packages: `ai.koog.agents.core.feature.remote.server.config`, `ai.koog.agents.core.feature.writer`.
