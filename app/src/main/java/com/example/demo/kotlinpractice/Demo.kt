package com.example.demo.kotlinpractice

fun main() {

    //Int
    var num: Int = 20
    num = 30
    println(num)
    val num2 = 30
    //num2 = 40
    var num3 = 2L

    //UInt
    var num4: UInt = 24u
    var num5 = 30U
    println(num5)
    val a = 1u

    //Boolean
    val myTrue: Boolean = true
    val myFalse: Boolean = false
    val boolNull: Boolean? = null

    println(myTrue || myFalse)
    println(myTrue && myFalse)
    println(!myTrue)

    //Char
    val aChar: Char = 'a'
    println(aChar)
    println('\uFF00')

    val bChar = '1'
    println(bChar.digitToInt())

    //String
    val str = "Hello 123"
    println(str)
    println("\uD83D\uDE01")

    val str2 = "hello " + 1
    println("$str2 world")
    println(str2[0])
    println(str2.get(2))
    println(str2.indices)

    //template
    val val1 = 5
    val val2 = 5
    val sum = val1 + val2
    println("Sum is $sum")

    //escaped String
    println("Hello \n world")

    //Raw String
    val newStr = """
        My
        name
        is
        vidhi
        """.trimIndent()
    println(newStr)

    val price = """
    ${'/'}_9.99
    """
    println(price)

    //Array
    println("arrayOf method")
    val arr1 = arrayOf(1, 2, 3)
    for (i in arr1) {
        println(i)
    }

    println("Array Constructor")
    val arr2 = Array(5) { i -> i * 1 }
    for (i in arr2) {
        println(arr2[i])
    }

    val arrays = intArrayOf(8, 4, 2)
    println(arrays.contentToString())

    val multiArray = arrayOf(
        intArrayOf(1, 2),
        intArrayOf(3, 4),
        intArrayOf(5, 6)
    )
    //println(Arrays.toString(multiArray))
    println(multiArray.contentDeepToString())
}