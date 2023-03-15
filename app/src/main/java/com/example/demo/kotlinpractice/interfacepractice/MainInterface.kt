package com.example.demo.kotlinpractice.interfacepractice

fun main() {

    val obj = InterfaceDemo()
    println(obj.mark)
    obj.display()
    obj.foo()

    val obj2 = DemoInterface()
    obj2.call()

    val languages = listOf("Hindi", "Gujarati")
    /*languageDisplay(languages) { println(it) }

    val newLambda: (FuncInterface) -> Unit = { greet: FuncInterface ->

    }
    languageDisplay(languages, newLambda)*/

    val lambda = FuncInterface { println(it) }
    languageDisplay(languages, lambda)

    val lambda2: (String) -> Unit = { println(it) }
    val lambda3 = { lam: String ->
        println(lam)
    }
    languageDisplay(languages, lambda3)
}

fun languageDisplay(language: List<String>, greet: FuncInterface) {
    language.forEach { greet.check(it) }
}