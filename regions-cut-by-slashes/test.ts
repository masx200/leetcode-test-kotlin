import { assertEquals } from "https://deno.land/std@0.158.0/testing/asserts.ts";
import regionsBySlashes from "./index.ts";
Deno.test("regions-cut-by-slashes", () => {
    assertEquals(
        [
            [
                " // /\\/  /\\ \\ /\\\\  \\  / /  \\/\\",
                "/\\ ///\\/\\///  \\//\\    \\ /\\\\  \\",
                "\\ / /   /\\/\\\\\\   \\//  /\\\\/\\/\\ ",
                "///  // /\\\\\\\\/ ///\\/\\/   /\\  /",
                "/\\//\\\\// /  /\\/  \\//\\/\\\\ \\//  ",
                "/\\  /////\\\\     /\\//\\/\\\\  /\\ /",
                "/   \\\\ \\\\/\\//\\/\\/   //////\\ \\/",
                "\\\\/\\ \\//\\//\\ \\ \\//\\/\\/\\/\\\\\\\\  ",
                " \\//\\   \\ / / / // /\\ /\\\\ \\\\/\\",
                "///\\ /\\/\\\\\\\\  / \\/  \\/\\\\\\ \\// ",
                "/ /\\\\  \\ \\\\/\\\\ \\\\  / /\\\\// //\\",
                "/\\/\\///\\/\\//\\\\/\\\\ \\/ \\\\//\\ \\ \\",
                "/\\// / \\/ // \\////\\ \\\\/ \\\\ \\/ ",
                "/  \\\\\\ //\\\\/\\/\\\\\\/\\\\ \\// /\\\\\\/",
                "  \\ ///\\/\\ \\\\ \\\\\\\\/     // // ",
                "\\/\\ / /\\ / /\\\\/\\\\ \\\\\\ /\\\\/  \\\\",
                "\\ //  /\\/  ////\\\\\\/  / \\\\\\ / \\",
                "\\/  \\\\/ \\//\\\\  \\// //\\/ /\\\\\\\\ ",
                " / /   / /    \\\\//\\\\ \\/  ///\\\\",
                "\\\\ \\\\\\/\\ \\/  /\\/    //\\\\\\/  \\ ",
                "//////\\ /\\/// //\\/\\\\\\  /\\\\  //",
                "\\\\\\ //  \\ /\\ // /\\\\  / ///\\\\ /",
                "/\\\\   //\\/\\\\// \\ \\ \\\\/\\\\\\\\\\ \\/",
                "\\/\\ \\\\/// \\ \\//\\/ \\/\\/ / \\ \\/\\",
                "/ /\\\\/\\/\\/   \\\\/ \\\\/ /  \\ \\\\ \\",
                "/\\/\\  / /\\ //\\/\\\\//\\/\\/ /\\\\ /\\",
                "\\ \\//\\\\/\\ /\\ /\\//\\// ///\\ \\   ",
                "  \\\\/ \\//\\ \\\\   // /  \\/\\\\//\\/",
                " \\/\\   \\\\/\\  / \\ / \\\\\\/  \\\\/\\ ",
                "  \\\\\\//\\\\//\\/ /\\\\/ \\\\// \\\\\\ /\\",
            ],
            [" /", "/ "],
            [" /", "  "],
            ["/\\", "\\/"],
            [" /", "/ "],
            [
                " \\ \\/ ///  //\\ \\ \\ /// /\\\\ //\\",
                " ///\\ \\////\\ /\\\\/\\\\///\\//  \\ /",
                "// // /\\ /\\  \\ //\\ \\\\\\\\///\\/\\ ",
                " \\\\\\\\///\\\\/ \\/\\\\ \\\\\\///   /   ",
                " /   / \\\\  \\\\/ \\\\   /\\/ //\\ / ",
                "/  / //// / \\  //\\ ///  /// \\ ",
                "/\\/\\//\\ \\\\\\\\\\ \\\\// //  \\/ \\\\  ",
                " //\\  \\\\\\/\\/\\\\ /\\ /\\/// /\\ //\\",
                "//\\\\\\\\// /  \\\\ /\\/ //\\//\\/\\\\  ",
                " /\\ //\\\\/ /\\/\\//\\ / //\\   \\/ /",
                " \\/  \\///\\/\\\\/ \\ \\   \\// \\//\\ ",
                "  /  ///\\/\\\\\\/\\\\      \\ /\\ / \\",
                "/\\\\/\\  ////\\/ / / /\\/// /   /\\",
                "    \\\\\\ \\   / \\  /\\  //  // / ",
                "   \\/  \\\\ /\\\\// /\\\\\\ /\\  /\\\\\\ ",
                "\\/  \\/\\ /// /\\ / \\ / //  / \\ \\",
                "\\/\\\\\\   \\//\\ \\ \\\\ \\/  // // /\\",
                "/ \\/\\\\\\ // \\\\\\/ \\     /\\/ \\\\\\ ",
                "\\\\ \\/\\ // /\\ // \\\\/\\\\ \\\\ \\   /",
                "/ \\\\  / \\\\\\/\\\\   \\  / \\ \\ /  \\",
                "/ /  \\ \\\\ \\ /\\  /\\ /\\\\// \\\\// ",
                "/ //// \\/\\// /\\/ /   \\ \\\\\\ \\/ ",
                "\\  ////\\/\\  \\ ////\\//\\/  \\/\\ /",
                "/ \\  // \\ / \\\\  /\\  ////  / /\\",
                "/ //\\/ / \\/ \\/\\\\ /\\ /\\    \\//\\",
                "\\/\\\\ \\////\\\\/\\/  //\\ /  /\\\\\\\\ ",
                "/////\\\\\\/  \\ \\  /\\/\\  / /\\//  ",
                "\\ /  // \\//\\\\/\\\\\\    \\//\\ /// ",
                "//  / /  / / /\\\\/\\\\/\\\\\\   \\ \\\\",
                " \\\\ \\ /// \\\\/\\\\   /\\  /  ///\\/",
            ],
            [
                " \\\\     // /\\/\\/ // /\\ \\\\  \\//",
                " \\/\\//\\\\//\\\\\\\\//// /\\/ \\\\/\\/\\/",
                "\\\\\\ /\\// \\\\/   /\\ /\\\\//\\/\\////",
                " //\\\\ \\/ /////\\  /\\/ //\\/ \\/ /",
                " //// / / \\//\\\\ \\\\/\\\\/\\\\\\//  \\",
                "\\\\\\\\ /  /\\/\\\\\\/\\ \\\\//\\ \\ \\ //\\",
                "//\\\\// /\\///\\\\\\\\\\ / \\  /\\/  \\\\",
                "\\// \\\\\\/ //\\ /\\ // / \\\\ /   / ",
                "  /  ///   \\//  \\\\ \\\\ ///\\\\// ",
                " \\ \\\\/  /\\/\\\\   \\  \\  \\\\/\\//\\\\",
                "\\\\   \\ /\\  \\/\\\\/   \\\\\\//\\ /\\ /",
                "  \\\\   \\  \\\\\\\\\\\\/\\  \\/ \\//   \\",
                "\\/ \\ /\\ /\\ \\\\\\/\\   //\\/\\\\ \\\\\\\\",
                "\\\\/ / \\\\// \\/\\\\  \\\\/ \\\\ \\/    ",
                " / \\/\\  \\\\// \\///\\\\/ //\\\\/\\//\\",
                " \\\\ \\/\\/ \\/\\ \\ // /\\   \\\\\\\\/ \\",
                " \\ \\ /\\\\ /\\\\  ///\\ /\\   /\\ \\//",
                "/ / /  // /// /\\ //  / \\ \\ / /",
                "\\/\\\\ \\/\\\\\\ ///\\///\\\\/\\//// \\//",
                "///\\\\\\   \\/ \\\\/\\/\\\\//\\ \\  \\/\\/",
                "\\\\\\ /// //  \\  \\\\/\\/ \\/\\ / /  ",
                " /\\//\\\\ \\/\\ \\/\\/\\\\\\  \\ \\//\\ \\\\",
                "/\\\\ \\//\\\\ / / \\ \\ //\\\\ \\ \\\\ \\ ",
                "/\\/\\/\\ //\\\\ // // /  / \\\\\\/ \\/",
                "/\\\\ /\\\\/ /   //\\ //  / /\\\\  \\ ",
                "\\\\\\//\\\\///\\/ \\\\ \\ \\\\ /  \\\\///\\",
                "/ /\\/\\\\\\///\\/\\\\///// /     /\\ ",
                "\\ \\/\\    /\\/ \\//\\\\ \\\\ \\/\\ \\\\/\\",
                "//\\ /  \\ / /\\\\/////\\\\   \\ /\\  ",
                "/ /  // /\\///\\ \\  \\   /  /\\ \\ ",
            ],
        ].map(regionsBySlashes),
        [37, 2, 1, 5, 2, 32, 41],
    );
});
