package com.example.demo.kotlinpractice

class Properties {

    var name: String = ""
        get() = field
        set(value) {
            field = value
        }
}

fun main() {

    val obj = Properties()
    println(obj.name)

    //override property
    val obj1 = SubDemo()
    obj1.display()
    println(obj1.name)
}

//Overriding properties
open class PropertiesDemo {

    open fun display() {
        println("superclass function")
    }

    open val name: String = "welcome"
}

class SubDemo : PropertiesDemo() {

    override fun display() {
        super.display()
        println("subclass function")
    }

    override val name: String
        get() = super.name
}