package com.example.demo.kotlinpractice.genericpractice

//Generic Class
class GenericClass<T>(text: T) {

    var name = text

    init {
        println(name)
    }
}

//Reified Generic function
inline fun <reified T> genericExample(value: T) {
    println(value)
    println("Type: ${T::class.java}")
}

inline fun <reified T> showMessage(marks: Int): T {
    return when (T::class) {
        Int::class -> marks as T
        String::class -> "You scored more than 90%" as T
        else -> "Enter valid type" as T
    }
}

fun main() {

    var obj1 = GenericClass("Hello")
    var obj2 = GenericClass(20.78334)

    genericExample("Vidhi")
    genericExample(10)

    val markInt: Int = showMessage(70)
    val markString: String = showMessage(95)
    println("Marks: $markInt \nMessage: $markString")

    //out
    var co1: CovarianceDemo<out Any> = CovarianceDemo<Int>(21)

    //in
    var a: Container<Dog> = Container<Animal>()
    //var b: Container<Animal> = Container<Dog>()

    //Type-Projection
    val arr1: Array<Int> = arrayOf(1, 5, 7)
    val arr2: Array<Any> = Array<Any>(3) {}
    copy(arr1, arr2)

    //star-projection
    val name = arrayOf("Sunday", "Monday", "Tuesday")
    printArray(name)

  /*  println(listObj1 == listObj2)
    obj1.age = 90
    println(listObj1 == listObj2)*/
}

//in-Contra-covariance
open class Animal

class Dog : Animal()

class Container<in T>

//Type-Projection
fun copy(from: Array<out Any>, to: Array<Any>) {
    assert(from.size == to.size)
    for (i in from.indices)
        to[i] = from[i]
    for (i in to.indices)
        println(to[i])
}

//star-projection
fun printArray(arr: Array<*>) {
    arr.forEach { print(it) }
}