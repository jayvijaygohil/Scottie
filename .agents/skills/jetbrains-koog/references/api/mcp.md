# MCP tools and metadata

Kotlin contracts extracted from the supplied Dokka build. Read [coverage and compatibility](../api-index.md) first. Read individual symbols as needed; source labels and incomplete declarations are preserved.

## ai.koog.agents.mcp.DefaultMcpToolDescriptorParser

Module: `agents-mcp`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-mcp/ai.koog.agents.mcp/-default-mcp-tool-descriptor-parser/index.html`

### :agents:agents-mcp/commonMain

```kotlin
object DefaultMcpToolDescriptorParser : McpToolDescriptorParser
```

Default implementation of McpToolDescriptorParser.

## ai.koog.agents.mcp.DefaultMcpToolDescriptorParser.parse

Module: `agents-mcp`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-mcp/ai.koog.agents.mcp/-default-mcp-tool-descriptor-parser/parse.html`

### :agents:agents-mcp/commonMain

```kotlin
open override fun parse(sdkTool: Tool): ToolDescriptor
```

Parses an MCP SDK Tool definition into tool descriptor format.

This method extracts tool information (name, description, parameters) from an MCP SDK Tool and converts it into a ToolDescriptor that can be used by the agent framework.

A ToolDescriptor representing the MCP tool.

- sdkTool — The MCP SDK Tool to parse.

Referenced packages: `ai.koog.agents.core.tools`.

## ai.koog.agents.mcp.McpTool.McpTool

Module: `agents-mcp`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-mcp/ai.koog.agents.mcp/-mcp-tool/-mcp-tool.html`

### :agents:agents-mcp/commonMain

```kotlin
constructor(mcpClient: Client, descriptor: ToolDescriptor, metadata: Map<String, String>)
```


Referenced packages: `ai.koog.agents.core.tools`.

## ai.koog.agents.mcp.McpTool.decodeResult

Module: `agents-mcp`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-mcp/ai.koog.agents.mcp/-mcp-tool/decode-result.html`

### :agents:agents-mcp/commonMain

```kotlin
open override fun decodeResult(rawResult: JSONElement, serializer: JSONSerializer): CallToolResult?
```


Referenced packages: `ai.koog.serialization`.

## ai.koog.agents.mcp.McpTool.encodeResultToString

Module: `agents-mcp`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-mcp/ai.koog.agents.mcp/-mcp-tool/encode-result-to-string.html`

### :agents:agents-mcp/commonMain

```kotlin
open override fun encodeResultToString(result: CallToolResult?, serializer: JSONSerializer): String
```

Postprocess result string representation for LLMs a bit, removing unnecessary meta fields. When the result indicates an error (isError == true), returns a clearly prefixed error string so the LLM can recognize the failure and adjust its strategy.

If the error result has no TextContent (or only blank text), falls back to encoding the full CallToolResult as JSON so non-text content (e.g. images, embedded resources) is not silently dropped.


Referenced packages: `ai.koog.serialization`.

## ai.koog.agents.mcp.McpTool.encodeResult

Module: `agents-mcp`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-mcp/ai.koog.agents.mcp/-mcp-tool/encode-result.html`

### :agents:agents-mcp/commonMain

```kotlin
open override fun encodeResult(result: CallToolResult?, serializer: JSONSerializer): JSONElement
```


Referenced packages: `ai.koog.serialization`.

## ai.koog.agents.mcp.McpTool.execute

Module: `agents-mcp`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-mcp/ai.koog.agents.mcp/-mcp-tool/execute.html`

### :agents:agents-mcp/commonMain

```kotlin
open suspend override fun execute(args: JSONObject): CallToolResult
```

Executes the MCP tool with the given arguments.

This method calls the MCP tool through the MCP client and converts the result to a Result object that can be used by the agent framework.

The result of the MCP tool call.

- args — The arguments for the MCP tool call.

Referenced packages: `ai.koog.serialization`.

## ai.koog.agents.mcp.McpTool

Module: `agents-mcp`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-mcp/ai.koog.agents.mcp/-mcp-tool/index.html`

### :agents:agents-mcp/commonMain

```kotlin
class McpTool(mcpClient: Client, descriptor: ToolDescriptor, metadata: Map<String, String>) : Tool<JSONObject, CallToolResult?>
```

A Tool implementation that calls an MCP (Model Context Protocol) tool.

This class serves as a bridge between the agent framework's Tool interface and the MCP SDK. It allows MCP tools to be used within the agent framework by:

Converting agent framework tool arguments to MCP tool arguments

Calling the MCP tool through the MCP client

Converting MCP tool results back to agent framework tool results


Referenced packages: `ai.koog.agents.core.tools`, `ai.koog.serialization`.

## ai.koog.agents.mcp.McpToolDescriptorParser

Module: `agents-mcp`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-mcp/ai.koog.agents.mcp/-mcp-tool-descriptor-parser/index.html`

### :agents:agents-mcp/commonMain

```kotlin
interface McpToolDescriptorParser
```

Parsers tool definition from MCP SDK to our tool descriptor format.

- DefaultMcpToolDescriptorParser
## ai.koog.agents.mcp.McpToolDescriptorParser.parse

Module: `agents-mcp`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-mcp/ai.koog.agents.mcp/-mcp-tool-descriptor-parser/parse.html`

### :agents:agents-mcp/commonMain

```kotlin
abstract fun parse(sdkTool: Tool): ToolDescriptor
```

Parses an SDK tool representation into a standardized ToolDescriptor format.

The parsed ToolDescriptor, representing the tool in a standardized format.

- sdkTool — The SDKTool instance containing tool information to be parsed.

Referenced packages: `ai.koog.agents.core.tools`.

## ai.koog.agents.mcp.McpToolRegistryProvider.DEFAULT_MCP_CLIENT_NAME

Module: `agents-mcp`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-mcp/ai.koog.agents.mcp/-mcp-tool-registry-provider/-d-e-f-a-u-l-t_-m-c-p_-c-l-i-e-n-t_-n-a-m-e.html`

### :agents:agents-mcp/commonMain

```kotlin
const val DEFAULT_MCP_CLIENT_NAME: String
```

Default name for the MCP client when connecting to an MCP server.

## ai.koog.agents.mcp.McpToolRegistryProvider.DEFAULT_MCP_CLIENT_VERSION

Module: `agents-mcp`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-mcp/ai.koog.agents.mcp/-mcp-tool-registry-provider/-d-e-f-a-u-l-t_-m-c-p_-c-l-i-e-n-t_-v-e-r-s-i-o-n.html`

### :agents:agents-mcp/commonMain

```kotlin
const val DEFAULT_MCP_CLIENT_VERSION: String
```

Default version for the MCP client when connecting to an MCP server.

## ai.koog.agents.mcp.McpToolRegistryProvider.StreamableHttpConfig.StreamableHttpConfig

Module: `agents-mcp`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-mcp/ai.koog.agents.mcp/-mcp-tool-registry-provider/-streamable-http-config/-streamable-http-config.html`

### :agents:agents-mcp/commonMain

```kotlin
constructor()
```

## ai.koog.agents.mcp.McpToolRegistryProvider.StreamableHttpConfig.httpClient

Module: `agents-mcp`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-mcp/ai.koog.agents.mcp/-mcp-tool-registry-provider/-streamable-http-config/http-client.html`

### :agents:agents-mcp/commonMain

```kotlin
var httpClient: HttpClient?
```

HttpClient used for the MCP connection. Must have the Ktor SSE plugin installed (the Streamable HTTP transport relies on it).

If null (default), a private HttpClient is created internally and closed automatically when the underlying MCP transport closes. If a custom client is provided, the caller retains full responsibility for its lifecycle (we do not close it).

Example:

## ai.koog.agents.mcp.McpToolRegistryProvider.StreamableHttpConfig

Module: `agents-mcp`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-mcp/ai.koog.agents.mcp/-mcp-tool-registry-provider/-streamable-http-config/index.html`

### :agents:agents-mcp/commonMain

```kotlin
class StreamableHttpConfig
```

Configuration for connecting to an MCP server over the Streamable HTTP transport.

Used as the receiver of the configuration lambda passed to streamableHttp. The url property is required; the remaining properties have sensible defaults and are optional.

Example:

## ai.koog.agents.mcp.McpToolRegistryProvider.StreamableHttpConfig.mcpToolParser

Module: `agents-mcp`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-mcp/ai.koog.agents.mcp/-mcp-tool-registry-provider/-streamable-http-config/mcp-tool-parser.html`

### :agents:agents-mcp/commonMain

```kotlin
var mcpToolParser: McpToolDescriptorParser
```

Custom MCP tool descriptor parser.

## ai.koog.agents.mcp.McpToolRegistryProvider.StreamableHttpConfig.name

Module: `agents-mcp`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-mcp/ai.koog.agents.mcp/-mcp-tool-registry-provider/-streamable-http-config/name.html`

### :agents:agents-mcp/commonMain

```kotlin
var name: String
```

Client name reported to the server.

## ai.koog.agents.mcp.McpToolRegistryProvider.StreamableHttpConfig.url

Module: `agents-mcp`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-mcp/ai.koog.agents.mcp/-mcp-tool-registry-provider/-streamable-http-config/url.html`

### :agents:agents-mcp/commonMain

```kotlin
lateinit var url: String
```

MCP server URL (required).

## ai.koog.agents.mcp.McpToolRegistryProvider.StreamableHttpConfig.version

Module: `agents-mcp`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-mcp/ai.koog.agents.mcp/-mcp-tool-registry-provider/-streamable-http-config/version.html`

### :agents:agents-mcp/commonMain

```kotlin
var version: String
```

Client version reported to the server.

## ai.koog.agents.mcp.McpToolRegistryProvider.defaultSseTransport

Module: `agents-mcp`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-mcp/ai.koog.agents.mcp/-mcp-tool-registry-provider/default-sse-transport.html`

### :agents:agents-mcp/commonMain

```kotlin
fun defaultSseTransport(url: String, baseClient: HttpClient = HttpClient()): SseClientTransport
```

Creates a default server-sent events (SSE) transport from a provided URL.

An instance of SseClientTransport configured with the given URL.

- url — The URL to be used for establishing an SSE connection.
## ai.koog.agents.mcp.McpToolRegistryProvider.fromClient

Module: `agents-mcp`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-mcp/ai.koog.agents.mcp/-mcp-tool-registry-provider/from-client.html`

### :agents:agents-mcp/commonMain

```kotlin
suspend fun fromClient(mcpClient: Client, serverInfo: McpServerInfo, mcpToolParser: McpToolDescriptorParser = DefaultMcpToolDescriptorParser): ToolRegistry
```

Creates a ToolRegistry with tools from an existing MCP client.

This method retrieves all available tools from the MCP server using the provided client, transforms them into the agent framework's Tool interface, and registers them in a ToolRegistry.

A ToolRegistry containing all tools from the MCP server.

- mcpClient — The MCP client connected to an MCP server.
- serverInfo — Information about the MCP server.

Referenced packages: `ai.koog.agents.core.tools`, `ai.koog.agents.mcp.metadata`.

## ai.koog.agents.mcp.McpToolRegistryProvider.fromSseUrl

Module: `agents-mcp`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-mcp/ai.koog.agents.mcp/-mcp-tool-registry-provider/from-sse-url.html`

### :agents:agents-mcp/commonMain

```kotlin
suspend fun fromSseUrl(sseUrl: String, clientInfo: Implementation = Implementation(DEFAULT_MCP_CLIENT_NAME, DEFAULT_MCP_CLIENT_VERSION), mcpToolParser: McpToolDescriptorParser = DefaultMcpToolDescriptorParser): ToolRegistry
```

Creates a ToolRegistry with tools from an MCP server using a server-sent events (SSE) transport.


Referenced packages: `ai.koog.agents.core.tools`.

## ai.koog.agents.mcp.McpToolRegistryProvider.fromTransport

Module: `agents-mcp`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-mcp/ai.koog.agents.mcp/-mcp-tool-registry-provider/from-transport.html`

### :agents:agents-mcp/commonMain

```kotlin
suspend fun fromTransport(transport: Transport, serverInfo: McpServerInfo, mcpToolParser: McpToolDescriptorParser = DefaultMcpToolDescriptorParser, name: String = DEFAULT_MCP_CLIENT_NAME, version: String = DEFAULT_MCP_CLIENT_VERSION): ToolRegistry
```

Creates a ToolRegistry with tools from an MCP server using provided transport for communication.

This method establishes a connection to an MCP server through provided transport. It's typically used when the MCP server is running as a separate process (e.g., a Docker container or a CLI tool).

A ToolRegistry containing all tools from the MCP server.

- transport — The transport to use.
- serverInfo — Information about the MCP server.
- name — The name of the MCP client.
- version — The version of the MCP client.

Referenced packages: `ai.koog.agents.core.tools`, `ai.koog.agents.mcp.metadata`.

## ai.koog.agents.mcp.McpToolRegistryProvider

Module: `agents-mcp`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-mcp/ai.koog.agents.mcp/-mcp-tool-registry-provider/index.html`

### :agents:agents-mcp/commonMain

```kotlin
object McpToolRegistryProvider
```

A provider for creating tool registries that connect to Model Context Protocol (MCP) servers.

This class facilitates the integration of MCP tools into the agent framework by:

Connecting to MCP servers through various transport mechanisms (Streamable HTTP, stdio, SSE)

Retrieving available tools from the MCP server

Transforming MCP tools into the agent framework's Tool interface

Registering the transformed tools in a ToolRegistry

## ai.koog.agents.mcp.McpToolRegistryProvider.streamableHttp

Module: `agents-mcp`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-mcp/ai.koog.agents.mcp/-mcp-tool-registry-provider/streamable-http.html`

### :agents:agents-mcp/commonMain

```kotlin
suspend fun streamableHttp(block: McpToolRegistryProvider.StreamableHttpConfig.() -> Unit): ToolRegistry
```

Creates a ToolRegistry from a Streamable HTTP MCP server.

This is the recommended way to connect to remote MCP servers. Streamable HTTP supports bidirectional communication, session management, and reconnection.

If StreamableHttpConfig.httpClient is not set, a default HttpClient with the SSE plugin is created internally and closed automatically when the MCP transport closes. To reuse a single client across multiple MCP connections, set it explicitly — in that case the caller is responsible for closing it.

A ToolRegistry containing all tools from the MCP server.

- block — Configuration block for the Streamable HTTP connection.

Referenced packages: `ai.koog.agents.core.tools`.

## ai.koog.agents.mcp.defaultStdioTransport

Module: `agents-mcp`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-mcp/ai.koog.agents.mcp/default-stdio-transport.html`

### :agents:agents-mcp/jvmMain

```kotlin
fun McpToolRegistryProvider.defaultStdioTransport(process: Process): StdioClientTransport
```

Creates a default standard input/output transport for a provided process.

A StdioClientTransport configured to communicate with the process using its standard input and output.

- process — The process whose input and output streams will be used for communication.
## ai.koog.agents.mcp.fromProcess

Module: `agents-mcp`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-mcp/ai.koog.agents.mcp/from-process.html`

### :agents:agents-mcp/jvmMain

```kotlin
suspend fun McpToolRegistryProvider.fromProcess(process: Process, clientInfo: Implementation = Implementation(DEFAULT_MCP_CLIENT_NAME, DEFAULT_MCP_CLIENT_VERSION), mcpToolParser: McpToolDescriptorParser = DefaultMcpToolDescriptorParser): ToolRegistry
```

Creates a Mcp ToolRegistry instance from a process using default standard input/output transport.


Referenced packages: `ai.koog.agents.core.tools`.

## ai.koog.agents.mcp.metadata.McpMetadataKeys.Instructions

Module: `agents-mcp-metadata`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-mcp-metadata/ai.koog.agents.mcp.metadata/-mcp-metadata-keys/-instructions.html`

### :agents:agents-mcp-metadata/commonMain

```kotlin
const val Instructions: String
```

Optional server-provided instructions or documentation for using its tools.

## ai.koog.agents.mcp.metadata.McpMetadataKeys.McpProtocolVersion

Module: `agents-mcp-metadata`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-mcp-metadata/ai.koog.agents.mcp.metadata/-mcp-metadata-keys/-mcp-protocol-version.html`

### :agents:agents-mcp-metadata/commonMain

```kotlin
const val McpProtocolVersion: String
```

The MCP protocol version supported by this server connection.

## ai.koog.agents.mcp.metadata.McpMetadataKeys.McpSessionId

Module: `agents-mcp-metadata`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-mcp-metadata/ai.koog.agents.mcp.metadata/-mcp-metadata-keys/-mcp-session-id.html`

### :agents:agents-mcp-metadata/commonMain

```kotlin
const val McpSessionId: String
```

Unique identifier for the current MCP session, if session management is enabled. TODO: support McpSessionId when it would be available in the sdk client

## ai.koog.agents.mcp.metadata.McpMetadataKeys.McpTransportType

Module: `agents-mcp-metadata`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-mcp-metadata/ai.koog.agents.mcp.metadata/-mcp-metadata-keys/-mcp-transport-type.html`

### :agents:agents-mcp-metadata/commonMain

```kotlin
const val McpTransportType: String
```

The transport protocol type used for this connection (e.g., pipe for stdio, tcp for HTTP).

## ai.koog.agents.mcp.metadata.McpMetadataKeys.ServerPort

Module: `agents-mcp-metadata`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-mcp-metadata/ai.koog.agents.mcp.metadata/-mcp-metadata-keys/-server-port.html`

### :agents:agents-mcp-metadata/commonMain

```kotlin
const val ServerPort: String
```

The port number on which the server listens, if applicable.

## ai.koog.agents.mcp.metadata.McpMetadataKeys.ServerUrl

Module: `agents-mcp-metadata`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-mcp-metadata/ai.koog.agents.mcp.metadata/-mcp-metadata-keys/-server-url.html`

### :agents:agents-mcp-metadata/commonMain

```kotlin
const val ServerUrl: String
```

The URL where the server is accessible, if applicable (e.g., "http://localhost").

## ai.koog.agents.mcp.metadata.McpMetadataKeys.ToolId

Module: `agents-mcp-metadata`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-mcp-metadata/ai.koog.agents.mcp.metadata/-mcp-metadata-keys/-tool-id.html`

### :agents:agents-mcp-metadata/commonMain

```kotlin
const val ToolId: String
```

Required key to identify an MCP tool.

## ai.koog.agents.mcp.metadata.McpMetadataKeys

Module: `agents-mcp-metadata`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-mcp-metadata/ai.koog.agents.mcp.metadata/-mcp-metadata-keys/index.html`

### :agents:agents-mcp-metadata/commonMain

```kotlin
object McpMetadataKeys
```

Metadata keys for tools provided by MCP servers.

## ai.koog.agents.mcp.metadata.McpServerInfo.McpServerInfo

Module: `agents-mcp-metadata`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-mcp-metadata/ai.koog.agents.mcp.metadata/-mcp-server-info/-mcp-server-info.html`

### :agents:agents-mcp-metadata/commonMain

```kotlin
constructor(url: String? = null, command: String? = null)
```

## ai.koog.agents.mcp.metadata.McpServerInfo.command

Module: `agents-mcp-metadata`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-mcp-metadata/ai.koog.agents.mcp.metadata/-mcp-server-info/command.html`

### :agents:agents-mcp-metadata/commonMain

```kotlin
val command: String?
```

## ai.koog.agents.mcp.metadata.McpServerInfo

Module: `agents-mcp-metadata`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-mcp-metadata/ai.koog.agents.mcp.metadata/-mcp-server-info/index.html`

### :agents:agents-mcp-metadata/commonMain

```kotlin
class McpServerInfo(val url: String? = null, val command: String? = null)
```

Information about an MCP server instance.

## ai.koog.agents.mcp.metadata.McpServerInfo.url

Module: `agents-mcp-metadata`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-mcp-metadata/ai.koog.agents.mcp.metadata/-mcp-server-info/url.html`

### :agents:agents-mcp-metadata/commonMain

```kotlin
val url: String?
```

## ai.koog.agents.mcp.metadata.McpTransportType.Stdio

Module: `agents-mcp-metadata`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-mcp-metadata/ai.koog.agents.mcp.metadata/-mcp-transport-type/-stdio/index.html`

### :agents:agents-mcp-metadata/commonMain

```kotlin
Stdio
```

Pipe-based transport using standard input/output streams.

This transport is typically used for local MCP servers running as separate processes that communicate via stdio. Suitable for development and local tools.

## ai.koog.agents.mcp.metadata.McpTransportType.StreamableHttp

Module: `agents-mcp-metadata`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-mcp-metadata/ai.koog.agents.mcp.metadata/-mcp-transport-type/-streamable-http/index.html`

### :agents:agents-mcp-metadata/commonMain

```kotlin
StreamableHttp
```

HTTP-based Streamable HTTP transport.

This transport uses HTTP POST for sending messages and SSE for receiving, supporting bidirectional communication, session management, and reconnection. It is the recommended transport for remote MCP servers, replacing the legacy SSE transport.

## ai.koog.agents.mcp.metadata.McpTransportType.Tcp

Module: `agents-mcp-metadata`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-mcp-metadata/ai.koog.agents.mcp.metadata/-mcp-transport-type/-tcp/index.html`

### :agents:agents-mcp-metadata/commonMain

```kotlin
Tcp
```

TCP-based transport using HTTP or other network protocols.

This transport enables communication with remote MCP servers over network connections, including HTTP, SSE (Server-Sent Events), or custom TCP protocols. Suitable for distributed architectures and cloud-based MCP servers.

## ai.koog.agents.mcp.metadata.McpTransportType.Unknown

Module: `agents-mcp-metadata`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-mcp-metadata/ai.koog.agents.mcp.metadata/-mcp-transport-type/-unknown/index.html`

### :agents:agents-mcp-metadata/commonMain

```kotlin
Unknown
```

Represents an unknown or undefined transport protocol type.

This value is used as a fallback or default when the transport type cannot be identified or does not match any of the predefined types.

## ai.koog.agents.mcp.metadata.McpTransportType

Module: `agents-mcp-metadata`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-mcp-metadata/ai.koog.agents.mcp.metadata/-mcp-transport-type/index.html`

### :agents:agents-mcp-metadata/commonMain

```kotlin
enum McpTransportType : Enum<McpTransportType>
```

Enumeration of supported MCP server transport protocol types.

This enum defines the different communication mechanisms that can be used to establish connections with MCP servers. Each transport type has distinct characteristics and is suitable for different deployment scenarios.

## ai.koog.agents.mcp.metadata.McpTransportType.value

Module: `agents-mcp-metadata`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-mcp-metadata/ai.koog.agents.mcp.metadata/-mcp-transport-type/value.html`

### :agents:agents-mcp-metadata/commonMain

```kotlin
val value: String
```
