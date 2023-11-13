package boj

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    var st = StringTokenizer(br.readLine())
    val N = st.nextToken().toInt()
    val M = st.nextToken().toInt()
    val numbers = br.readLine()
        .split(" ")
        .map { it.toInt() }
    val sums = MutableList(N) { 0 }
    sums[0] = numbers[0]
    for (i in 1 until N) {
        sums[i] = sums[i - 1] + numbers[i]
    }

    val answers = mutableListOf<Int>()
    for (k in 1..M) {
        st = StringTokenizer(br.readLine())
        val i = st.nextToken().toInt()
        val j = st.nextToken().toInt()
        if (i == 1) {
            answers.add(sums[j - 1])
        } else {
            answers.add(sums[j - 1] - sums[i - 2])
        }
    }

    for (answer in answers) {
        println(answer)
    }
}
