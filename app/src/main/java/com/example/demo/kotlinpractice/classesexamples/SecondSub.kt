package com.example.demo.kotlinpractice.classesexamples

class SecondSub : SecondConstructor {

    constructor(data: String) : this("from subclass: $data", 10)
    constructor(data: String, numberOfData: Int) : super(data, numberOfData) {
        println("Constructor")
    }
}