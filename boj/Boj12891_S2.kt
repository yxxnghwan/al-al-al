package boj

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var st = StringTokenizer(br.readLine())
    val S = st.nextToken().toInt()
    val P = st.nextToken().toInt()
    val dnaString = br.readLine()
    st = StringTokenizer(br.readLine())
    val minACount = st.nextToken().toInt()
    val minCCount = st.nextToken().toInt()
    val minGCount = st.nextToken().toInt()
    val minTCount = st.nextToken().toInt()

    val countMap = mutableMapOf(Pair("A", 0), Pair("C", 0), Pair("G", 0), Pair("T", 0))

    for (i in 0 until P) {
        val key = dnaString[i].toString()
        countMap[key] = countMap[key]!!.plus(1)
    }

    var makeCount = 0
    if (checkPassword(minACount, minCCount, minGCount, minTCount, countMap)) {
        makeCount += 1
    }

    for (i in 0 until S - P) {
        val old = dnaString[i].toString()
        val new = dnaString[i + P].toString()

        countMap[old] = countMap[old]!!.minus(1)
        countMap[new] = countMap[new]!!.plus(1)

        if (checkPassword(minACount, minCCount, minGCount, minTCount, countMap)) {
            makeCount += 1
        }
    }

    println(makeCount)
}

fun checkPassword(
    minACount: Int,
    minCCount: Int,
    minGCount: Int,
    minTCount: Int,
    countMap: MutableMap<String, Int>
): Boolean {
    val nowACount = countMap["A"]
    val nowCCount = countMap["C"]
    val nowGCount = countMap["G"]
    val nowTCount = countMap["T"]

    if (nowACount!! < minACount) {
        return false
    }
    if (nowCCount!! < minCCount) {
        return false
    }
    if (nowGCount!! < minGCount) {
        return false
    }
    if (nowTCount!! < minTCount) {
        return false
    }

    return true
}
