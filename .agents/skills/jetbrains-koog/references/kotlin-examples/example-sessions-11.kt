// Kotlin reference adapted from the supplied Koog 1.3.0 guide examples.
// See ../kotlin-examples.md for scope, dependencies, and validation status.
package ai.koog.agents.example.exampleSessions11

import ai.koog.agents.core.dsl.builder.strategy
import ai.koog.agents.core.dsl.builder.node
import ai.koog.agents.ext.tool.AskUser
import ai.koog.agents.core.agent.session.callTool
import ai.koog.agents.core.agent.session.callToolRaw

val myTool = AskUser
val myArgs = AskUser.Args("this is a string")

typealias MyTool = AskUser


val strategy = strategy<Unit, Unit>("strategy-name") {
    val node by node<Unit, Unit> {

llm.writeSession {
    // Call a tool by reference
    val result = callTool(myTool, myArgs)

    // Call a tool by name
    val result2 = callTool("myToolName", myArgs)

    // Call a tool by class
    val result3 = callTool(MyTool::class, myArgs)

    // Call a tool and get the raw result
    val rawResult = callToolRaw("myToolName", myArgs)
}
   }
}
