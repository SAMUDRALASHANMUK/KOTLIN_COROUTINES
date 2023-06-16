import kotlinx.coroutines.*


fun main() {
    runBlocking {


        println("Main program starts : ${Thread.currentThread().name}")
        GlobalScope.launch {
            println("Fake work starts : ${Thread.currentThread().name}")
            //Thread.sleep(1000)
            delay(1000)
            println("Fake work ends : ${Thread.currentThread().name}")

        }
//Thread.sleep(2000)
        mySuspendfun(1000L)
        runBlocking { delay(1000) }

        println("Main program ends : ${Thread.currentThread().name}")

    }
}

suspend fun mySuspendfun(time: Long) {
    delay(time)
}


