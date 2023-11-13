package boj

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val N = br.readLine().toInt()
    val st = StringTokenizer(br.readLine())

    var M = 0
    var sumScore = 0
    for (i in 1..N) {
        val score = st.nextToken().toInt()
        if (score > M) {
            M = score
        }
        sumScore += score
    }

    val newSumScore = sumScore.toDouble() / M * 100
    val newAverage = newSumScore / N
    println(newAverage)
}
