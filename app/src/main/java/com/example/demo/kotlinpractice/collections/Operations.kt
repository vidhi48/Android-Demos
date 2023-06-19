package com.example.demo.kotlinpractice.collections

fun main() {

    val listDemo1 = listOf("one", "two", "three", "four", "five")
    println("List: $listDemo1")
    println("Number of element: ${listDemo1.size}")
    println("Access Element: ${listDemo1[2]}")
    println("Access using get: ${listDemo1.get(0)}")
    println("Return index of four: ${listDemo1.indexOf("four")}")
    println("Index of last: ${listDemo1.lastIndexOf("five")}")
    println("Sublist: ${listDemo1.subList(2, 4)}")
    println()

    val obj1 = CollectionDemo("vidhi", 21)
    val listObj1 = listOf(CollectionDemo("patel", 45), obj1)
    val listObj2 = listOf(CollectionDemo("patel", 45), CollectionDemo("vidhi", 21))

    val new = listObj2.map {
        it.age += 2
        it
    }.also {
        println(it)
    }

    //mutableList
    val listDemo2 = mutableListOf(1, 2, 3, 4)
    listDemo2.add(5)
    listDemo2.add(0, 90)
    listDemo2[2] = 96
    println(listDemo2)
    listDemo2.remove(96)
    listDemo2.removeAt(0)
    println(listDemo2)
    listDemo2.shuffle()
    println(listDemo2)
    println()

    //set
    val set1 = setOf(1, 2, 3, 3, 4, null, null)
    println("Set: $set1")
    println("Size: ${set1.size}")
    if (set1.contains(3)) println("3 is in the set")

    val setDemo2 = setOf(1, 2, 3, 4, null)
    println(set1 == setDemo2)
    println()

    //map
    val map1 = mapOf(1 to "one", 2 to "two", 3 to "three")
    println("Map: $map1")
    println("Map keys: ${map1.keys}")
    println("Map values: ${map1.values}")
    if (2 in map1) println("value of key 2 is : ${map1[2]}")
    if (map1.containsKey(3)) println("it has key ")
    if (map1.containsValue("one")) println("it has value")
    println(map1.entries)
    println()

    val numbersMap = mapOf("key1" to 1, "key2" to 2, "key3" to 3, "key4" to 1)
    val anotherMap = mapOf("key2" to 2, "key1" to 1, "key4" to 1, "key3" to 3)
    println("The maps are equal: ${numbersMap == anotherMap}")

    //mutableMap
    val mapDemo2 = mutableMapOf("one" to 1, "two" to 2)
    mapDemo2.put("four", 4)
    mapDemo2["three"] = 3
    println(mapDemo2)
    println()

    //list using builder function
    val listBuild1 = buildList {
        add("one")
        add("two")
    }
    println("BuildList: $listBuild1")

    //set using builder function
    val setBuild1 = buildSet {
        add(1)
        add(2)
    }
    println("SetBuild: $setBuild1")

    val mapBuild1 = buildMap {
        put(1, "one")
        put(2, "two")
    }
    println("MapBuild: $mapBuild1")
    println()

    //copy
    val copy1 = CollectionDemo("vidhi", 21)
    val copy2 = mutableListOf(copy1, CollectionDemo("patel", 56))
    val copyOf = copy2.toList()
    copy2.add(CollectionDemo("new", 67))
    println(copyOf)
    println(copy2)

    //list to set
    val listSet = mutableListOf(1, 2, 3)
    val copySet = listSet.toMutableSet()
    copySet.add(5)
    copySet.add(9)
    println(copySet)

    //new reference to same collection
    val list4 = mutableListOf(1, 6, 8)
    val newRef = list4
    newRef.add(90)
    println(list4.size)

    //function on collection
    val numbers = listOf(1, 9, 6, 8)
    val num = numbers.filter { it > 3 }
    println(num)

    //iterate collection using iterator method
    val number1 = listOf("Sunday", "Monday", "Tuesday")
    val iterate = number1.iterator()
    while (iterate.hasNext())
        println(iterate.next())

    //using for loop
    for (item in number1)
        println(item)

    //using forEach
    number1.forEach {
        println(it)
    }
    println()

    val maps = mapOf(1 to "one", 2 to "two")
    val iterator2 = maps.iterator()
    while (iterator2.hasNext())
        println(iterator2.next())
    for (item in maps.keys)
        println(item)
    maps.forEach {
        println(it)
    }
    println()

    //list forward and backwards
    val listIt = listOf(1, 2, 3, 4, 5)
    val iterator3 = listIt.listIterator()
    println("Forward Iteration: ")
    while (iterator3.hasNext())
        println("Index: ${iterator3.nextIndex()}, value: ${iterator3.next()}")

    println("Backward Iteration: ")
    while (iterator3.hasPrevious())
        println("Index: ${iterator3.previousIndex()}, value: ${iterator3.previous()}")
    println()

    //result stored in variable
    val finalList = listIt.filter { it > 1 }
    println(finalList)

    //mapping transformation
    val set2 = setOf(1, 2, 3)
    println(set2.map { it * 2 })
    println(set2.mapIndexed { index, value -> value * index })

    val map2 = mapOf(1 to "Red", 2 to "Blue", 3 to "white")
    println(map2.mapKeys { it.key + it.value.length })
    println(map2.mapValues { it.value.uppercase() })

    //zip- list of pairs
    val color = listOf("red", "brown", "grey")
    val animal = listOf("fox", "bear", "elephant")
    println(color zip animal)

    //zip with transformation function
    val zipOf =
        color.zip(animal) { colors, animals ->
            "The ${animals.replaceFirstChar { it.uppercase() }} is $colors"
        }
    println(zipOf)

    //unzip
    val numberPairs = listOf("one" to 1, "two" to 2, "three" to 3, "four" to 4)
    println(numberPairs.unzip())

    //associateWith
    val names = listOf("Vidhi", "Devarsh", "Krunal", "Krunal")
    println(names.associateWith { it.length })

    //flatten
    val flat = listOf(setOf(1, 2, 3), setOf(4, 5), setOf(6, 7, 8))
    println(flat.flatten())

    //joinToString and joinTo
    val join1 = listOf("one", "two", "three")
    println(join1)
    println(join1.joinToString())
    val newStr = StringBuffer("The numbers are: ")
    join1.joinTo(newStr)
    println(newStr)
    println()

    //filter
    val filter1 = listOf("one", "two", "three")
    val ans1 = filter1.filter { it.length > 3 }
    println(ans1)

    val filter2 = mapOf(1 to "one", 2 to "two", 3 to "three")
    val filterOf = filter2.filter { (key, value) -> key > 1 && value.endsWith("o") }
    println(filterOf)

    val filter3 = listOf("one", "two", "three", "four")
    val filterOf2 = filter3.filterIndexed { index, s -> (index != 0) && (s.length > 2) }
    val filterOf3 = filter3.filterNot { it.length <= 3 }
    println(filterOf2)
    println(filterOf3)

    val filter4 = listOf(null, "one", "two", null)
    filter4.filterNotNull().forEach {
        println(it.length)
    }

    //Partition
    val part1 = listOf("one", "two", "three", "four")
    val resPart = part1.partition { it.length > 3 }
    println(resPart)

    val l1 = listOf("one", "two", "three", "four")
    println(l1.any { it.endsWith("e") })
    println(l1.none { it.endsWith("a") })
    println(l1.all { it.endsWith("e") })

    //plus minus operator
    val l2 = listOf("one", "two", "three", "four")
    val plusList = l2 + "five"
    val minusList = l2 - listOf("three", "four")
    println(plusList)
    println(minusList)

    //Grouping
    val l3 = listOf("one", "two", "three", "four", "five", "six")
    println(l3.groupBy { it.first().uppercase() })
    println(l3.groupBy(keySelector = { it.first() }, valueTransform = { it.uppercase() }))
    println(l3.groupingBy { it.first() }.eachCount())
    println()

    //Slice
    println(l3.slice(1..3))
    println(l3.slice(0..4 step 2))
    println(l3.slice(setOf(3, 5, 0)))
    println()

    println(l3.take(3))
    println(l3.takeLast(5))
    println(l3.drop(1))
    println(l3.dropLast(5))
    println()

    println(l3.takeWhile { !it.startsWith('f') })
    println(l3.takeLastWhile { it != "three" })
    println(l3.dropWhile { it.length == 3 })
    println(l3.dropLastWhile { it.contains('i') })
    println()

    println(l3.chunked(3))
    val l4 = listOf(1, 2, 3, 4, 5)
    println(l4.chunked(2) { it.sum() })
    println()

    println(l4.windowed(3))
    println(l4.windowed(2, step = 2, partialWindows = true))
    println(l4.windowed(2) { it.sum() })

    println(l4.elementAt(3))
    println(l4.first())
    println(l4.last())

    println(l4.elementAtOrNull(5))
    println(l4.elementAtOrElse(5) { index -> "The value for index $index is undefined" })
    println(l4.firstOrNull { it > 2 })
    println(l4.find { it % 2 == 0 })
    println(l4.findLast { it % 2 == 0 })
    println()

    println(l4.random())
    println(l4.contains(3))
    println(0 in l4)
    println(0 !in l4)
    println(l4.containsAll(listOf(2, 4)))
    println(l4.containsAll(listOf(2, 0)))
    println()

    //Compare
    val comp = Comparator { str1: String, str2: String -> str1.length - str2.length }
    println(listOf("vid", "ad", "b").sortedWith(comp))
    println(listOf("vid", "ad", "b").sortedWith(compareBy { it.length }))
    println()

    //sorting
    val list1 = listOf("one", "two", "three", "four")
    println(list1.sorted())
    println(list1.sortedDescending())

    val sortOf = list1.sortedBy { it.length }
    val sortOf2 = list1.sortedByDescending { it.last() }
    println(sortOf)
    println(sortOf2)
    println(list1.reversed())

    val list2 = mutableListOf("one", "two", "three", "four")
    val reversedNumbers = list2.asReversed()
    println(reversedNumbers)
    list2.add("five")
    println(reversedNumbers)
    println()

    //Aggregate
    val list3 = listOf(6, 42, 10, 4)
    println("Count: ${list3.count()}")
    println("Max: ${list3.maxOrNull()}")
    println("Min: ${list3.minOrNull()}")
    println("Average: ${list3.average()}")
    println("Sum: ${list3.sum()}")
    println()

    //reduce and fold
    val newVar = list3.reduce { acc, i -> acc + i }
    val newVar2 = list3.fold(0) { sum, ele -> sum + ele }
    val newVar3 = list3.foldRight(0) { ele, sum -> ele + sum }
    println(newVar)
    println(newVar2)
    println(newVar3)

    //for intermediate result
    val runningReduceSum = list3.runningReduce { sum, item -> sum + item }
    val runningFoldSum = list3.runningFold(10) { sum, item -> sum + item }
    println(runningReduceSum)
    println(runningFoldSum)
    println()

    //binary search in list
    val list5 = mutableListOf(5, 3, 2, 1)
    list5.sort()
    println(list5)
    println(list5.binarySearch(3, 0, 2))
}