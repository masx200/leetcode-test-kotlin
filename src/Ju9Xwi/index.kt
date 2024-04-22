package com.github.masx200.leetcode_test_kotlin.Ju9Xwi

import kotlin.math.ln
import kotlin.math.log2
import kotlin.math.pow

class Solution {
    fun leastMinutes(n: Int): Int {
        val rt = log2(n * ln(2.0)).toInt() // 注意转换为以2为底的对数，并且在计算前需要转为Double
        val p = (2.0).pow(rt).toInt()
        return rt + ((n + p - 1) / p)
    }
}