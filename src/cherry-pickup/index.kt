package com.github.masx200.leetcode_test_kotlin.cherry_pickup

import kotlin.Int.Companion.MIN_VALUE

class Solution {
    fun cherryPickup(grid: Array<IntArray>): Int {
        val n = grid.size
        val cache = hashMapOf<Triple<Int, Int, Int>, Int>()
        return Math.max(0, getCherryPickupNum(cache, grid, n - 1, n - 1, n - 1))
    }

    fun getCherryPickupNum(
        cache: HashMap<Triple<Int, Int, Int>, Int>,
        grid: Array<IntArray>,
        x: Int,
        y: Int,
        q: Int
    ): Int {
        val w = x + y - q
        if (w < 0 || x < 0 || y < 0 || q < 0) return MIN_VALUE

        val key = Triple(x, y, q)
        if (cache.containsKey(key)) return cache[key]!!
        val cur = grid[x][y]
        val acc =
            when {
                (x == 0 && y == 0) -> 0
                else -> maxOf(

                    if (x > 0 && grid[x - 1][y] == -1) MIN_VALUE else
                        getCherryPickupNum(cache, grid, x - 1, y, q),
                    if (y > 0 && grid[x][y - 1] == -1) MIN_VALUE else getCherryPickupNum(
                        cache,
                        grid,
                        x,
                        y - 1, q
                    ), getCherryPickupNum(
                        cache,
                        grid,
                        x - 1,
                        y, q - 1
                    ), getCherryPickupNum(
                        cache,
                        grid,
                        x,
                        y - 1, q - 1
                    )
                )


            }
        val result =
            if (-1 == grid[q][w]) MIN_VALUE else
                when (cur) {
                    -1 -> MIN_VALUE
                    else -> {

                        cur + acc
                    }

                } + if (x == q && y == w) 0 else grid[q][w]

        cache[key] = result
        return result
    }
}