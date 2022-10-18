import bstFromPreorder from "./index.ts";
import { assertEquals } from "https://deno.land/std@0.160.0/testing/asserts.ts";
import { TreeNodeLeetCodeFromJSON } from "../utils/TreeNodeLeetCodeParse.ts";
import { TreeNodeLeetCodeToJSON } from "../utils/TreeNodeLeetCodeStringify.ts";

Deno.test("construct-binary-search-tree-from-preorder-traversal", () => {
    assertEquals(
        [
            [8, 5, 1, 7, 10, 12],
            [1, 3],
        ].map(bstFromPreorder),
        [
            [8, 5, 10, 1, 7, null, 12],
            [1, null, 3],
        ].map(TreeNodeLeetCodeFromJSON),
    );
    assertEquals(
        [
            [8, 5, 1, 7, 10, 12],
            [1, 3],
        ]
            .map(bstFromPreorder)
            .map(TreeNodeLeetCodeToJSON),
        [
            [8, 5, 10, 1, 7, null, 12],
            [1, null, 3],
        ],
    );
});
