fun main() {
    val yearString = readln()
    val year = yearString.toInt()
    val answer = when (year % 4) {
        0 -> if (year % 100 == 0 && year % 400 == 0) 1 else if (year % 100 == 0) 0 else 1
        else -> 0
    }
    print(answer)
}