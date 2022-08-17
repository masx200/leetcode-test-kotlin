package main

import (
	"fmt"
	"io/fs"
	"os"
	"os/exec"
	"path"
)

func main() {

	var matches, err = (fs.Glob(os.DirFS("./"), "./*/go.mod"))
	if err != nil {
		fmt.Println(err)
		return
	}

	out := make(chan any)
	in := make(chan string)

	for _, m := range matches {

		go func() {
			d := <-in
			run(d, out)

		}()
		in <- m
	}

	for range matches {
		var b = <-out
		if nil != b {
			panic(b)
		}
	}

}
func run(m string, out chan any) {
	defer func() {
		var e = recover()
		if e != nil {

			out <- e
			return
		}
		out <- nil
	}()

	cmd := exec.Command("go", "test", "-v")

	cmd.Dir = "./" + path.Dir(m)
	fmt.Println(cmd.Dir, cmd)
	cmd.Stdout = os.Stdout
	cmd.Stderr = os.Stderr
	var err = cmd.Run()
	if err != nil {
		panic(err)
	}
}
