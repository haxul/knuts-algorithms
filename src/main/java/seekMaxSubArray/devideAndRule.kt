package seekMaxSubArray

import kotlin.random.Random

fun main() {
    val users = listOf(User("serg", 10, listOf("php", "js")), User("august", 21, listOf("java", "c#")))
    /* O(n^2)
    for (user in users) {
        for (skill in user.skills) {
            println(skill.toUpperCase())
        }
    }
     */
    // O (n * lg n)
    val mapSkill = upperCaseSkills(users)

    val workers = List(1000000) { 1 }.map {
        val jobs = List(100) {1}
        Worker(it, jobs)
    }

    val start = System.nanoTime()
//    var sum = 0
//    for (worker in workers) {
//        for (job in worker.jobs) {
//            sum += job
//        }
//    }
    val sum = summm(workers, 0 , workers.size - 1)
    println(sum)
    println((System.nanoTime() - start) / 1000)
}

fun summm(list:List<Worker>, low: Int, high:Int): Int {
    if (low == high) return list[0].jobs.sum()
    val mid = (low + high) / 2
    val l = summm(list, low, mid)
    val r = summm(list, mid + 1, high)
    return l + r
}
fun upperCaseSkills(users: List<User>): List<String> {
    if (users.size == 1) return users[0].skills // get what we need to process
    // dividing
    val mid = users.size / 2
    val lUsers = users.subList(0, mid)
    val rUsers = users.subList(mid, users.size)
    val skillsLeft = upperCaseSkills(lUsers)
    val skillsRight = upperCaseSkills(rUsers)
    // processing
    return skillsLeft.map { it.toUpperCase() } + skillsRight.map { it.toUpperCase() }
}

class User(private val name: String, private val age: Int, val skills: List<String>) {
    fun greet() {
        println("name is $name, age is $age")
    }
}

class Worker(val id:Int, val jobs:List<Int>)



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

