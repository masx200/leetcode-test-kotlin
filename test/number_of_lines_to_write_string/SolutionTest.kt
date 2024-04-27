package com.github.masx200.leetcode_test_kotlin.number_of_lines_to_write_string


import org.junit.jupiter.api.Test
import kotlin.test.assertContentEquals

class SolutionTest {

    @Test
    fun numberOfLines() {
        val solution = Solution()
        val test5 = intArrayOf(
            10,
            10,
            10,
            10,
            10,
            10,
            10,
            10,
            10,
            10,
            10,
            10,
            10,
            10,
            10,
            10,
            10,
            10,
            10,
            10,
            10,
            10,
            10,
            10,
            10,
            10
        )
        assertContentEquals(intArrayOf(3, 60), solution.numberOfLines(test5, "abcdefghijklmnopqrstuvwxyz"))
    }

    @Test
    fun numberOfLines2() {
        val solution = Solution()
        val test5 = intArrayOf(
            4, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10
        )
        assertContentEquals(intArrayOf(2, 4), solution.numberOfLines(test5, "bbbcccdddaaa"))
    }


    //    class SolutionTest {
    @Test
    fun testNumberOfLines() {
        val solution = Solution()

        val test1 = intArrayOf(
            4,
            10,
            10,
            10,
            10,
            10,
            10,
            10,
            10,
            10,
            10,
            10,
            10,
            10,
            10,
            10,
            10,
            10,
            10,
            10,
            10,
            10,
            10,
            10,
            10,
            10,
            10,
            10
        )
        assertContentEquals(intArrayOf(1, 100), solution.numberOfLines(test1, "HelloWorld".lowercase()))

        val test2 = intArrayOf(
            4,
            10,
            10,
            10,
            10,
            10,
            10,
            10,
            10,
            10,
            10,
            10,
            10,
            10,
            10,
            10,
            10,
            10,
            10,
            10,
            10,
            10,
            10,
            10,
            10,
            10,
            10,
            10
        )
        assertContentEquals(intArrayOf(1, 50), solution.numberOfLines(test2, "Hello".lowercase()))

        val test3 = intArrayOf(
            4,
            10,
            10,
            10,
            10,
            10,
            10,
            10,
            10,
            10,
            10,
            10,
            10,
            10,
            10,
            10,
            10,
            10,
            10,
            10,
            10,
            10,
            10,
            10,
            10,
            10,
            10,
            10
        )
        assertContentEquals(intArrayOf(2, 60), solution.numberOfLines(test3, "WWWWWWWWWWWWWWWW".lowercase()))

        val test4 =
            intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26)
        assertContentEquals(intArrayOf(1, 100), solution.numberOfLines(test4, "a".repeat(100)))

        val test5 = intArrayOf(7, 6, 5, 4, 3, 2, 1)
        assertContentEquals(intArrayOf(1, 25), solution.numberOfLines(test5, "abcde"))
    }
//    }

}