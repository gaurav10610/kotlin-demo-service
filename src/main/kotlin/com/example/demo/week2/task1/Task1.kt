package com.example.demo.week2.task1

import kotlinx.coroutines.*
import kotlin.math.pow

fun main() {
    solution1()
    solution2()
    solution3()
    solution4()
    solution5()
    solution6()
    solution7()
    solution8()
    solution9()
}

/**
 * solution 1
 */
fun solution1() {
    fun List<Int>.sum(): Int {
        return this.reduce { acc, ele -> acc + ele }
    }

    val list: List<Int> = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
    println("sum of list: ${list.sum()}")
}

/**
 * solution 2
 */
fun solution2() {
    class Person(val name: String, val age: Int, val email: String) {
        override fun toString(): String {
            return "[ $name, $age, $email ]"
        }
    }

    val list: List<Person> = listOf(Person("Gaurav", 40, "123@gmail.com"), Person("Paras", 25, "321@gmail.com"))

    println("persons having age > 30: ${list.filter { person -> person.age > 30 }}")

    /**
     * mapper function
     */
    fun mapToString(person: Person): String {
        return "( ${person.name}, ${person.age}, ${person.email} )"
    }

    println("mapped persons list: ${list.map { person -> mapToString(person) }}")
}

/**
 * solution 3
 */
fun solution3() {
    suspend fun myCoroutine() {
        delay(2000L)
        println("Task Completed")
    }

    val job = GlobalScope.launch(Dispatchers.Default) {
        async { myCoroutine() }
    }
    runBlocking {
        job.join()
    }
}

/**
 * solution 4
 */
fun solution4() {

    val myFilterLambdaFn: (List<String>, Int) -> List<String> =
        { list, len -> list.filter { item -> item.length == len } }

    fun myHigherOrderFunction(
        list: List<String>, len: Int, myLambdaFn: (List<String>, Int) -> List<String>
    ): List<String> {
        return myLambdaFn(list, len)
    }

    val list: List<String> = listOf("Gaurav", "Kumar", "Yadav")
    println("original list: $list")
    println("filtered list: ${myHigherOrderFunction(list, 6, myFilterLambdaFn)}")
}

/**
 * solution 5
 */
fun solution5() {
    fun <T> swapElements(list: MutableList<T>, index1: Int, index2: Int) {
        val temp = list[index1]
        list[index1] = list[index2]
        list[index2] = temp
    }

    // Test with a list of strings
    val stringList = mutableListOf("apple", "banana", "orange", "grape")
    println("Before swapping: $stringList")
    swapElements(stringList, 1, 3)
    println("After swapping: $stringList")

    // Test with a list of integers
    val intList = mutableListOf(1, 2, 3, 4, 5)
    println("Before swapping: $intList")
    swapElements(intList, 0, 4)
    println("After swapping: $intList")
}

/**
 * solution 6
 */
fun solution6() {
    val circle = Circle(5.0)
    val rectangle = Rectangle(3.0, 4.0)

    println("Area of the circle: ${circle.calculateArea()}")
    println("Area of the rectangle: ${rectangle.calculateArea()}")
}

sealed class Shape {
    abstract fun calculateArea(): Double
}

class Circle(private val radius: Double) : Shape() {
    override fun calculateArea(): Double {
        return Math.PI * radius * radius
    }
}

class Rectangle(private val width: Double, private val height: Double) : Shape() {
    override fun calculateArea(): Double {
        return width * height
    }
}

/**
 * solution 7
 */
fun solution7() {
    // Create an instance of the dependency injection container
    val diContainer = DIContainer()

    // Register the ServiceImpl with the Service interface in the container
    diContainer.registerService(Service::class.java, ServiceImpl())

    // Retrieve the ServiceImpl from the container
    val service = diContainer.getService(Service::class.java)

    // Create an instance of the Client class with the injected service
    val client = Client(service)

    // Use the service through the client
    println(client.useService())
}

// Define the Service interface
interface Service {
    fun doSomething(): String
}

// Provide an implementation for the Service interface
class ServiceImpl : Service {
    override fun doSomething(): String {
        return "Service implementation doing something"
    }
}

// Define a class that depends on the Service interface
class Client(private val service: Service) {
    fun useService(): String {
        return "Client using service: ${service.doSomething()}"
    }
}

// Simple Dependency Injection Framework
class DIContainer {
    private val services: MutableMap<Class<*>, Any> = mutableMapOf()

    fun <T : Any> registerService(serviceInterface: Class<T>, serviceImpl: T) {
        services[serviceInterface] = serviceImpl
    }

    @Suppress("UNCHECKED_CAST")
    fun <T> getService(serviceInterface: Class<T>): T {
        return services[serviceInterface] as T
    }
}

/**
 * solution 8
 */
fun solution8() {
    val html = HTML()
    html.head {
        title("Sample HTML Page")
    }
    html.body {
        h1("Welcome to my website")
        p("This is a sample HTML page generated using Kotlin DSL")
    }

    println(html.toString())
}

// Define the HTML DSL using type-safe builders
class HTML {
    private val elements = mutableListOf<Any>()

    fun head(init: Head.() -> Unit) {
        val head = Head().apply(init)
        elements.add(head)
    }

    fun body(init: Body.() -> Unit) {
        val body = Body().apply(init)
        elements.add(body)
    }

    override fun toString(): String {
        val sb = StringBuilder()
        sb.append("<html>")
        elements.forEach { sb.append(it.toString()) }
        sb.append("</html>")
        return sb.toString()
    }
}

class Head {
    private val elements = mutableListOf<Element>()

    fun title(title: String) {
        elements.add(Element("title", title))
    }

    override fun toString(): String {
        val sb = StringBuilder()
        sb.append("<head>")
        elements.forEach { sb.append(it.toString()) }
        sb.append("</head>")
        return sb.toString()
    }
}

class Body {
    private val elements = mutableListOf<Element>()

    fun h1(text: String) {
        elements.add(Element("h1", text))
    }

    fun p(text: String) {
        elements.add(Element("p", text))
    }

    override fun toString(): String {
        val sb = StringBuilder()
        sb.append("<body>")
        elements.forEach { sb.append(it.toString()) }
        sb.append("</body>")
        return sb.toString()
    }
}

class Element(private val tag: String, private val text: String) {
    override fun toString(): String {
        return "<$tag>$text</$tag>"
    }
}

/**
 * solution 9
 */
fun solution9() {
    val list: List<Int> = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    println("sum of squares of all even numbers in the list is: ${
        list.filter { num -> num % 2 == 0 }.map { num -> num.toDouble().pow(2) }.reduce { acc, ele -> acc + ele }
            .toInt()
    }"
    )
}


