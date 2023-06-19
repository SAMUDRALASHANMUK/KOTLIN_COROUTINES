import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/*
The launch coroutine builder is used to launch a new coroutine and returns a reference to its Job.
It runs the code block asynchronously and does not wait for the coroutine to complete.
 */

fun main()= runBlocking {
val job = launch {
    delay(1000)
    println("coroutine is completed")

}
}