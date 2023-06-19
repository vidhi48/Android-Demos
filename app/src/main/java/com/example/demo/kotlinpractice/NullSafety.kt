package com.example.demo.kotlinpractice

fun main() {

    var str = 10
    //str = null
    println(str)

    var str2: String? = "vidhi"
    println(str2)
    if (str2 != null) {
        println("String is $str2")
    } else {
        println("null")
    }

    //safe call operator
    var fname: String? = "vidhi"
    var lname: String? = null
    println(fname?.length)
    println(lname?.length)

    //with let
    var new = fname?.let { fname.uppercase() }
    println(new)

    //with elvis operator(?:)
    var str3: String? = "Welcome"
    str3 = null
    println(str3?.length ?: "default")

    //Not null assertion : !! Operator
    var str4: String? = "welcome"
    println(str4!!.length)
    str4 = null
    //str4!!.length
}