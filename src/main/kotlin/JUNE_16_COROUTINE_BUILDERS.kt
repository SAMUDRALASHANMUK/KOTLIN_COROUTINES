
/*
coroutine builders are used for creating coroutines
there are 3 *launch GlobalScope.launch{}

 *async GlobalScope.async{}
 *runBlocking (we dont have any function)

 */

import kotlinx.coroutines.*
fun main(){
    runBlocking {
        println("Main program starts Current thread is ${Thread.currentThread().name}")
        var job : Job = launch {
            println("Doing some work started ${Thread.currentThread().name}")
            println("Work finished ${Thread.currentThread().name}")

        }
        //job.cancel we can cancel also
        job.join()
        println("Main program executed Current thread is ${Thread.currentThread().name}")
    }
}
//Job deferred for async which is subclass of job
//if we give integer as output for lambda we can use await also
//if we use globalscope.async it will run on application level we dont know at application level
//defreed subclass of job interface
//we can reterieve some data using variable which can retur defreed result
//practically we have not use like shown in the demo
//what is praxctically use of runblocking