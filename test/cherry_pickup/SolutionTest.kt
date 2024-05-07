package com.github.masx200.leetcode_test_kotlin.cherry_pickup

import com.alibaba.fastjson2.JSON
import com.github.masx200.leetcode_test_kotlin.cherry_pickup_ii.jsonArraytoArrayIntArray
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SolutionTest {
    @Test
    fun cherryPickup2() {
        val grid = jsonArraytoArrayIntArray(
            JSON.parseArray("""[[0,1,-1],[1,0,-1],[1,1,1]]""")
        )
        val solution = Solution()
        assertEquals(5, solution.cherryPickup(grid))

    }

    @Test
    fun cherryPickup() {
        val grid = arrayOf(
            intArrayOf(0, -1, 0, 0),
            intArrayOf(0, 1, 0, -1),
            intArrayOf(-1, 0, 1, 0),
            intArrayOf(0, 0, 0, 0)
        )
        val solution = Solution()
        assertEquals(2, solution.cherryPickup(grid))

        val grid2 = arrayOf(
            intArrayOf(0, -1, 0, 0),
            intArrayOf(0, 1, 0, -1),
            intArrayOf(-1, 0, 1, 0),
            intArrayOf(0, 0, 0, 0)
        )
        val solution2 = Solution()
        assertEquals(2, solution2.cherryPickup(grid2))
    }
}