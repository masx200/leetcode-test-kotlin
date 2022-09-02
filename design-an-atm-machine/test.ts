import { assertEquals } from "https://deno.land/std@0.154.0/testing/asserts.ts";
import { runScript } from "leetcode-class";

import ATM from "./index.ts";

Deno.test("design-an-atm-machine", () => {
    assertEquals(
        runScript(
            ["ATM", "deposit", "withdraw", "deposit", "withdraw", "withdraw"],
            [[], [[0, 0, 1, 2, 1]], [600], [[0, 1, 0, 1, 1]], [600], [550]],
            [ATM],
        ),
        [null, null, [0, 0, 1, 0, 1], null, [-1], [0, 1, 0, 0, 1]],
    );
});
Deno.test("design-an-atm-machine", () => {
    assertEquals(
        runScript(
            [
                "ATM",
                "withdraw",
                "withdraw",
                "withdraw",
                "deposit",
                "withdraw",
                "deposit",
                "deposit",
                "deposit",
                "withdraw",
                "deposit",
                "deposit",
                "withdraw",
                "withdraw",
                "withdraw",
                "deposit",
                "withdraw",
                "withdraw",
                "deposit",
                "deposit",
                "withdraw",
                "deposit",
                "deposit",
                "withdraw",
                "deposit",
                "deposit",
                "deposit",
                "deposit",
                "deposit",
                "withdraw",
                "deposit",
                "deposit",
                "deposit",
                "withdraw",
                "withdraw",
                "withdraw",
                "withdraw",
                "withdraw",
                "withdraw",
                "withdraw",
                "deposit",
                "withdraw",
                "withdraw",
                "deposit",
                "withdraw",
                "deposit",
                "withdraw",
            ],
            [
                [],
                [761034295],
                [61525080],
                [174864345],
                [[358452, 666752, 106470, 349678, 54308]],
                [731538350],
                [[601825, 660860, 292958, 970473, 8734]],
                [[158352, 230840, 584830, 930578, 694508]],
                [[514076, 440930, 651443, 278260, 979506]],
                [497058270],
                [[133310, 708326, 899189, 33920, 347912]],
                [[303868, 383014, 987573, 463436, 12026]],
                [869223735],
                [181792350],
                [637002590],
                [[339075, 907619, 147999, 936557, 1981]],
                [752216315],
                [545310305],
                [[770860, 358659, 85899, 508223, 601813]],
                [[340254, 62912, 736965, 66084, 563153]],
                [860609765],
                [[472577, 898761, 759021, 711213, 991384]],
                [[352863, 993443, 470695, 771751, 885351]],
                [203746940],
                [[120462, 370974, 430415, 813965, 537750]],
                [[940761, 792840, 383659, 776650, 458842]],
                [[717775, 420637, 567990, 605599, 95258]],
                [[648203, 738843, 132683, 590799, 727288]],
                [[654744, 93342, 333659, 797144, 333668]],
                [789833560],
                [[608199, 496156, 841207, 700929, 455615]],
                [[196749, 158976, 15983, 957167, 277532]],
                [[136263, 500576, 687867, 846013, 779525]],
                [951029660],
                [470859140],
                [771294700],
                [390723140],
                [509143745],
                [815366855],
                [425443600],
                [[777238, 246202, 877954, 517113, 522097]],
                [75391260],
                [793642205],
                [[122930, 48921, 163827, 811227, 901960]],
                [856433570],
                [[842662, 59261, 38287, 570862, 937593]],
                [558135620],
            ],
            [ATM],
        ),
        [
            null,
            [-1],
            [-1],
            [-1],
            null,
            [-1],
            null,
            null,
            null,
            [1, 1, 0, 1, 994116],
            null,
            null,
            [-1],
            [0, 1, 1, 1, 363584],
            [2, 1, 1, 1336777, 739294],
            null,
            [-1],
            [-1],
            null,
            null,
            [-1],
            null,
            null,
            [2, 0, 0, 2, 407493],
            null,
            null,
            null,
            null,
            null,
            [-1],
            null,
            null,
            null,
            [-1],
            [2, 0, 1, 0, 941718],
            [0, 0, 0, 1, 1542589],
            [2, 0, 1, 0, 781446],
            [-1],
            [-1],
            [0, 0, 1, 0, 850887],
            null,
            [-1],
            [-1],
            null,
            [1, 1, 0, 0, 1712867],
            null,
            [1, 0, 1, 0, 1116271],
        ],
    );
});
