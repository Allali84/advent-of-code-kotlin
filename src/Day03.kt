import java.util.stream.IntStream

fun main() {
    fun part1(input: List<String>): Int {

        var gamma = ""
        var epsilon = ""
        val countersList = mutableListOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
        val size = input.size / 2

        input.forEach { number ->
            number.forEachIndexed { i, it ->
                if (it == '1') {
                    countersList[i]++
                }
            }
        }

        countersList.forEach{
            if (it < size) {
                gamma += "0"
                epsilon += "1"
            } else {
                gamma += "1"
                epsilon += "0"
            }
        }

        return Integer.parseInt(gamma, 2) * Integer.parseInt(epsilon, 2)
    }

    fun evaluate(list1: List<String>, list2: List<String>, forOxygen: Boolean):Boolean {
        return if (forOxygen) list1.size > list2.size else list1.size < list2.size
    }

    fun recursive(input: List<String>, index: Int, forOxygen: Boolean = true ): List<String> {
        val list1 = input.toMutableList()
        if (list1.size == 2) {
            if (forOxygen) {
                if (list1[0][index] == '1') {
                    list1.removeAt(1)
                } else {
                    list1.removeAt(0)
                }
            } else {
                if (list1[0][index] == '0') {
                    list1.removeAt(1)
                } else {
                    list1.removeAt(0)
                }
            }
            return list1
        }
        val list2 = input.toMutableList()
        input.forEach { number ->
            if (number[index] == '1') {
                list1.remove(number)
            } else {
                list2.remove(number)
            }
        }
        return if (evaluate(list1, list2, forOxygen)) recursive(list1, index + 1, forOxygen) else recursive(list2, index + 1, forOxygen)
    }

    fun part2(input: List<String>): Int {
        val oxygen = Integer.parseInt(recursive(input, 0)[0], 2)
        val co2 = Integer.parseInt(recursive(input, 0, false)[0], 2)
        return oxygen * co2
    }

    // test if implementation meets criteria from the description, like:
    //val testInput = readInput("Day01_test")
    //check(part1(testInput) == 1)

    val input = readInput("Day03")
    println(part1(input))
    println(part2(input))
}
