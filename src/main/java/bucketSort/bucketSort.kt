package bucketSort

import java.util.*


fun main() {
    val list = mutableListOf(0.11, 0.01, 0.03)
    bucketSort(list)
    println(list)
}

fun bucketSort(inp: MutableList<Double>) {
    val n = inp.size
    val buckets = mutableListOf<MutableList<Double>>()
    for (i in inp) {
        buckets.add(mutableListOf())
    }

    for (i in 0 until buckets.size) {
        val inx: Int = (inp[i] * n).toInt()
        buckets[inx].add(inp[i])
    }

    for (bucket in buckets) {
        bucket.sort()
    }

    var index = 0
    for (i in 0 until n) {
        for (j in 0 until buckets[i].size) {
            inp[index++] = buckets[i][j]
        }
    }
}