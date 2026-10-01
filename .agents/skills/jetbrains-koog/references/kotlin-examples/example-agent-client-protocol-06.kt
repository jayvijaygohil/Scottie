// Kotlin reference adapted from the supplied Koog 1.3.0 guide examples.
// See ../kotlin-examples.md for scope, dependencies, and validation status.
package ai.koog.agents.example.exampleAgentClientProtocol06

import ai.koog.agents.core.dsl.builder.strategy
import ai.koog.agents.core.dsl.builder.node
import ai.koog.agents.features.acp.withAcpAgent
import com.agentclientprotocol.model.AcpMethod
import com.agentclientprotocol.model.AuthMethodId
import com.agentclientprotocol.model.AuthenticateRequest
import com.agentclientprotocol.protocol.sendRequest

val strategy = strategy<Unit, Unit>("my-strategy") {
    val node by node<Unit, Unit> {
        withAcpAgent {
            protocol.sendRequest(
                AcpMethod.AgentMethods.Authenticate,
                AuthenticateRequest(methodId = AuthMethodId("Google"))
            )
        }
    }
}
