import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
//Each coroutine has its own coroutine scope
fun main():Unit = runBlocking {
    println("runblocking $this")
    launch {
        println(message = "launch $this")
        launch {
            println("CHild coroutine : $this")
        }
    }
    async {
        println("Async coroutine : $this")
    }

}