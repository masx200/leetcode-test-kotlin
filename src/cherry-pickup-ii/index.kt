package com.github.masx200.leetcode_test_kotlin.cherry_pickup_ii

class Solution {
    fun getValue(grid: Array<IntArray>, i: Int, j1: Int, j2: Int): Int {
        return if (j1 != j2) grid[i][j1] + grid[i][j2] else grid[i][j1]
    }

    fun dfs(grid: Array<IntArray>, cache: HashMap<Triple<Int, Int, Int>, Int>, i: Int, j1: Int, j2: Int): Int {
        val m = grid.size
        val n = grid[0].size
        if (i == m - 1) return getValue(grid, i, j1, j2)

        var best = 0
        for (dj1 in listOf(j1 - 1, j1, j1 + 1).filter { it in 0..<n }) {
            for (dj2 in listOf(j2 - 1, j2, j2 + 1).filter { it in 0..<n }) {
                best = maxOf(best, dfsCache(grid,cache,i + 1, dj1, dj2))
            }
        }
        return best + getValue(grid, i, j1, j2)
    }

    fun dfsCache(grid: Array<IntArray>, cache: HashMap<Triple<Int, Int, Int>, Int>, x: Int, y: Int, q: Int): Int {
        val key = Triple(x, y, q)
        if (cache.containsKey(key)) return cache[key]!!

        val result = dfs(grid,cache, x, y, q)
        cache[key] = result
        return result
    }

    fun cherryPickup(grid: Array<IntArray>): Int {

        val cache = hashMapOf<Triple<Int, Int, Int>, Int>()

        val n = grid[0].size




        return dfsCache(grid, cache, 0, 0, n - 1)
    }


}