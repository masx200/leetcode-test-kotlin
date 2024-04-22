package com.github.masx200.leetcode_test_kotlin.shuffle_an_array

import kotlin.random.Random

class Solution(private val nums: IntArray) {

    fun reset(): IntArray {
        return nums
    }

    fun shuffle(): IntArray {
        val nums4 = nums.toMutableList()
        for (i in 0 until (nums4.size - 1)) {


            val index = i + Random.nextInt(nums4.size - i)
            val temp = nums4[i]
            nums4[i] = nums4[index]
            nums4[index] = temp

        }

        return nums4.toIntArray()
    }

}

