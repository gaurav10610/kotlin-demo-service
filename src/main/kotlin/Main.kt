fun main() {
    var num: Int = 5
    var numLong = num.toLong()
    println(numLong)

    val text = "this is first kotlin demo"
    println(text.equals("gaurav"))

    val cars: Array<String> = arrayOf("Volvo", "BMW", "Ford", "Mazda")
    cars.forEach { car -> println(car) }
    for(car in cars) {
        println(car + " ")
    }

    for(x in 2..15) {
        println(x)
    }

    class Car {
        var brand = ""
        var model = ""
        var year = 0
    }

    var c1 = Car()
    c1.year = 100
    println(c1.year)

    class MyCar(var brand: String, var model: String, var year: Int)
    val c2 = MyCar("BMW", "X5", 1999)
    println(c2)

    // Superclass
    open class MyParentClass {
        val x = 5
    }

    // Subclass
    class MyChildClass: MyParentClass() {
        fun myFunction() {
            println(x) // x is now inherited from the superclass
        }
    }
    val myObj = MyChildClass()
    myObj.myFunction()

    var list: List<String> = arrayListOf("Gaurav", "Kumar", "Yadav")
    println(list)
}