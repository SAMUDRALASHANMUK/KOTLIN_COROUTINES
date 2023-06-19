import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

/*
In Kotlin, to create a suspending function, you must explicitly use the suspend modifier.
It indicates that the function can suspend its execution without blocking the underlying thread.

If you create a function without the suspend modifier, it will be a regular function that runs
synchronously. It cannot be used with coroutines or suspending functions and will execute
sequentially on the calling thread.

 */


fun regularFunction() {
    // Synchronous code
    println("Regular function")
}

suspend fun suspendingFunction() {
    // Asynchronous code
    delay(1000)
    println("Suspending function")
}

fun main() {
    regularFunction()
    runBlocking {
        suspendingFunction()
    }
}
