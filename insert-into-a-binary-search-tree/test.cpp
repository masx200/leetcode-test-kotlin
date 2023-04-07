// +build ignore

#include "TreeNode.hpp"
#include "freeTreeNode.hpp"
#include "index.hpp"
#include "serializeTreeNode.hpp"
#include <iostream>
#include <stdio.h>

// #include <set>
#include <cppunit/TestResult.h>
#include <cppunit/TestResultCollector.h>
#include <cppunit/TestRunner.h>
#include <cppunit/TextOutputter.h>
#include <cppunit/extensions/HelperMacros.h>

#include <sstream>
#include <unordered_set>
using namespace std;
#include "EqualTreeNode.hpp"
#include "HashTreeNode.hpp"
// #include "bfsTravelsal.hpp"
#include "debugTreeNode.hpp"
#include "printTreeNode.hpp"
#include "treeparse.hpp"
#include "LeetCodeTreeNodeToString.hpp"

void println(string s) { cout << s << endl; }

void assertEquals(string s1, string s2) {
  CPPUNIT_ASSERT_EQUAL(s1, s2);
  // if (s1 != s2)
  // {
  //     throw(("assertion error: " + s1 + " != " + s2));
  // }
}

void test1() {
  println("test1 start");
  TreeNode *none = NULL;

  auto result2 = Solution().insertIntoBST(none, 111);

  println(serializeTreeNode(none));
  assertEquals(serializeTreeNode(none), "null");
  println(serializeTreeNode(result2));
  assertEquals(serializeTreeNode(result2),
               "TreeNode{val:111,left:null,right:null}");

  auto nodes =
      unordered_set<TreeNode *, HashTreeNode, EqualTreeNode>{none, result2};
  for (auto node : nodes) {
    printTreeNode(node);
    freeTreeNode(node);
  }
  println("test1 end");
}

void test2() {
  println("test2 start");
  auto tree = new TreeNode(99);
  println(serializeTreeNode(tree));
  assertEquals(serializeTreeNode(tree),
               "TreeNode{val:99,left:null,right:null}");
  auto result = Solution().insertIntoBST(tree, 111);

  println(serializeTreeNode(result));
  assertEquals(serializeTreeNode(result),
               "TreeNode{val:99,left:null,right:TreeNode{val:111,left:null,"
               "right:null}}");

  auto nodes =
      unordered_set<TreeNode *, HashTreeNode, EqualTreeNode>{tree, result};
  for (auto node : nodes) {
    printTreeNode(node);
    freeTreeNode(node);
  }
  println("test2 end");
}

class StringTest : public CppUnit::TestFixture {
  CPPUNIT_TEST_SUITE(StringTest);
  CPPUNIT_TEST(testSwap);
  CPPUNIT_TEST(testFind);

  CPPUNIT_TEST(test3);
  CPPUNIT_TEST_SUITE_END();

public:
  void setUp() {}

  void tearDown() {}

  void testSwap() { test1(); }

  void testFind() { test2(); }

  void test3() {
    println("test3 start");
    auto rawString = string("[4,2,7,1,3]");
    auto val = 5;
    TreeNode *root = nullptr;
    int status = parseLeetCodeBinaryTree(rawString, &root);
    CPPUNIT_ASSERT_EQUAL(0, status);

    printTreeNode(root);
    std::string result = LeetCodeTreeNodeToString(root);

    println(result);
    cleanTreeNode(root);
    println("test3 end");
  }
};

CPPUNIT_TEST_SUITE_REGISTRATION(StringTest);

int main(int argc, char *argv[]) {
  CppUnit::TestResult r;
  CppUnit::TestResultCollector rc;
  r.addListener(&rc);

  CppUnit::TestRunner runner;
  runner.addTest(CppUnit::TestFactoryRegistry::getRegistry().makeTest());
  runner.run(r);

  CppUnit::TextOutputter o(&rc, std::cout);
  o.write();

  return rc.wasSuccessful() ? 0 : -1;
}