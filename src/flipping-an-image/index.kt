package com.github.masx200.leetcode_test_kotlin.flipping_an_image
class Solution {
    fun flipAndInvertImage(image: Array<IntArray>): Array<IntArray> {
        val A=image
        for(i in 0 until A.size){
            for(j in 0 until (A[i].size+1)/2){
                if(A[i][j]==A[i][A[i].size-j-1]){
                    A[i][j]=A[i][j] xor 1
                    A[i][A[i].size-j-1]=A[i][j]
                }
            }
        }
        return A

    }
}