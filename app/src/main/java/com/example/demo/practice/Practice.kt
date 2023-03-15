package com.example.demo.practice

import kotlin.properties.Delegates

enum class Practice(val color: String) {

    Sunday("Black"),
    Monday("Green")
}

fun main() {

    for (i in Practice.values()) {
        println("${i.ordinal} = ${i.name}")
    }
    println(Practice.Monday.color)

    val obj1 = DelegateExample(10)
    DerivedDelegate(obj1).foo()

    println(lazyProperty)
    println(lazyProperty)

    check({ println("First lambda function") },
        { println("Second lambda function") }
    )

    val obj2 = Demo()
    obj2.obProp = "vidhi"
    obj2.obProp = "new"

    //using if-else
    var str: String? = "vidhi"
    str = null
    println(str)
    if (str != null)
        println(str.length)
    else
        println("null value")

    // ?. safe call operator
    var str2: String? = null
    println(str2?.length)

    //let
    str2?.let { println(str2.uppercase()) }

    //Elvis operator
    println(str2?.length ?: "hello")

    val newLambda = { println("Lambda") }
    newLambda()

    printSum(sum = { a, b -> a + b })

    val sum = { x: Int, y: Int -> x + y }
    println(sum(10, 10))

    val sum2: (Int, Int) -> Int = { a, b -> a + b }
    println(sum2(4, 4))

    display(50) { println("Num is $it") }

    display2(product = { a, b ->
        val product = a * b
        println(product)
    }, 5, 5)

    val language = listOf("Hindi", "Gujarati")
    println(displayOf(language) { println(it) })

    val map1 = mapOf(1 to "one", 2 to "two")
    val ans1 = map1.keys.toList()
    val ans2 = map1.values.toList()
    println(ans1)
    println(ans2)

    val objNew = listOf(Example("vidhi", 25), Example("new name", 55))
    objNew.map {
        it.age += 4
        it
    }.also { println(it) }

    //null safety
    var null1: String? = "Hello"
    println(null1?.length)

    if (null1 != null)
        println(null1.uppercase())
    else
        println("null values")

    null1?.let { println(null1.subSequence(2, 4)) }

    println(null1!!.drop(2))

    val list1 = listOf(1, 2, 3)
    repeat(3) {
        println(list1)
    }

}

data class Example(var name: String, var age: Int)

val lazyProperty: String by lazy {
    "welcome"
}

class Demo {
    var obProp: String by Delegates.observable("Initial vale") { property, oldValue, newValue ->
        println("$oldValue -> $newValue")
    }
}

interface A {
    fun foo()
}

class DelegateExample(val age: Int) : A {
    override fun foo() {
        println("Age: $age")
    }
}

class DerivedDelegate(del: A) : A by del

inline fun check(crossinline myFirst: () -> Unit, mySecond: () -> Unit) {
    myFirst()
    mySecond()
}

fun printSum(sum: (Int, Int) -> Int) {
    println(sum(10, 20))
}

fun display(x: Int, operation: (Int) -> Unit) {
    operation(x)
}

fun display2(product: (Int, Int) -> Unit, num1: Int, num2: Int) {
    product(num1, num2)
}

fun displayOf(language: List<String>, action: (String) -> Unit) {
    language.forEach(action)
}
