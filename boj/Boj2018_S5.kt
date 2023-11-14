package boj

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val N = br.readLine().toInt()

    var i = 0
    var j = 1
    var madeNCount = 0
    var sum = 1 // 초기 합은 1부터 시작

    while (i < N && j <= N) {
        if (sum == N) {
            madeNCount++
            j++
            sum += j
        } else if (sum < N) {
            j++
            sum += j
        } else {
            i++
            sum -= i
        }
    }

    println(madeNCount)
}
