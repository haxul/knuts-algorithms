package seekMaxSubArray

fun main() {
    val nums = listOf(13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7)
    val maxSubArray = findMaxSubArray(nums, 0, nums.size - 1)
    print(maxSubArray)
}

/** start  */
fun findMaxSubArray(list: List<Int>, low: Int, high: Int): Triple<Int, Int, Int> {
    if (high == low) return Triple(low, high, list[low])
    val mid = (low + high) / 2
    val (leftLow, leftHigh, leftSum) = findMaxSubArray(list, low, mid)
    val (rightLow, rightHigh, rightSum) = findMaxSubArray(list, mid + 1, high)
    val (crossLow, crossHigh, crossSum) = findMaxCrossingSubArray(list, low, mid, high)
    if ((leftSum > rightSum) and (leftSum > crossSum)) return Triple(leftLow, leftHigh, leftSum)
    if ((rightSum > leftSum) and (rightSum > crossSum)) return Triple(rightLow, rightHigh, rightSum)
    return Triple(crossLow, crossHigh, crossSum)
}

fun findMaxCrossingSubArray(list: List<Int>, low: Int, mid: Int, high: Int): Triple<Int, Int, Int> {
    var (leftSum, maxLeft) = Pair(0, 0)
    var sum = 0
    for (i in mid downTo low) {
        sum += list[i]
        if (sum >= leftSum) {
            leftSum = sum
            maxLeft = i
        }
    }
    var rightSum = 0
    sum = 0
    var maxRight = 0
    for (y in (mid + 1)..high) {
        sum += list[y]
        if (sum > rightSum) {
            rightSum = sum
            maxRight = y
        }
    }
    return Triple(maxLeft, maxRight, leftSum + rightSum)
}

/** end */

fun sumIfMore50(list: List<Int>): Int {
    if (list.size == 1) return if (list[0] < 10) list[0] else 0
    val mid = list.size / 2
    val leftSum = sumIfMore50(list.subList(0, mid))
    val rightSum = sumIfMore50(list.subList(mid, list.size))
    return leftSum + rightSum
}

fun findMinValue(list: List<Int>): Int {
    if (list.size == 1) return list[0]
    val mid = list.size / 2
    val minLeft = findMinValue(list.subList(0, mid))
    val minRight = findMinValue(list.subList(mid, list.size))
    return if (minLeft < minRight) minLeft else minRight
}

fun sumArray(nums: List<Int>): Int {
    if (nums.size == 1) return nums[0]
    val mid = nums.size / 2
    val sumLeft = sumArray(nums.subList(0, mid))
    val sumRight = sumArray(nums.subList(mid, nums.size))
    return sumLeft + sumRight
}

