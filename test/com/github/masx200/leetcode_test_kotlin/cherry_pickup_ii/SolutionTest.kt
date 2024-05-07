package com.github.masx200.leetcode_test_kotlin.cherry_pickup_ii

import com.alibaba.fastjson2.JSON
import com.alibaba.fastjson2.JSONArray
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SolutionTest {

    @Test
    fun cherryPickup() {

        val grid = arrayOf(
            intArrayOf(0, 1, 0, 0, 0),
            intArrayOf(0, 0, 0, 2, 0),
            intArrayOf(3, 0, 1, 0, 0),
            intArrayOf(0, 2, 0, 0, 4),
            intArrayOf(0, 0, 0, 0, 0)
        )
        val solution = Solution()
        assertEquals(11, solution.cherryPickup(grid))
    }

    @Test
    fun cherryPickup2() {

        val grid = jsonArraytoArrayIntArray(
            JSON.parseArray("""[[1,0,0,0,0,0,1],[2,0,0,0,0,3,0],[2,0,9,0,0,0,0],[0,3,0,5,4,0,0],[1,0,2,3,0,0,6]]""")
        )
        val solution = Solution()
        assertEquals(28, solution.cherryPickup(grid))
    }

    fun jsonArraytoArrayIntArray(values: JSONArray): Array<IntArray> {
        val result = Array<IntArray>(values.size, { IntArray(0) })
        for (i in 0 until values.size) {
            val value = values.getJSONArray(i)
            val intArray = IntArray(value.size)
            for (j in 0 until value.size) {
                intArray[j] = value.getIntValue(j)
            }
            result[i] = (intArray)
        }
        return result
    }

}