fun main() {
    // solution 1
    var price = 19.99
    price = 29.99
    println(price)

    // solution 2
    val nullSafeString: String = "this is null safe string̰"
    println(nullSafeString)

    // solution 3
    val sentence = "Kotlin is concise and expressive"
    val vowelCount = countVowels(sentence)
    println("Number of vowels in the sentence: $vowelCount")

    // solution 4.a
    val favoriteLanguages = mutableListOf("Kotlin", "Java", "Python", "JavaScript")
    println("Initial list of favorite programming languages: $favoriteLanguages")
    favoriteLanguages.add("Swift")
    println("List after adding a new language: $favoriteLanguages")
    favoriteLanguages.remove("Java")
    println("List after removing one language: $favoriteLanguages")

    // solution 4.b
    performCollectionOperations()

    // solution 5
    class MyCar(var make: String, var model: String, var year: Int) {
        override fun toString(): String {
            return "[ $make, $model, $year ]"
        }
    }

    val c2 = MyCar("BMW", "X5", 1999)
    println(c2)

    // solution 6
    val list: List<Int> = arrayListOf<Int>(5, 10, 15, 20, 25).filter { num -> num % 5 == 0 }.toList()
    println(list)

    // solution 7.a
    val input = "123abc" // Input string that may cause NumberFormatException

    try {
        val number = input.toInt() // Try to convert the input string to an integer
        println("Parsed number: $number") // This line will only execute if no exception is thrown
    } catch (e: NumberFormatException) {
        println("Error: Unable to parse the input string to an integer.") // Print an error message if NumberFormatException occurs
        println("Exception message: ${e.message}") // Print the exception message
    }

    // solution 7.b
    val result = runCatching { methodThatThrowsException() }

    // Checking if the operation was successful
    if (result.isSuccess) {
        println("Operation was successful.")
        val value = result.getOrNull() // Getting the result if it's not null
        println("Result: $value")
    } else {
        println("Operation failed due to exception.")
        val exception = result.exceptionOrNull() // Getting the exception if there was one
        println("Exception: $exception")
    }
}

fun countVowels(sentence: String): Int {
    val vowels = "aeiouAEIOU"
    var count = 0
    for (char in sentence) {
        if (char in vowels) {
            count++
        }
    }
    return count
}

fun performCollectionOperations() {
    // Immutable List
    val immutableList = listOf("Apple", "Banana", "Orange")
    println("Immutable List: $immutableList")

    // Mutable List
    val mutableList = mutableListOf("Apple", "Banana", "Orange")
    mutableList.add("Grape") // Add an element
    mutableList.remove("Banana") // Remove an element
    mutableList[0] = "Cherry" // Update an element
    val mutableListCopy = mutableList.toList() // Copy the mutable list to an immutable list
    println("Mutable List: $mutableList")
    println("Mutable List Copy: $mutableListCopy")

    // Immutable Map
    val immutableMap = mapOf(1 to "One", 2 to "Two", 3 to "Three")
    println("Immutable Map: $immutableMap")

    // Mutable Map
    val mutableMap = mutableMapOf(1 to "One", 2 to "Two", 3 to "Three")
    mutableMap[4] = "Four" // Add an entry
    mutableMap.remove(2) // Remove an entry
    mutableMap[1] = "Uno" // Update an entry
    val mutableMapCopy = mutableMap.toMap() // Copy the mutable map to an immutable map
    println("Mutable Map: $mutableMap")
    println("Mutable Map Copy: $mutableMapCopy")

    // Immutable Set
    val immutableSet = setOf("Apple", "Banana", "Orange")
    println("Immutable Set: $immutableSet")

    // Mutable Set
    val mutableSet = mutableSetOf("Apple", "Banana", "Orange")
    mutableSet.add("Grape") // Add an element
    mutableSet.remove("Banana") // Remove an element
    val mutableSetCopy = mutableSet.toSet() // Copy the mutable set to an immutable set
    println("Mutable Set: $mutableSet")
    println("Mutable Set Copy: $mutableSetCopy")
}

fun methodThatThrowsException() {
    // Throw an exception (for demonstration purposes)
    throw IllegalArgumentException("Invalid argument provided.")
}
