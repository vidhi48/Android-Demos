package com.example.demo.kotlinpractice.classesexamples

sealed class SealedClass {

    class A : SealedClass() {

        fun display() {
            println("class A")
        }
    }

    class B : SealedClass() {

        fun display() {
            println("class B")
        }
    }
}

class C : SealedClass() {

    fun display() {
        println("Class C")
    }
}

//Sealed class with when
sealed class Fruit(val name: String) {

    class Apple : Fruit("Apple")

    class Mango : Fruit("Mango")
}

class Grapes : Fruit("Grapes")

fun check(fruit: Fruit) {

    when (fruit) {
        is Fruit.Apple -> println("Fruit is ${fruit.name}")
        is Fruit.Mango -> println("Fruit is ${fruit.name}")
        is Grapes -> println("Fruit is ${fruit.name}")
        else -> println("No fruits")
    }
}