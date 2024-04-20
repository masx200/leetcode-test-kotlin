package  com.github.masx200.leetcode_test_kotlin.number_of_lines_to_write_string

class Solution {
    fun numberOfLines(widths: IntArray, s: String): IntArray {
        var lines = 1
        val widthmax = 100
        var lineWidth = 0
        for (c in s) {
            val w = widths[c - 'a']
            if (lineWidth + w > widthmax) {
                lines++
                lineWidth = w
            } else {
                lineWidth += w
            }
        }
        val result = IntArray(2)
        result[0] = lines
        result[1] = lineWidth
        return result
    }
}