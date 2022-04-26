import { walk } from "https://deno.land/std@0.136.0/fs/mod.ts";

// Async
async function printFilesNames() {
    console.log("type check start!");
    for await (
        const entry of walk(".", {
            includeFiles: true,
            includeDirs: false,
            exts: ["ts"],
        })
    ) {
        console.log(entry.path);
        const process = Deno.run({
            cmd: ["deno", "check", entry.path],
            stderr: "piped",
            stdout: "piped",
        });
        /*        const [status/* , stdout, stderr */
        //] =  */
        await Promise.all([
            process.status(),
            // process.output(),
            // process.stderrOutput(),
        ]);
        process.close();
        // console.log({ status, stdout, stderr });
    }
}

printFilesNames().then(() => console.log("type check Done!"));
