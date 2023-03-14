package com.example.demo.kotlinpractice

import kotlin.properties.Delegates

//Delegation
interface DelegateDemo {
    fun display()
}

class Practice(val num: Int) : DelegateDemo {
    override fun display() {
        println(num)
    }
}

class Derived(b: DelegateDemo) : DelegateDemo by b

//lazy Delegate Property
val name: String by lazy {
    println("Welcome")
    "new"
}

//Observable Delegate Property
class ObservableDel {
    var age: Int by Delegates.observable(10) { property, oldValue, newValue ->
        println("$oldValue -> $newValue")
    }
}

fun main() {
    val obj = Practice(10)
    Derived(obj).display()

    println(name)
    println(name)

    val obj1 = ObservableDel()
    obj1.age = 50
    obj1.age = 70

    val objNew = A("vidhi", 20)
    val objNew2 = A("vidhi", 20)
    val newset = setOf(objNew, objNew2)
    println(objNew == objNew2)

}

data class A(val name: String, val age: Int)