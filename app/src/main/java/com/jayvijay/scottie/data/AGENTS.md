# Data conventions

## Package layout

- `local/`: DAOs, key-value storage, file storage, and local encryption.
- `remote/`: Network clients, API definitions, endpoints, and interceptors.
- `repository/`: Implementations of domain repository interfaces.

## AI agents, when applicable

- `ai/provider/`: Inference clients, provider configuration, network timeouts, and streaming chunk
  aggregation.
- `ai/memory/`: Vector storage clients, embedding/indexing infrastructure, retrieval infrastructure,
  and persistent conversation history.
- `ai/tools/`: Implementations of interfaces in `domain/agent/tools/`, with local or remote
  dependencies supplied through injection.

Keep vector database dependencies encapsulated within `ai/memory/`.
