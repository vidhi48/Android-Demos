package com.example.demo.kotlinpractice.classesexamples

//Secondary Constructor
open class SecondConstructor {

    var data: String = ""
    var numOfData: Int = 0

    constructor(_data: String) {
        data = _data
    }

    constructor(data: String, numberOfData: Int) {
        this.data = data
        this.numOfData = numberOfData
        println("$data: $numOfData")
    }
}