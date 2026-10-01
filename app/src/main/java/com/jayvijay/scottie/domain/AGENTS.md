# Domain conventions

## Package layout

- `entities/`: Domain models.
- `repository/`: Repository interfaces.
- `usecase/`: Use cases, when warranted.

Repository interfaces contain declarations only; do not add default implementations.

## AI agents, when applicable

- `agent/workflow/`: Business-level agent orchestration, routing, prompt templates, guardrails, and
  fallback policies.
- `agent/tools/`: Interfaces describing actions available to agents.
- `entities/`: Agent state, execution goals, and structured outputs.
- `usecase/`: Agent-session policy and coordination when a use case is warranted.

Keep infrastructure execution details out of workflows. Do not import API clients or embedding
libraries into them.

Define agent tools with strongly typed inputs and outputs rather than raw, unvalidated text.
