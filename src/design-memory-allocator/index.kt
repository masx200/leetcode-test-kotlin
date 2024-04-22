package com.github.masx200.leetcode_test_kotlin.design_memory_allocator
import java.util.TreeSet

class Allocator(n: Int) {
    private val treeSet: TreeSet<IntArray> = TreeSet { a, b ->
        if (a[0] != b[0]) a[0] - b[0] else a[2] - b[2]
    }

    init {
        // 添加首尾两个虚拟节点
        treeSet.add(intArrayOf(0, 0, -1))
        treeSet.add(intArrayOf(n, 0, 1001))
    }

    fun allocate(size: Int, mID: Int): Int {
        var first: IntArray? = null
        var second: IntArray? = null
        var flag = 0
        for (node in treeSet) {
            first = second
            second = node
            if (first != null) {
                if (second[0] - (first[0] + first[1]) >= size) {
                    treeSet.add(intArrayOf(first[0] + first[1], size, mID))
                    flag = 1
                    break
                }
            }
        }
        if (flag == 0) return -1
        return first!![0] + first[1]
    }

    fun free(mID: Int): Int {
        var count = 0
        val nodeList = mutableListOf<IntArray>()
        for (node in treeSet) {
            if (node[2] == mID) {
                count += node[1]
                nodeList.add(node)
            }
        }
        for (node in nodeList) {
            treeSet.remove(node)
        }
        return count
    }
}