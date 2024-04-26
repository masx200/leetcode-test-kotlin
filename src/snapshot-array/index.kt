package com.github.masx200.leetcode_test_kotlin.snapshot_array

class SnapshotArray(length: Int) {
    private var snapCnt = 0
    private val data: Array<MutableList<IntArray>> = Array(length) { mutableListOf() }

    fun set(index: Int, `val`: Int) {
        data[index].add(intArrayOf(snapCnt, `val`))
    }

    fun snap(): Int {
        return snapCnt++
    }

    fun get(index: Int, snapId: Int): Int {
        val x = binarySearch(index, snapId)
        return if (x == 0) 0 else data[index][x - 1][1]
    }

    private fun binarySearch(index: Int, snapId: Int): Int {
        var low = 0
        var high = data[index].size
        while (low < high) {
            val mid = low + (high - low) / 2
            val pair = data[index][mid]
            if (pair[0] > snapId + 1 || (pair[0] == snapId + 1 && pair[1] >= 0)) {
                high = mid
            } else {
                low = mid + 1
            }
        }
        return low
    }
}
