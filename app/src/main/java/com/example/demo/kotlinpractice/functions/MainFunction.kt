package com.example.demo.kotlinpractice.functions

import kotlin.reflect.typeOf

fun main() {

    val objDemo = FuncInterface()
    println(objDemo.name)
    objDemo.find()

    val arr = arrayOf(1, 5, 7, 9).sum()
    println(arr)

    //user-defined function
    fun add(num1: Int = 5, num2: Int): Int {
        return num1 + num2
    }

    val res = add(num2 = 10) //named arg
    println("Sum: $res")

    fun display(name: String) {
        if (name != null) {
            println("Hello $name")
        } else {
            println("hiii")
        }
    }
    display("vidhi")

    //single line function
    fun mul(x: Int) = x * 2
    println(mul(5))

    //vararg
    fun addNum(vararg num: Int): Int = num.sum()
    println(addNum(1, 5, 7, 9))

    fun addNames(vararg num: Int, name: String) {
        println("Sum: ${num.sum()} and name: $name")
    }
    addNames(2, 4, 9, name = "vidhi")

    //infix call
    val obj = Demo()
    println(obj display 4)

    //recursion - fact
    val ansOf = fact(4)
    println("Factorial: $ansOf")

    //lambdas
    println(sum2(5, 7))

    //shorthand lambda
    println(arrNum.filter { it > 0 })

    //anonymous functions
    println(anonymousExample(5, 6))
    println(mul(5, 6))

    //inline
    println(foo { println("inline fun") })

    //cross-inline
    inDemo({ println("First inline ") }, { println("Second inline") })

    //extension function
    val stu = Student()
    val result1 = stu.markStudent(20)
    println("Student result: $result1")
    val result2 = stu.isMark(70)
    println("Student result: $result2")

    //Extension overload
    Example().printFunctionType()
    Example2().printFunctionType(1)

    //extension property
    val a = ExtensionDemo2(20)
    println(a.sumNu)
    a.sumNu = 10
    println(a.a)

    //let
    val name: String? = "vidhi"
    val ans = name?.let {
        println(it.length)
    }

    //with
    val p1 = ScopeFunction()
    val info = with(p1) {
        println(this.gender)
        println(this.marks)
    }

    //run
    val p2: ScopeFunction? = null
    p2?.run {
        println(gender)
    }

    //apply
    val p3 = ScopeFunction().apply {
        sub1 = "Kotlin"
        sub2 = "Java"
    }
    with(p3) {
        println(sub1)
        println(sub2)
    }

    //also
    val list = mutableListOf<Int>(2, 5, 7)
    list.also {
        it.add(9)
        it.remove(2)
    }
    println(list)

    //lambda
    val sum = { x: Int, y: Int -> x + y }
    println(sum(10, 4))

    val sum2: (Int, Int) -> Int = { x, y -> x + y }
    println(sum2(10, 10))

    val sum3 = { num1: Int, num2: Int ->
        val sum = num1 + num2
        println(sum)
    }
    sum3(5, 4)

    val person = { name: String, age: Int ->
        println("Name: $name, Age: $age")
    }
    person("vidhi", 21)

    val listOfNumbers = listOf(1, 2, 3)
    println(listOfNumbers.filter { it > 0 })

    val list2 = listOf("one", "two", "three")
    val temp = list2.filterIndexed { index, s -> index > 1 && s.length > 3 }
    println(temp)

    val list3 = listOf(7, 8, 9)
    println(list3.filter { item: Int -> item > 8 })

}