package com.example.demo.kotlinpractice.classesexamples

fun main() {

    val obj = DemoAbstract("vidhi")
    obj.displayGen("female")
    obj.displayAge(20)

    val obj2 = ClassDemo()
    println(obj2.display())

    val obj3 = DemoConstructor(age = 21)
    //println("Name: ${obj2.name}, Age: ${obj3.age}")

    val obj4 = SecondSub("hello", 20)

    val obj5 = DataClass("vidhi", 21)
    val obj6 = obj5.copy(age = 16)
    println("Name: ${obj5.name}, Age: ${obj5.age}")
    println("Name: ${obj6.name}, Age: ${obj6.age}")
    println(obj5.toString())

    //destructing object
    val (name, age) = obj5
    println("Name: $name, Age: $age")
    println(obj5.component1())
    println(obj5.component2())

    val obj7 = SubInherit("vidhi", 21, "female")
    obj7.display()

    val objSealed = SealedClass.A()
    objSealed.display()
    val objSealed2 = SealedClass.B()
    objSealed2.display()
    val objSealed3 = C()
    objSealed3.display()

    //Fruit example
    val objFr = Fruit.Apple()
    val objFr2 = Fruit.Mango()
    val objFr3 = Grapes()
    check(objFr)
    check(objFr2)
    check(objFr3)

    //companion object
    println(CompanionObject.name)
    println(CompanionObject.display())
}