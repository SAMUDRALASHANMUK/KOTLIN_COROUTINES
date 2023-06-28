import java.io.File
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.runBlocking

// HASHMAP CONTAINS SCORES OF ALL THE WORDS
val scores = mapOf(
    "good" to 1,
    "great" to 2,
    "bad" to -1,
    "terrible" to -2
)

fun main() = runBlocking {

    // LIST OF FILES
    val fileNames = listOf(
        "C:\\Users\\shanmuk.s\\IdeaProjects\\KOTLIN_COROUTINES\\files\\sample1.txt",
        "C:\\Users\\shanmuk.s\\IdeaProjects\\KOTLIN_COROUTINES\\files\\sample2.txt",
        "C:\\Users\\shanmuk.s\\IdeaProjects\\KOTLIN_COROUTINES\\files\\sample3.txt",
        "C:\\Users\\shanmuk.s\\IdeaProjects\\KOTLIN_COROUTINES\\files\\sample4.txt",
        "C:\\Users\\shanmuk.s\\IdeaProjects\\KOTLIN_COROUTINES\\files\\sample5.txt"
    )

    val fileTasks = fileNames.map { fileName ->
        async {

            val file = File(fileName)
            val totalScore = processFile(file)
            val occurrences = countOccurrences(file)
            val wordOccurrences = getWordOccurrences(file)

            val sentiment = when {
                totalScore > 0 -> "positive"
                totalScore < 0 -> "negative"
                else -> "neutral"
            }

            val newFile = File(file.parent, "$sentiment${file.name}")
            file.renameTo(newFile)
            "$fileName - Occurrences: $occurrences, Score: $totalScore\nWord Occurrences: $wordOccurrences"
        }
    }

    // RESULTS ARE PRINTED HERE USED AWAIT SO THAT IT WILL BE WAITED ALL THE FILES ARE ITERATED
    val results = fileTasks.awaitAll()
    results.forEach { result ->
        println(result)
    }
}

// FUNCTION USED TO CALCULATE SUM OF SENTIMENT SCORES
fun processFile(file: File): Int = with(file) {
    readText()
        .split(" ")
        .sumOf { scores[it] ?: 0 }
}

// FUNCTION USED TO CALCULATE THE NUMBER OF WORDS
fun countOccurrences(file: File): Int = with(file) {
    readText()
        .split(" ")
        .count()
}

// FUNCTION USED TO GET WORD OCCURRENCES
fun getWordOccurrences(file: File): Map<String, Int> = with(file) {
    readText()
        .split(" ")
        .filter { it in scores.keys }
        .groupingBy { it }
        .eachCount()
}

