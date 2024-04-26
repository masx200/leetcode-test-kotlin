package com.github.masx200.leetcode_test_kotlin.find_the_width_of_columns_of_a_grid

class Solution {
    fun findColumnWidth(grid: Array<IntArray>): IntArray {
        return grid.transpose().map {
            it.maxBy {
                it.toString().length
            }.toString().length
        }.toIntArray()
    }
}

fun Array<IntArray>.transpose(): Array<Array<Int>> {
    if (this.isEmpty() || this[0].isEmpty()) {
        return emptyArray()
    }

    val newArray = Array(this[0].size) { Array(this.size) { this[0][0] } }

    for (i in this.indices) {
        for (j in this[i].indices) {
            newArray[j][i] = this[i][j]
        }
    }

    return newArray
}
