package quicksort

import kotlin.random.Random

fun main() {
    val xs = mutableListOf(3, 1, 12, 4, 15, 2)
    quicksort(xs, 0, xs.size - 1)
    print(xs)
}

fun quicksort(xs: MutableList<Int>, p: Int, r: Int) {
    if (p < r) {
        val q = randomPartition(xs, p, r)
        quicksort(xs, p, q - 1)
        quicksort(xs, q + 1, r)
    }
}

fun partition(xs: MutableList<Int>, p: Int, r: Int): Int {
    val pivot = xs[r]
    var inxLess = p
    for (inxGreater in (p..(r - 1))) {
        if (xs[inxGreater] <= pivot) {
            xs[inxLess] = xs[inxGreater].also { xs[inxGreater] = xs[inxLess] }
            inxLess++
        }
    }
    xs[inxLess] = xs[r].also { xs[r] = xs[inxLess] }
    return inxLess
}

fun randomPartition(xs: MutableList<Int>, p: Int, r: Int):Int {
    val i = Random.nextInt(p,r)
    xs[i] = xs[r].also { xs[r] = xs[i] }
    return partition(xs, p, r)
}

