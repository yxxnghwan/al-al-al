package boj

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val N = br.readLine().toInt()
    val M = br.readLine().toInt()
    val st = StringTokenizer(br.readLine())
    val sources = mutableListOf<Int>()
    for (i in 0 until N) {
        sources.add(st.nextToken().toInt())
    }
    sources.sort()

    var a = 0
    var b = N - 1
    var count = 0
    while (a < b) {
        val num1 = sources[a]
        val num2 = sources[b]
        val sum = num1 + num2
        if (sum == M) {
            count++
            b--
        } else if(sum < M) {
            a++
        } else {
            b--
        }
    }

    println(count)
}
