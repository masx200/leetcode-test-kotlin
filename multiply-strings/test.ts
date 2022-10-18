import { assertEquals } from "https://deno.land/std@0.160.0/testing/asserts.ts";

import multiply from "./index.ts";

Deno.test("multiply-strings", () => {
    assertEquals(
        [
            "6",
            "56088",

            "11999999999999599999999999970000000000001",
            "813827160493824652888888888888888857283950617284048",
        ],
        [
            ["2", "3"],
            ["123", "456"],
            ["29999999999999", "399999999999999999999999999"],
            ["17777777777777723", "45777777777777777777777777777777776"],
        ].map(([x, y]) => multiply(x, y)),
    );
});
