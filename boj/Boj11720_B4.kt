package boj

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val N = br.readLine().toInt()

    val numbers = br.readLine()
        .toCharArray()
        .map { it - '0' }
    println(numbers.sum())
}
