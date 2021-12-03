fun main() {
    fun part1(input: List<String>): Int {
        val forwards = input.filter { it.split(" ")[0] == "forward" }.sumOf { it.split(" ")[1].toInt() }
        val ups = input.filter { it.split(" ")[0] == "up" }.sumOf { it.split(" ")[1].toInt() }
        val downs = input.filter { it.split(" ")[0] == "down" }.sumOf { it.split(" ")[1].toInt() }
        return forwards * (downs - ups)
    }

    var aim = 0
    var forwards = 0
    var depths = 0

    fun part2(input: List<String>): Int {
        input.forEach {
            when(it.split(" ")[0]) {
                "down" -> aim += it.split(" ")[1].toInt()
                "up" -> aim -= it.split(" ")[1].toInt()
                "forward" -> {
                    depths += aim * it.split(" ")[1].toInt()
                    forwards += it.split(" ")[1].toInt()
                }
            }
        }
        return forwards * depths
    }

    // test if implementation meets criteria from the description, like:
    //val testInput = readInput("Day01_test")
    //check(part1(testInput) == 1)

    val input = readInput("Day02")
    println(part1(input))
    println(part2(input))
}
