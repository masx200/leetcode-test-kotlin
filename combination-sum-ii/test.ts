import { assertEquals } from "asserts";

import combinationSum from "./index.ts";

Deno.test("combination-sum-ii", function () {
    const inputs: Array<Parameters<typeof combinationSum>> = [
        [[10, 1, 2, 7, 6, 1, 5], 8],
        [[2, 5, 2, 1, 2], 5],
        [
            [
                1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
                1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
                1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
                1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
                1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
            ],
            30,
        ],
    ];
    const outputs = [
        [
            [1, 1, 6],
            [1, 2, 5],
            [1, 7],
            [2, 6],
        ],
        [[1, 2, 2], [5]],
        [
            [
                1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
                1, 1, 1, 1, 1, 1, 1, 1, 1,
            ],
        ],
    ];
    assertEquals(
        inputs.map(([c, t]) => combinationSum(c, t)),
        outputs
    );
});
