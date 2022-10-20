import { assertEquals } from "https://deno.land/std@0.160.0/testing/asserts.ts";
import maxValue from "./index.ts";
import { TreeNodeLeetCodeFromJSON } from "../utils/TreeNodeLeetCodeParse.ts";
Deno.test("er-cha-shu-ran-se-UGC", () => {
    assertEquals(12, maxValue(TreeNodeLeetCodeFromJSON([5, 2, 3, 4]), 2));
    assertEquals(
        16,
        maxValue(TreeNodeLeetCodeFromJSON([4, 1, 3, 9, null, null, 2]), 2),
    );
});