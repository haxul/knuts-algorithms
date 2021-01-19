package dynamicProgramming

import kotlin.math.max

fun main() {
    val table = mapOf(
        1 to 1, 2 to 5, 3 to 8,
        4 to 9, 5 to 10, 6 to 17,
        7 to 17, 8 to 20, 9 to 24, 10 to 30
    )
    val cutRod = cutRod(table, 5)
    print(cutRod)
}

fun cutRod(p: Map<Int, Int>, n: Int): Int {
    if (n == 0) return 0
    var q = 0;
    for (i in 1..n) {
        q = max(q, (p[i] as Int) + cutRod(p, n - i))
    }

    return q;
}