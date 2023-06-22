import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

/*
You are working on a messaging application that sends notifications asynchronously. The application should have the following features:

Create a function called sendNotification that takes a message as input and sends it asynchronously.
The function should return a Deferred object representing the asynchronous operation.

Use the async builder function to implement the sendNotification function. Inside the async block,
simulate a delay of 1 second to mimic the notification sending process.
Then, print the message as a notification.

Use the runBlocking function to create a coroutine scope and call the sendNotification function for multiple messages concurrently.
Store the returned Deferred objects in a list.

Use destructuring declarations to extract the messages from the Deferred objects once they are complete. Print the messages as notifications.

 */

import kotlinx.coroutines.*


data class Notification(val message: String)

fun sendNotification(message: String): Deferred<Notification> = GlobalScope.async {
    delay(1000) // Simulate the notification sending process
    println("Notification: $message")
    Notification(message)
}

fun main() = runBlocking {
    val messages = listOf("Hello", "World", "Kotlin", "Coroutines")
    val notifications = mutableListOf<Deferred<Notification>>()

    for (message in messages) {
        val notification = sendNotification(message)
        notifications.add(notification)
    }

    val receivedNotifications = mutableListOf<String>()

    for (notification in notifications) {
        val (message) = notification.await()
        receivedNotifications.add(message)
    }

    for (message in receivedNotifications) {
        println("Received notification: $message")
    }
}
