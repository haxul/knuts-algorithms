package dynamicProgramming

import kotlin.math.max

fun main() {
    val table = mapOf(
        1 to 1, 2 to 5, 3 to 8,
        4 to 9, 5 to 10, 6 to 17,
        7 to 17, 8 to 20, 9 to 24, 10 to 30
    )

    val memo = mutableMapOf<Int,Int>()

    val cutRod = cutRod(table, 2, memo)
    print(cutRod)
}

fun cutRod(p: Map<Int, Int>, n: Int, memo:MutableMap<Int,Int>): Int {
    if (n == 0) return 0
    if (memo[n] != null) return memo[n] as Int;
    var q = 0;
    for (i in 1..n) {
        val tmp =  (p[i] as Int) + cutRod(p, n - i, memo)
        val max = max(q, tmp)
        q = max
    }
    memo[n] = q
    return q;
}