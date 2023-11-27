


fun main(args: Array<String>) {   val group = Group<Int>("Integers")
    println("TSP")
    val startingNode = 0
    val adjacentMatrix = arrayOf(
        intArrayOf(0, 4, 1, 9),
        intArrayOf(3, 0, 6, 11),
        intArrayOf(4, 1, 0, 2),
        intArrayOf(6, 5, -4, 0)
    )

    fun printMatrix(matrix: Array<IntArray>) {
        for (row in matrix) {
            println(row.joinToString(" "))
        }
    }

    fun allPermutations(arr: Array<Int>, l: Int, r: Int): ArrayList<Array<Int>> {
        val permutations = ArrayList<Array<Int>>()
        if (l == r) {
            permutations.add(arr.clone())
        } else {
            for (i in l..r) {
                arr.swap(l, i)
                permutations.addAll(allPermutations(arr, l + 1, r))
                arr.swap(l, i) // backtrack
            }
        }
        return permutations
    }

    fun allCombinations(arr: Array<Int>, index: Int, data: Array<Int>, i: Int, combinations: ArrayList<Array<Int>>) {
        if (index == data.size) {
            combinations.add(data.clone())
            return
        }
        if (i >= arr.size) return
        data[index] = arr[i]
        allCombinations(arr, index + 1, data, i + 1, combinations)
        allCombinations(arr, index, data, i + 1, combinations)
    }

    fun Array<Int>.swap(i: Int, j: Int) {
        val temp = this[i]
        this[i] = this[j]
        this[j] = temp
    }
    
    fun permutations(array:Array<Int>):Array<Array<Int>>{
        val size = array.size
        val theArray = Array(size){0}
        var iteration = 1
        var valueInOddPositionOrZero: Int
        var position: Int
        while (iteration < size) {
            if (theArray[iteration] < iteration) {
                valueInOddPositionOrZero = if (iteration % 2 == 0) 0 else theArray[iteration]
                position = array[iteration]
                array[iteration] = array[valueInOddPositionOrZero]
                array[valueInOddPositionOrZero] = position
                ++theArray[iteration]
                iteration = 1
                theArray[iteration] = 0
            } else {
                ++iteration
            }
        }
        return theArray
    }

    fun naiveSolution() {
        val nodes = arrayOf(0, 1, 2, 3)
        val permutations = permutations(nodes)
        println("Permutations: $permutations")

        var minDistance = Int.MAX_VALUE
        var bestPath = listOf<Int>()
        for (permutation in permutations) {
            var distance = 0
            var previousNode = startingNode
            for (node in permutation) {
                distance += adjacentMatrix[previousNode][node]
                previousNode = node
            }
            distance += adjacentMatrix[previousNode][startingNode]
            if (distance < minDistance) {
                minDistance = distance
                bestPath = permutation.toList()
            }
        }
        println("Best path: $bestPath")
        println("Distance: $minDistance")
    }
fun main(args: Array<String>) {
    val arr = arrayOf(1, 2, 3)
    val permutations = allPermutations(arr, 0, arr.size - 1)
    for (perm in permutations) {
        println(perm.joinToString(" "))
    }
}
}