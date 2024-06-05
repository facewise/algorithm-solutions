package main

import (
	"bufio"
	"fmt"
	"os"
	"strconv"
	"strings"
)

func main() {
	br := bufio.NewReader(os.Stdin)
	bw := bufio.NewWriter(os.Stdout)
	defer bw.Flush()

	s := NewSet()
	var n int
	fmt.Fscanln(br, &n)
	for i := 0; i < n; i++ {
		buf, _, _ := br.ReadLine()
		line := string(buf)
		op := strings.Split(line, " ")
		switch op[0] {
		case "add":
			v, _ := strconv.Atoi(op[1])
			s.add(v)
		case "remove":
			v, _ := strconv.Atoi(op[1])
			s.remove(v)
		case "check":
			v, _ := strconv.Atoi(op[1])
			bw.WriteString(s.check(v) + "\n")
		case "toggle":
			v, _ := strconv.Atoi(op[1])
			s.toggle(v)
		case "all":
			s.all()
		case "empty":
			s.empty()
		}
	}
}

func NewSet() Set {
	return Set{make([]bool, 21)}
}

type Set struct {
	arr []bool
}

func (set *Set) add(x int) {
	set.arr[x] = true
}

func (set *Set) remove(x int) {
	set.arr[x] = false
}

func (set *Set) check(x int) string {
	if set.arr[x] {
		return "1"
	}
	return "0"
}

func (set *Set) toggle(x int) {
	set.arr[x] = !set.arr[x]
}

func (set *Set) all() {
	for i := 0; i < len(set.arr); i++ {
		set.arr[i] = true
	}
}

func (set *Set) empty() {
	for i := 0; i < len(set.arr); i++ {
		set.arr[i] = false
	}
}
