fun main() {

    fun part1(input: List<String>): Int {
        var count = 0
        var index = 0
        val length = input.size
        for (value in input) {
            if (index == length - 1) {
                break
            }
            if (input[index].toInt() < input[index + 1].toInt()) count++
            index++
        }
        return count
    }

    fun part2(input: List<String>): Int {
        var index = 0
        val length = input.size
        val inputWithSums = mutableListOf<String>()
        for (value in input) {
            if (index == length - 2) {
                break
            }
            val sum = input[index].toInt() + input[index + 1].toInt() + input[index + 2].toInt()
            inputWithSums.add(sum.toString())
            index++
        }
        return part1(inputWithSums)
    }

    val input = readInput("Day01")
    println(part1(input))
    println(part2(input))
}
