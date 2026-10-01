// Kotlin reference adapted from the supplied Koog 1.3.0 guide examples.
// See ../kotlin-examples.md for scope, dependencies, and validation status.
package ai.koog.agents.example.exampleEmbeddings05

import ai.koog.embeddings.base.Embedder

suspend fun compareCodeToCode(embedder: Embedder) { // Embedder type
    // Two implementations of the same algorithm in Kotlin
    val kotlinCode = """
        fun fibonacci(n: Int): Int {
            return if (n <= 1) n else fibonacci(n - 1) + fibonacci(n - 2)
        }
    """.trimIndent()

    val iterativeCode = """
        fun fibonacci(n: Int): Int {
            var previous = 0
            var current = 1
            repeat(n) {
                val next = previous + current
                previous = current
                current = next
            }
            return previous
        }
    """.trimIndent()

    val sortingCode = """
        fun bubbleSort(values: IntArray): IntArray {
            val result = values.copyOf()
            for (end in result.lastIndex downTo 1) {
                for (index in 0 until end) {
                    if (result[index] > result[index + 1]) {
                        val saved = result[index]
                        result[index] = result[index + 1]
                        result[index + 1] = saved
                    }
                }
            }
            return result
        }
    """.trimIndent()

    // Generate embeddings
    val kotlinEmbedding = embedder.embed(kotlinCode)
    val iterativeEmbedding = embedder.embed(iterativeCode)
    val sortingEmbedding = embedder.embed(sortingCode)

    // Calculate differences
    val diffRecursiveIterative = embedder.diff(kotlinEmbedding, iterativeEmbedding)
    val diffFibonacciSorting = embedder.diff(kotlinEmbedding, sortingEmbedding)

    println("Difference between recursive and iterative Fibonacci implementations: $diffRecursiveIterative")
    println("Difference between Fibonacci and sorting implementations: $diffFibonacciSorting")

    // The recursive and iterative Fibonacci implementations should be more similar
    if (diffRecursiveIterative < diffFibonacciSorting) {
        println("The Kotlin code is more similar to the iterative Fibonacci code")
    } else {
        println("The Kotlin code is more similar to the sorting code")
    }
}
