
enum class Type(name: String) {
    Equilateral("Equilateral"),
    Isosceles("Isosceles"),
    Scalene("Scalene"),
    Invalid("Invalid")
}

fun main() = with(System.`in`.bufferedReader()) {
    while (true) {
        val triangle = readLine().split(" ").map { it.toInt() }.sorted()
        val a = triangle[0]
        val b = triangle[1]
        val c = triangle[2]
        if (a == 0) break
        println(
            when {
                a + b <= c -> Type.Invalid.name
                a == b && b == c -> Type.Equilateral.name
                a != b && b != c -> Type.Scalene.name
                else-> Type.Isosceles.name
            }
        )
    }
}