# Complete Kotlin source examples

This collection retains all 340 Kotlin source examples supplied with the Koog 1.3.0 documentation. Every source file is represented once. Names, packages, imports, helper declarations, and cross-example dependencies are retained, with eight documented adaptations for Kotlin-only presentation or an observed example error.

Also retained: [12 additional Kotlin fragments](kotlin-fragments.md) supplied as `.txt` files, including Spring services and Gradle Kotlin DSL.

These are reference snippets, not one application or a claim that every sample compiles unchanged. Five upstream examples contain application `TODO` placeholders. Protocol adapter APIs and some helper imports are absent from the supplied Dokka build. Examples have been inventoried, scanned for imports/dependencies, and checked for retention; they have not been compiled as a complete project or run against providers. Read [version/source caveats](version-and-migration.md) and use the target application's build when implementing a sample.

Choose a topic below, then open the source file and any listed peer examples. Do not load all 340 examples for an ordinary task. The compact [implementation examples](examples.md) remain useful starting points; this collection supplies their broader source context.

```sh
python3 scripts/lookup.py example structured-data
python3 scripts/lookup.py example example-structured-data-07.kt
```

The [manifest](example-manifest.json) records a digest of every original source, retained file digests, explicit adaptations, required peer examples, associated guides, placeholders, and imports with no exact API entry. An unmatched import is a documentation coverage gap, not proof of an invalid import.

## Topics

| Topic | Files |
| --- | ---: |
| [agent-client-protocol](#agent-client-protocol) | 6 |
| [agent-config](#agent-config) | 2 |
| [agent-persistence](#agent-persistence) | 10 |
| [annotation-based-tools](#annotation-based-tools) | 9 |
| [basic](#basic) | 5 |
| [basic-additional](#basic-additional) | 1 |
| [built-in-tools](#built-in-tools) | 1 |
| [cache-control](#cache-control) | 8 |
| [class-based-tools](#class-based-tools) | 3 |
| [class-based-tools-metadata](#class-based-tools-metadata) | 2 |
| [content-moderation](#content-moderation) | 8 |
| [creating-prompts](#creating-prompts) | 10 |
| [custom-features](#custom-features) | 6 |
| [custom-nodes](#custom-nodes) | 11 |
| [custom-strategy-graphs](#custom-strategy-graphs) | 11 |
| [custom-subgraphs](#custom-subgraphs) | 8 |
| [data-transfer-between-nodes](#data-transfer-between-nodes) | 4 |
| [datadog-exporter](#datadog-exporter) | 3 |
| [embeddings](#embeddings) | 5 |
| [event-handlers](#event-handlers) | 2 |
| [events](#events) | 3 |
| [functional-agent](#functional-agent) | 3 |
| [getting-started](#getting-started) | 8 |
| [goap-agents](#goap-agents) | 3 |
| [graph-agents](#graph-agents) | 7 |
| [handling-failures](#handling-failures) | 9 |
| [history-compression](#history-compression) | 16 |
| [http-clients](#http-clients) | 2 |
| [langfuse-exporter](#langfuse-exporter) | 2 |
| [llm-based-planners](#llm-based-planners) | 1 |
| [llm-clients](#llm-clients) | 6 |
| [llm-parameters](#llm-parameters) | 13 |
| [llm-response-caching](#llm-response-caching) | 1 |
| [model-capabilities](#model-capabilities) | 5 |
| [model-context-protocol](#model-context-protocol) | 7 |
| [multimodal-content](#multimodal-content) | 3 |
| [nodes-and-component](#nodes-and-component) | 18 |
| [opentelemetry-support](#opentelemetry-support) | 12 |
| [parallel-node-execution](#parallel-node-execution) | 7 |
| [predefined-strategies](#predefined-strategies) | 4 |
| [prompt-executors](#prompt-executors) | 8 |
| [prompts](#prompts) | 2 |
| [retrieval-augmented-generation](#retrieval-augmented-generation) | 2 |
| [serialization](#serialization) | 8 |
| [sessions](#sessions) | 13 |
| [skills-usage](#skills-usage) | 1 |
| [streaming-api](#streaming-api) | 12 |
| [streaming-api-reasoning](#streaming-api-reasoning) | 1 |
| [structured-data](#structured-data) | 12 |
| [testing](#testing) | 18 |
| [tool-descriptor-schemer](#tool-descriptor-schemer) | 4 |
| [tools-overview](#tools-overview) | 6 |
| [tracing](#tracing) | 7 |
| [weave-exporter](#weave-exporter) | 1 |

## agent-client-protocol

- [example-agent-client-protocol-01.kt](kotlin-examples/example-agent-client-protocol-01.kt) — some imports lack an exact API entry; see manifest.
- [example-agent-client-protocol-02.kt](kotlin-examples/example-agent-client-protocol-02.kt) — some imports lack an exact API entry; see manifest.
- [example-agent-client-protocol-03.kt](kotlin-examples/example-agent-client-protocol-03.kt) — contains application placeholders.
- [example-agent-client-protocol-04.kt](kotlin-examples/example-agent-client-protocol-04.kt) — some imports lack an exact API entry; see manifest.
- [example-agent-client-protocol-05.kt](kotlin-examples/example-agent-client-protocol-05.kt) — contains application placeholders; some imports lack an exact API entry; see manifest.
- [example-agent-client-protocol-06.kt](kotlin-examples/example-agent-client-protocol-06.kt) — some imports lack an exact API entry; see manifest.

## agent-config

- [example-agent-config-01.kt](kotlin-examples/example-agent-config-01.kt)
- [example-agent-config-02.kt](kotlin-examples/example-agent-config-02.kt)

## agent-persistence

- [example-agent-persistence-01.kt](kotlin-examples/example-agent-persistence-01.kt)
- [example-agent-persistence-02.kt](kotlin-examples/example-agent-persistence-02.kt)
- [example-agent-persistence-03.kt](kotlin-examples/example-agent-persistence-03.kt)
- [example-agent-persistence-04.kt](kotlin-examples/example-agent-persistence-04.kt)
- [example-agent-persistence-05.kt](kotlin-examples/example-agent-persistence-05.kt)
- [example-agent-persistence-06.kt](kotlin-examples/example-agent-persistence-06.kt)
- [example-agent-persistence-07.kt](kotlin-examples/example-agent-persistence-07.kt) — Requires [example-agent-persistence-04.kt](kotlin-examples/example-agent-persistence-04.kt).
- [example-agent-persistence-08.kt](kotlin-examples/example-agent-persistence-08.kt) — contains application placeholders.
- [example-agent-persistence-09.kt](kotlin-examples/example-agent-persistence-09.kt) — contains application placeholders.
- [example-agent-persistence-10.kt](kotlin-examples/example-agent-persistence-10.kt)

## annotation-based-tools

- [example-annotation-based-tools-01.kt](kotlin-examples/example-annotation-based-tools-01.kt)
- [example-annotation-based-tools-02.kt](kotlin-examples/example-annotation-based-tools-02.kt)
- [example-annotation-based-tools-03.kt](kotlin-examples/example-annotation-based-tools-03.kt)
- [example-annotation-based-tools-04.kt](kotlin-examples/example-annotation-based-tools-04.kt)
- [example-annotation-based-tools-05.kt](kotlin-examples/example-annotation-based-tools-05.kt)
- [example-annotation-based-tools-06.kt](kotlin-examples/example-annotation-based-tools-06.kt)
- [example-annotation-based-tools-07.kt](kotlin-examples/example-annotation-based-tools-07.kt) — Requires [example-annotation-based-tools-06.kt](kotlin-examples/example-annotation-based-tools-06.kt).
- [example-annotation-based-tools-08.kt](kotlin-examples/example-annotation-based-tools-08.kt)
- [example-annotation-based-tools-09.kt](kotlin-examples/example-annotation-based-tools-09.kt)

## basic

- [example-basic-01.kt](kotlin-examples/example-basic-01.kt)
- [example-basic-02.kt](kotlin-examples/example-basic-02.kt)
- [example-basic-03.kt](kotlin-examples/example-basic-03.kt)
- [example-basic-04.kt](kotlin-examples/example-basic-04.kt)
- [example-basic-05.kt](kotlin-examples/example-basic-05.kt)

## basic-additional

- [example-basic-additional-01.kt](kotlin-examples/example-basic-additional-01.kt)
  Renamed an upstream Kotlin file whose filename had a misleading language suffix.

## built-in-tools

- [example-built-in-tools-01.kt](kotlin-examples/example-built-in-tools-01.kt)

## cache-control

- [example-cache-control-01.kt](kotlin-examples/example-cache-control-01.kt)
- [example-cache-control-02.kt](kotlin-examples/example-cache-control-02.kt)
- [example-cache-control-03.kt](kotlin-examples/example-cache-control-03.kt)
- [example-cache-control-04.kt](kotlin-examples/example-cache-control-04.kt)
- [example-cache-control-05.kt](kotlin-examples/example-cache-control-05.kt)
- [example-cache-control-06.kt](kotlin-examples/example-cache-control-06.kt)
- [example-cache-control-07.kt](kotlin-examples/example-cache-control-07.kt)
- [example-cache-control-08.kt](kotlin-examples/example-cache-control-08.kt)

## class-based-tools

- [example-class-based-tools-01.kt](kotlin-examples/example-class-based-tools-01.kt)
- [example-class-based-tools-02.kt](kotlin-examples/example-class-based-tools-02.kt)
- [example-class-based-tools-03.kt](kotlin-examples/example-class-based-tools-03.kt) — contains application placeholders.

## class-based-tools-metadata

- [example-class-based-tools-metadata-01.kt](kotlin-examples/example-class-based-tools-metadata-01.kt)
- [example-class-based-tools-metadata-02.kt](kotlin-examples/example-class-based-tools-metadata-02.kt)

## content-moderation

- [example-content-moderation-01.kt](kotlin-examples/example-content-moderation-01.kt)
- [example-content-moderation-02.kt](kotlin-examples/example-content-moderation-02.kt)
- [example-content-moderation-03.kt](kotlin-examples/example-content-moderation-03.kt)
- [example-content-moderation-04.kt](kotlin-examples/example-content-moderation-04.kt)
- [example-content-moderation-05.kt](kotlin-examples/example-content-moderation-05.kt)
- [example-content-moderation-06.kt](kotlin-examples/example-content-moderation-06.kt)
- [example-content-moderation-07.kt](kotlin-examples/example-content-moderation-07.kt)
- [example-content-moderation-08.kt](kotlin-examples/example-content-moderation-08.kt)

## creating-prompts

- [example-creating-prompts-01.kt](kotlin-examples/example-creating-prompts-01.kt)
- [example-creating-prompts-02.kt](kotlin-examples/example-creating-prompts-02.kt)
- [example-creating-prompts-03.kt](kotlin-examples/example-creating-prompts-03.kt)
- [example-creating-prompts-04.kt](kotlin-examples/example-creating-prompts-04.kt)
- [example-creating-prompts-05.kt](kotlin-examples/example-creating-prompts-05.kt)
- [example-creating-prompts-06.kt](kotlin-examples/example-creating-prompts-06.kt)
- [example-creating-prompts-07.kt](kotlin-examples/example-creating-prompts-07.kt)
- [example-creating-prompts-08.kt](kotlin-examples/example-creating-prompts-08.kt)
- [example-creating-prompts-09.kt](kotlin-examples/example-creating-prompts-09.kt)
- [example-creating-prompts-10.kt](kotlin-examples/example-creating-prompts-10.kt)

## custom-features

- [example-custom-features-01.kt](kotlin-examples/example-custom-features-01.kt)
- [example-custom-features-02.kt](kotlin-examples/example-custom-features-02.kt)
- [example-custom-features-03.kt](kotlin-examples/example-custom-features-03.kt)
- [example-custom-features-04.kt](kotlin-examples/example-custom-features-04.kt)
- [example-custom-features-05.kt](kotlin-examples/example-custom-features-05.kt)
- [example-custom-features-06.kt](kotlin-examples/example-custom-features-06.kt)

## custom-nodes

- [example-custom-nodes-01.kt](kotlin-examples/example-custom-nodes-01.kt)
- [example-custom-nodes-02.kt](kotlin-examples/example-custom-nodes-02.kt)
- [example-custom-nodes-03.kt](kotlin-examples/example-custom-nodes-03.kt)
- [example-custom-nodes-04.kt](kotlin-examples/example-custom-nodes-04.kt)
- [example-custom-nodes-05.kt](kotlin-examples/example-custom-nodes-05.kt)
- [example-custom-nodes-06.kt](kotlin-examples/example-custom-nodes-06.kt)
- [example-custom-nodes-07.kt](kotlin-examples/example-custom-nodes-07.kt)
- [example-custom-nodes-08.kt](kotlin-examples/example-custom-nodes-08.kt)
- [example-custom-nodes-09.kt](kotlin-examples/example-custom-nodes-09.kt)
- [example-custom-nodes-10.kt](kotlin-examples/example-custom-nodes-10.kt)
- [example-custom-nodes-11.kt](kotlin-examples/example-custom-nodes-11.kt)
  Used Kotlin Uuid with an explicit opt-in.

## custom-strategy-graphs

- [example-custom-strategy-graphs-01.kt](kotlin-examples/example-custom-strategy-graphs-01.kt)
- [example-custom-strategy-graphs-02.kt](kotlin-examples/example-custom-strategy-graphs-02.kt)
- [example-custom-strategy-graphs-03.kt](kotlin-examples/example-custom-strategy-graphs-03.kt)
- [example-custom-strategy-graphs-04.kt](kotlin-examples/example-custom-strategy-graphs-04.kt)
- [example-custom-strategy-graphs-05.kt](kotlin-examples/example-custom-strategy-graphs-05.kt)
- [example-custom-strategy-graphs-06.kt](kotlin-examples/example-custom-strategy-graphs-06.kt)
- [example-custom-strategy-graphs-07.kt](kotlin-examples/example-custom-strategy-graphs-07.kt)
- [example-custom-strategy-graphs-08.kt](kotlin-examples/example-custom-strategy-graphs-08.kt)
- [example-custom-strategy-graphs-09.kt](kotlin-examples/example-custom-strategy-graphs-09.kt)
- [example-custom-strategy-graphs-10.kt](kotlin-examples/example-custom-strategy-graphs-10.kt)
- [example-custom-strategy-graphs-11.kt](kotlin-examples/example-custom-strategy-graphs-11.kt)

## custom-subgraphs

- [example-custom-subgraphs-01.kt](kotlin-examples/example-custom-subgraphs-01.kt)
- [example-custom-subgraphs-02.kt](kotlin-examples/example-custom-subgraphs-02.kt)
- [example-custom-subgraphs-03.kt](kotlin-examples/example-custom-subgraphs-03.kt)
- [example-custom-subgraphs-04.kt](kotlin-examples/example-custom-subgraphs-04.kt)
- [example-custom-subgraphs-05.kt](kotlin-examples/example-custom-subgraphs-05.kt)
- [example-custom-subgraphs-06.kt](kotlin-examples/example-custom-subgraphs-06.kt)
- [example-custom-subgraphs-07.kt](kotlin-examples/example-custom-subgraphs-07.kt)
- [example-custom-subgraphs-08.kt](kotlin-examples/example-custom-subgraphs-08.kt)

## data-transfer-between-nodes

- [example-data-transfer-between-nodes-01.kt](kotlin-examples/example-data-transfer-between-nodes-01.kt)
- [example-data-transfer-between-nodes-02.kt](kotlin-examples/example-data-transfer-between-nodes-02.kt)
- [example-data-transfer-between-nodes-03.kt](kotlin-examples/example-data-transfer-between-nodes-03.kt)
- [example-data-transfer-between-nodes-04.kt](kotlin-examples/example-data-transfer-between-nodes-04.kt)

## datadog-exporter

- [example-datadog-exporter-01.kt](kotlin-examples/example-datadog-exporter-01.kt)
- [example-datadog-exporter-02.kt](kotlin-examples/example-datadog-exporter-02.kt)
- [example-datadog-exporter-03.kt](kotlin-examples/example-datadog-exporter-03.kt)

## embeddings

- [example-embeddings-01.kt](kotlin-examples/example-embeddings-01.kt)
- [example-embeddings-02.kt](kotlin-examples/example-embeddings-02.kt)
- [example-embeddings-03.kt](kotlin-examples/example-embeddings-03.kt)
- [example-embeddings-04.kt](kotlin-examples/example-embeddings-04.kt)
- [example-embeddings-05.kt](kotlin-examples/example-embeddings-05.kt)
  Replaced embedded other-language code with Kotlin Fibonacci and sorting implementations while preserving the embedding comparison.

## event-handlers

- [example-event-handlers-01.kt](kotlin-examples/example-event-handlers-01.kt)
- [example-event-handlers-02.kt](kotlin-examples/example-event-handlers-02.kt)

## events

- [example-events-01.kt](kotlin-examples/example-events-01.kt) — Requires [example-tracing-01.kt](kotlin-examples/example-tracing-01.kt).
- [example-events-02.kt](kotlin-examples/example-events-02.kt) — Requires [example-tracing-01.kt](kotlin-examples/example-tracing-01.kt).
- [example-events-03.kt](kotlin-examples/example-events-03.kt)

## functional-agent

- [example-functional-agent-01.kt](kotlin-examples/example-functional-agent-01.kt)
- [example-functional-agent-02.kt](kotlin-examples/example-functional-agent-02.kt)
- [example-functional-agent-03.kt](kotlin-examples/example-functional-agent-03.kt)

## getting-started

- [example-getting-started-01.kt](kotlin-examples/example-getting-started-01.kt)
- [example-getting-started-02.kt](kotlin-examples/example-getting-started-02.kt)
- [example-getting-started-03.kt](kotlin-examples/example-getting-started-03.kt)
- [example-getting-started-04.kt](kotlin-examples/example-getting-started-04.kt)
- [example-getting-started-05.kt](kotlin-examples/example-getting-started-05.kt)
- [example-getting-started-06.kt](kotlin-examples/example-getting-started-06.kt)
- [example-getting-started-07.kt](kotlin-examples/example-getting-started-07.kt)
- [example-getting-started-08.kt](kotlin-examples/example-getting-started-08.kt)

## goap-agents

- [example-goap-agents-01.kt](kotlin-examples/example-goap-agents-01.kt)
- [example-goap-agents-02.kt](kotlin-examples/example-goap-agents-02.kt)
- [example-goap-agents-03.kt](kotlin-examples/example-goap-agents-03.kt)

## graph-agents

- [example-graph-agents-01.kt](kotlin-examples/example-graph-agents-01.kt)
- [example-graph-agents-02.kt](kotlin-examples/example-graph-agents-02.kt)
- [example-graph-agents-03.kt](kotlin-examples/example-graph-agents-03.kt)
- [example-graph-agents-04.kt](kotlin-examples/example-graph-agents-04.kt)
- [example-graph-agents-05.kt](kotlin-examples/example-graph-agents-05.kt)
- [example-graph-agents-06.kt](kotlin-examples/example-graph-agents-06.kt)
- [example-graph-agents-07.kt](kotlin-examples/example-graph-agents-07.kt)

## handling-failures

- [example-handling-failures-01.kt](kotlin-examples/example-handling-failures-01.kt)
- [example-handling-failures-02.kt](kotlin-examples/example-handling-failures-02.kt)
- [example-handling-failures-03.kt](kotlin-examples/example-handling-failures-03.kt)
- [example-handling-failures-04.kt](kotlin-examples/example-handling-failures-04.kt)
- [example-handling-failures-05.kt](kotlin-examples/example-handling-failures-05.kt)
- [example-handling-failures-06.kt](kotlin-examples/example-handling-failures-06.kt)
- [example-handling-failures-07.kt](kotlin-examples/example-handling-failures-07.kt)
- [example-handling-failures-08.kt](kotlin-examples/example-handling-failures-08.kt)
- [example-handling-failures-09.kt](kotlin-examples/example-handling-failures-09.kt)

## history-compression

- [example-history-compression-01.kt](kotlin-examples/example-history-compression-01.kt)
- [example-history-compression-02.kt](kotlin-examples/example-history-compression-02.kt)
- [example-history-compression-03.kt](kotlin-examples/example-history-compression-03.kt)
- [example-history-compression-04.kt](kotlin-examples/example-history-compression-04.kt)
- [example-history-compression-05.kt](kotlin-examples/example-history-compression-05.kt)
- [example-history-compression-06.kt](kotlin-examples/example-history-compression-06.kt)
- [example-history-compression-07.kt](kotlin-examples/example-history-compression-07.kt)
- [example-history-compression-08.kt](kotlin-examples/example-history-compression-08.kt)
- [example-history-compression-09.kt](kotlin-examples/example-history-compression-09.kt)
- [example-history-compression-10.kt](kotlin-examples/example-history-compression-10.kt)
- [example-history-compression-11.kt](kotlin-examples/example-history-compression-11.kt)
- [example-history-compression-12.kt](kotlin-examples/example-history-compression-12.kt)
- [example-history-compression-13.kt](kotlin-examples/example-history-compression-13.kt) — Requires [example-history-compression-12.kt](kotlin-examples/example-history-compression-12.kt).
- [example-history-compression-14.kt](kotlin-examples/example-history-compression-14.kt) — Requires [example-history-compression-12.kt](kotlin-examples/example-history-compression-12.kt).
- [example-history-compression-15.kt](kotlin-examples/example-history-compression-15.kt)
- [example-history-compression-16.kt](kotlin-examples/example-history-compression-16.kt)

## http-clients

- [example-http-clients-01.kt](kotlin-examples/example-http-clients-01.kt)
- [example-http-clients-02.kt](kotlin-examples/example-http-clients-02.kt)

## langfuse-exporter

- [example-langfuse-exporter-01.kt](kotlin-examples/example-langfuse-exporter-01.kt)
- [example-langfuse-exporter-02.kt](kotlin-examples/example-langfuse-exporter-02.kt)
  Used Kotlin Uuid with an explicit opt-in.

## llm-based-planners

- [example-llm-based-planners-01.kt](kotlin-examples/example-llm-based-planners-01.kt)

## llm-clients

- [example-llm-clients-01.kt](kotlin-examples/example-llm-clients-01.kt)
- [example-llm-clients-02.kt](kotlin-examples/example-llm-clients-02.kt)
- [example-llm-clients-03.kt](kotlin-examples/example-llm-clients-03.kt)
- [example-llm-clients-04.kt](kotlin-examples/example-llm-clients-04.kt)
- [example-llm-clients-05.kt](kotlin-examples/example-llm-clients-05.kt)
- [example-llm-clients-06.kt](kotlin-examples/example-llm-clients-06.kt)

## llm-parameters

- [example-llm-parameters-01.kt](kotlin-examples/example-llm-parameters-01.kt)
- [example-llm-parameters-02.kt](kotlin-examples/example-llm-parameters-02.kt)
- [example-llm-parameters-03.kt](kotlin-examples/example-llm-parameters-03.kt)
- [example-llm-parameters-04.kt](kotlin-examples/example-llm-parameters-04.kt)
- [example-llm-parameters-05.kt](kotlin-examples/example-llm-parameters-05.kt)
- [example-llm-parameters-06.kt](kotlin-examples/example-llm-parameters-06.kt)
- [example-llm-parameters-07.kt](kotlin-examples/example-llm-parameters-07.kt)
- [example-llm-parameters-08.kt](kotlin-examples/example-llm-parameters-08.kt)
- [example-llm-parameters-09.kt](kotlin-examples/example-llm-parameters-09.kt)
- [example-llm-parameters-10.kt](kotlin-examples/example-llm-parameters-10.kt)
- [example-llm-parameters-11.kt](kotlin-examples/example-llm-parameters-11.kt)
- [example-llm-parameters-12.kt](kotlin-examples/example-llm-parameters-12.kt)
- [example-llm-parameters-13.kt](kotlin-examples/example-llm-parameters-13.kt)

## llm-response-caching

- [example-llm-response-caching-01.kt](kotlin-examples/example-llm-response-caching-01.kt)

## model-capabilities

- [example-model-capabilities-01.kt](kotlin-examples/example-model-capabilities-01.kt)
- [example-model-capabilities-02.kt](kotlin-examples/example-model-capabilities-02.kt)
- [example-model-capabilities-03.kt](kotlin-examples/example-model-capabilities-03.kt)
- [example-model-capabilities-04.kt](kotlin-examples/example-model-capabilities-04.kt)
- [example-model-capabilities-05.kt](kotlin-examples/example-model-capabilities-05.kt)

## model-context-protocol

- [example-model-context-protocol-01.kt](kotlin-examples/example-model-context-protocol-01.kt)
- [example-model-context-protocol-02.kt](kotlin-examples/example-model-context-protocol-02.kt)
- [example-model-context-protocol-03.kt](kotlin-examples/example-model-context-protocol-03.kt) — Requires [example-model-context-protocol-01.kt](kotlin-examples/example-model-context-protocol-01.kt).
- [example-model-context-protocol-04.kt](kotlin-examples/example-model-context-protocol-04.kt)
- [example-model-context-protocol-05.kt](kotlin-examples/example-model-context-protocol-05.kt) — Requires [example-model-context-protocol-04.kt](kotlin-examples/example-model-context-protocol-04.kt).
- [example-model-context-protocol-06.kt](kotlin-examples/example-model-context-protocol-06.kt)
- [example-model-context-protocol-07.kt](kotlin-examples/example-model-context-protocol-07.kt)

## multimodal-content

- [example-multimodal-content-01.kt](kotlin-examples/example-multimodal-content-01.kt)
- [example-multimodal-content-02.kt](kotlin-examples/example-multimodal-content-02.kt)
- [example-multimodal-content-03.kt](kotlin-examples/example-multimodal-content-03.kt)

## nodes-and-component

- [example-nodes-and-component-01.kt](kotlin-examples/example-nodes-and-component-01.kt)
- [example-nodes-and-component-02.kt](kotlin-examples/example-nodes-and-component-02.kt)
- [example-nodes-and-component-03.kt](kotlin-examples/example-nodes-and-component-03.kt)
- [example-nodes-and-component-04.kt](kotlin-examples/example-nodes-and-component-04.kt)
- [example-nodes-and-component-05.kt](kotlin-examples/example-nodes-and-component-05.kt)
- [example-nodes-and-component-06.kt](kotlin-examples/example-nodes-and-component-06.kt)
- [example-nodes-and-component-07.kt](kotlin-examples/example-nodes-and-component-07.kt)
- [example-nodes-and-component-08.kt](kotlin-examples/example-nodes-and-component-08.kt)
- [example-nodes-and-component-09.kt](kotlin-examples/example-nodes-and-component-09.kt)
- [example-nodes-and-component-10.kt](kotlin-examples/example-nodes-and-component-10.kt)
- [example-nodes-and-component-11.kt](kotlin-examples/example-nodes-and-component-11.kt)
- [example-nodes-and-component-12.kt](kotlin-examples/example-nodes-and-component-12.kt)
- [example-nodes-and-component-13.kt](kotlin-examples/example-nodes-and-component-13.kt)
- [example-nodes-and-component-14.kt](kotlin-examples/example-nodes-and-component-14.kt)
- [example-nodes-and-component-15.kt](kotlin-examples/example-nodes-and-component-15.kt)
- [example-nodes-and-component-16.kt](kotlin-examples/example-nodes-and-component-16.kt)
- [example-nodes-and-component-17.kt](kotlin-examples/example-nodes-and-component-17.kt)
- [example-nodes-and-component-18.kt](kotlin-examples/example-nodes-and-component-18.kt) — Requires [example-streaming-api-05.kt](kotlin-examples/example-streaming-api-05.kt), [example-streaming-api-06.kt](kotlin-examples/example-streaming-api-06.kt), [example-streaming-api-08.kt](kotlin-examples/example-streaming-api-08.kt).

## opentelemetry-support

- [example-opentelemetry-support-01.kt](kotlin-examples/example-opentelemetry-support-01.kt)
- [example-opentelemetry-support-02.kt](kotlin-examples/example-opentelemetry-support-02.kt)
- [example-opentelemetry-support-03.kt](kotlin-examples/example-opentelemetry-support-03.kt)
- [example-opentelemetry-support-04.kt](kotlin-examples/example-opentelemetry-support-04.kt)
- [example-opentelemetry-support-05.kt](kotlin-examples/example-opentelemetry-support-05.kt)
- [example-opentelemetry-support-06.kt](kotlin-examples/example-opentelemetry-support-06.kt)
  Inferred the exporter timeout unit through Kotlin enumValueOf.
- [example-opentelemetry-support-07.kt](kotlin-examples/example-opentelemetry-support-07.kt)
- [example-opentelemetry-support-08.kt](kotlin-examples/example-opentelemetry-support-08.kt)
- [example-opentelemetry-support-09.kt](kotlin-examples/example-opentelemetry-support-09.kt)
- [example-opentelemetry-support-10.kt](kotlin-examples/example-opentelemetry-support-10.kt)
- [example-opentelemetry-support-11.kt](kotlin-examples/example-opentelemetry-support-11.kt)
- [example-opentelemetry-support-12.kt](kotlin-examples/example-opentelemetry-support-12.kt)

## parallel-node-execution

- [example-parallel-node-execution-01.kt](kotlin-examples/example-parallel-node-execution-01.kt)
- [example-parallel-node-execution-02.kt](kotlin-examples/example-parallel-node-execution-02.kt)
- [example-parallel-node-execution-03.kt](kotlin-examples/example-parallel-node-execution-03.kt)
- [example-parallel-node-execution-04.kt](kotlin-examples/example-parallel-node-execution-04.kt)
- [example-parallel-node-execution-05.kt](kotlin-examples/example-parallel-node-execution-05.kt)
- [example-parallel-node-execution-06.kt](kotlin-examples/example-parallel-node-execution-06.kt)
- [example-parallel-node-execution-07.kt](kotlin-examples/example-parallel-node-execution-07.kt)

## predefined-strategies

- [example-predefined-strategies-01.kt](kotlin-examples/example-predefined-strategies-01.kt)
- [example-predefined-strategies-02.kt](kotlin-examples/example-predefined-strategies-02.kt)
- [example-predefined-strategies-03.kt](kotlin-examples/example-predefined-strategies-03.kt)
- [example-predefined-strategies-04.kt](kotlin-examples/example-predefined-strategies-04.kt)

## prompt-executors

- [example-prompt-executors-01.kt](kotlin-examples/example-prompt-executors-01.kt)
- [example-prompt-executors-02.kt](kotlin-examples/example-prompt-executors-02.kt)
- [example-prompt-executors-03.kt](kotlin-examples/example-prompt-executors-03.kt)
- [example-prompt-executors-04.kt](kotlin-examples/example-prompt-executors-04.kt)
- [example-prompt-executors-05.kt](kotlin-examples/example-prompt-executors-05.kt)
- [example-prompt-executors-06.kt](kotlin-examples/example-prompt-executors-06.kt)
- [example-prompt-executors-07.kt](kotlin-examples/example-prompt-executors-07.kt)
- [example-prompt-executors-08.kt](kotlin-examples/example-prompt-executors-08.kt)

## prompts

- [example-prompts-01.kt](kotlin-examples/example-prompts-01.kt)
- [example-prompts-02.kt](kotlin-examples/example-prompts-02.kt)

## retrieval-augmented-generation

- [example-retrieval-augmented-generation-01.kt](kotlin-examples/example-retrieval-augmented-generation-01.kt)
  Used Kotlin path/readText helpers and inferred the storage type.
- [example-retrieval-augmented-generation-02.kt](kotlin-examples/example-retrieval-augmented-generation-02.kt)
  Used Kotlin path/readText helpers and inferred the storage type.

## serialization

- [example-serialization-01.kt](kotlin-examples/example-serialization-01.kt)
- [example-serialization-02.kt](kotlin-examples/example-serialization-02.kt)
- [example-serialization-03.kt](kotlin-examples/example-serialization-03.kt)
- [example-serialization-04.kt](kotlin-examples/example-serialization-04.kt)
- [example-serialization-05.kt](kotlin-examples/example-serialization-05.kt)
- [example-serialization-06.kt](kotlin-examples/example-serialization-06.kt) — some imports lack an exact API entry; see manifest.
- [example-serialization-07.kt](kotlin-examples/example-serialization-07.kt) — some imports lack an exact API entry; see manifest.
- [example-serialization-08.kt](kotlin-examples/example-serialization-08.kt) — some imports lack an exact API entry; see manifest.

## sessions

- [example-sessions-01.kt](kotlin-examples/example-sessions-01.kt)
- [example-sessions-02.kt](kotlin-examples/example-sessions-02.kt)
- [example-sessions-03.kt](kotlin-examples/example-sessions-03.kt)
- [example-sessions-04.kt](kotlin-examples/example-sessions-04.kt)
- [example-sessions-05.kt](kotlin-examples/example-sessions-05.kt)
- [example-sessions-06.kt](kotlin-examples/example-sessions-06.kt) — Requires [example-parallel-node-execution-07.kt](kotlin-examples/example-parallel-node-execution-07.kt).
- [example-sessions-07.kt](kotlin-examples/example-sessions-07.kt)
- [example-sessions-08.kt](kotlin-examples/example-sessions-08.kt)
- [example-sessions-09.kt](kotlin-examples/example-sessions-09.kt)
- [example-sessions-10.kt](kotlin-examples/example-sessions-10.kt)
- [example-sessions-11.kt](kotlin-examples/example-sessions-11.kt)
- [example-sessions-12.kt](kotlin-examples/example-sessions-12.kt)
- [example-sessions-13.kt](kotlin-examples/example-sessions-13.kt)

## skills-usage

- [example-skills-usage-01.kt](kotlin-examples/example-skills-usage-01.kt)
  Used the API key already validated by the example.

## streaming-api

- [example-streaming-api-01.kt](kotlin-examples/example-streaming-api-01.kt)
- [example-streaming-api-02.kt](kotlin-examples/example-streaming-api-02.kt)
- [example-streaming-api-03.kt](kotlin-examples/example-streaming-api-03.kt)
- [example-streaming-api-04.kt](kotlin-examples/example-streaming-api-04.kt)
- [example-streaming-api-05.kt](kotlin-examples/example-streaming-api-05.kt)
- [example-streaming-api-06.kt](kotlin-examples/example-streaming-api-06.kt)
- [example-streaming-api-07.kt](kotlin-examples/example-streaming-api-07.kt) — Requires [example-streaming-api-05.kt](kotlin-examples/example-streaming-api-05.kt).
- [example-streaming-api-08.kt](kotlin-examples/example-streaming-api-08.kt) — Requires [example-streaming-api-05.kt](kotlin-examples/example-streaming-api-05.kt).
- [example-streaming-api-09.kt](kotlin-examples/example-streaming-api-09.kt) — Requires [example-streaming-api-05.kt](kotlin-examples/example-streaming-api-05.kt), [example-streaming-api-06.kt](kotlin-examples/example-streaming-api-06.kt), [example-streaming-api-08.kt](kotlin-examples/example-streaming-api-08.kt).
- [example-streaming-api-10.kt](kotlin-examples/example-streaming-api-10.kt) — Requires [example-streaming-api-05.kt](kotlin-examples/example-streaming-api-05.kt).
- [example-streaming-api-11.kt](kotlin-examples/example-streaming-api-11.kt) — Requires [example-streaming-api-06.kt](kotlin-examples/example-streaming-api-06.kt), [example-streaming-api-08.kt](kotlin-examples/example-streaming-api-08.kt), [example-streaming-api-10.kt](kotlin-examples/example-streaming-api-10.kt).
- [example-streaming-api-12.kt](kotlin-examples/example-streaming-api-12.kt) — Requires [example-streaming-api-10.kt](kotlin-examples/example-streaming-api-10.kt).

## streaming-api-reasoning

- [example-streaming-api-reasoning-01.kt](kotlin-examples/example-streaming-api-reasoning-01.kt)

## structured-data

- [example-structured-data-01.kt](kotlin-examples/example-structured-data-01.kt)
- [example-structured-data-02.kt](kotlin-examples/example-structured-data-02.kt)
- [example-structured-data-03.kt](kotlin-examples/example-structured-data-03.kt)
- [example-structured-data-04.kt](kotlin-examples/example-structured-data-04.kt)
- [example-structured-data-05.kt](kotlin-examples/example-structured-data-05.kt)
- [example-structured-data-06.kt](kotlin-examples/example-structured-data-06.kt) — Requires [example-structured-data-03.kt](kotlin-examples/example-structured-data-03.kt).
- [example-structured-data-07.kt](kotlin-examples/example-structured-data-07.kt) — Requires [example-structured-data-03.kt](kotlin-examples/example-structured-data-03.kt), [example-structured-data-06.kt](kotlin-examples/example-structured-data-06.kt).
- [example-structured-data-08.kt](kotlin-examples/example-structured-data-08.kt) — Requires [example-structured-data-03.kt](kotlin-examples/example-structured-data-03.kt), [example-structured-data-06.kt](kotlin-examples/example-structured-data-06.kt).
- [example-structured-data-09.kt](kotlin-examples/example-structured-data-09.kt) — Requires [example-structured-data-03.kt](kotlin-examples/example-structured-data-03.kt).
- [example-structured-data-10.kt](kotlin-examples/example-structured-data-10.kt) — Requires [example-structured-data-03.kt](kotlin-examples/example-structured-data-03.kt), [example-structured-data-06.kt](kotlin-examples/example-structured-data-06.kt).
- [example-structured-data-11.kt](kotlin-examples/example-structured-data-11.kt)
- [example-structured-data-12.kt](kotlin-examples/example-structured-data-12.kt) — Requires [example-structured-data-03.kt](kotlin-examples/example-structured-data-03.kt), [example-structured-data-06.kt](kotlin-examples/example-structured-data-06.kt).

## testing

- [example-testing-01.kt](kotlin-examples/example-testing-01.kt)
- [example-testing-02.kt](kotlin-examples/example-testing-02.kt)
- [example-testing-03.kt](kotlin-examples/example-testing-03.kt)
- [example-testing-04.kt](kotlin-examples/example-testing-04.kt) — Requires [example-testing-02.kt](kotlin-examples/example-testing-02.kt), [example-testing-03.kt](kotlin-examples/example-testing-03.kt).
- [example-testing-05.kt](kotlin-examples/example-testing-05.kt) — Requires [example-testing-02.kt](kotlin-examples/example-testing-02.kt), [example-testing-03.kt](kotlin-examples/example-testing-03.kt).
- [example-testing-06.kt](kotlin-examples/example-testing-06.kt) — Requires [example-testing-02.kt](kotlin-examples/example-testing-02.kt), [example-testing-03.kt](kotlin-examples/example-testing-03.kt).
- [example-testing-07.kt](kotlin-examples/example-testing-07.kt) — Requires [example-testing-02.kt](kotlin-examples/example-testing-02.kt), [example-testing-03.kt](kotlin-examples/example-testing-03.kt).
- [example-testing-08.kt](kotlin-examples/example-testing-08.kt) — Requires [example-testing-02.kt](kotlin-examples/example-testing-02.kt), [example-testing-03.kt](kotlin-examples/example-testing-03.kt).
- [example-testing-09.kt](kotlin-examples/example-testing-09.kt) — Requires [example-testing-02.kt](kotlin-examples/example-testing-02.kt), [example-testing-03.kt](kotlin-examples/example-testing-03.kt).
- [example-testing-10.kt](kotlin-examples/example-testing-10.kt) — Requires [example-testing-02.kt](kotlin-examples/example-testing-02.kt), [example-testing-03.kt](kotlin-examples/example-testing-03.kt).
- [example-testing-11.kt](kotlin-examples/example-testing-11.kt) — Requires [example-testing-02.kt](kotlin-examples/example-testing-02.kt), [example-testing-03.kt](kotlin-examples/example-testing-03.kt).
- [example-testing-12.kt](kotlin-examples/example-testing-12.kt) — Requires [example-testing-02.kt](kotlin-examples/example-testing-02.kt), [example-testing-03.kt](kotlin-examples/example-testing-03.kt), [example-testing-09.kt](kotlin-examples/example-testing-09.kt).
- [example-testing-13.kt](kotlin-examples/example-testing-13.kt) — Requires [example-testing-02.kt](kotlin-examples/example-testing-02.kt), [example-testing-03.kt](kotlin-examples/example-testing-03.kt), [example-testing-09.kt](kotlin-examples/example-testing-09.kt).
- [example-testing-14.kt](kotlin-examples/example-testing-14.kt)
- [example-testing-15.kt](kotlin-examples/example-testing-15.kt)
- [example-testing-16.kt](kotlin-examples/example-testing-16.kt)
- [example-testing-17.kt](kotlin-examples/example-testing-17.kt) — Requires [example-testing-02.kt](kotlin-examples/example-testing-02.kt), [example-testing-03.kt](kotlin-examples/example-testing-03.kt).
- [example-testing-18.kt](kotlin-examples/example-testing-18.kt)

## tool-descriptor-schemer

- [example-tool-descriptor-schemer-01.kt](kotlin-examples/example-tool-descriptor-schemer-01.kt)
- [example-tool-descriptor-schemer-02.kt](kotlin-examples/example-tool-descriptor-schemer-02.kt)
- [example-tool-descriptor-schemer-03.kt](kotlin-examples/example-tool-descriptor-schemer-03.kt)
- [example-tool-descriptor-schemer-04.kt](kotlin-examples/example-tool-descriptor-schemer-04.kt)

## tools-overview

- [example-tools-overview-01.kt](kotlin-examples/example-tools-overview-01.kt)
- [example-tools-overview-02.kt](kotlin-examples/example-tools-overview-02.kt)
- [example-tools-overview-03.kt](kotlin-examples/example-tools-overview-03.kt) — Requires [example-tools-overview-01.kt](kotlin-examples/example-tools-overview-01.kt).
- [example-tools-overview-04.kt](kotlin-examples/example-tools-overview-04.kt)
- [example-tools-overview-05.kt](kotlin-examples/example-tools-overview-05.kt)
- [example-tools-overview-06.kt](kotlin-examples/example-tools-overview-06.kt) — Requires [example-tools-overview-05.kt](kotlin-examples/example-tools-overview-05.kt).

## tracing

- [example-tracing-01.kt](kotlin-examples/example-tracing-01.kt)
- [example-tracing-02.kt](kotlin-examples/example-tracing-02.kt) — Requires [example-tracing-01.kt](kotlin-examples/example-tracing-01.kt).
- [example-tracing-03.kt](kotlin-examples/example-tracing-03.kt)
- [example-tracing-04.kt](kotlin-examples/example-tracing-04.kt) — Requires [example-tracing-01.kt](kotlin-examples/example-tracing-01.kt).
- [example-tracing-05.kt](kotlin-examples/example-tracing-05.kt) — Requires [example-tracing-01.kt](kotlin-examples/example-tracing-01.kt).
- [example-tracing-06.kt](kotlin-examples/example-tracing-06.kt)
- [example-tracing-07.kt](kotlin-examples/example-tracing-07.kt)

## weave-exporter

- [example-weave-exporter-01.kt](kotlin-examples/example-weave-exporter-01.kt)
