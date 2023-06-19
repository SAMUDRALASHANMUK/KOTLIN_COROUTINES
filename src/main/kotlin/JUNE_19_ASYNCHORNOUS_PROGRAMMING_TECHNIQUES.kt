import kotlinx.coroutines.*

suspend fun fetchData(): String {
    delay(2000) // Simulating an asynchronous operation
    return "Hello, World!"
}

fun main() {

    //Async/Await
    runBlocking {
        val result = async { fetchData() }.await()
        println("Fetched data: $result")
    }
}
