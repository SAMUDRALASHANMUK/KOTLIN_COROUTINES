//I/O Thread (Dispatchers.IO):
//The I/O thread dispatcher is designed for I/O-bound tasks, such as network requests or disk I/O operations.
// It uses a pool of threads optimized for I/O operations, allowing for efficient execution of asynchronous tasks.
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.Dispatchers

fun performNetworkRequest() {
    runBlocking {
        launch(Dispatchers.IO) {
            // Perform network request or I/O operation here
            // This code runs on the I/O thread dispatcher
        }
    }
}

/*
Main Thread (Dispatchers.Main):
The main thread dispatcher is specifically designed for UI-related tasks in Android applications.
It executes coroutines on the main thread, which is responsible for updating the user interface.
 */


fun updateUI() {
    runBlocking {
        launch(Dispatchers.Main) {
            // Update UI components here
            // This code runs on the main thread dispatcher
        }
    }
}

/*
Default Thread (Dispatchers.Default):
The default thread dispatcher is suitable for general-purpose tasks that are not CPU-intensive
or I/O-bound. It uses a shared background thread pool and is designed to balance between computational
and I/O tasks.
 */



fun performTask() {
    runBlocking {
        launch(Dispatchers.Default) {
            // Perform general-purpose task here
            // This code runs on the default thread dispatcher
        }
    }
}
