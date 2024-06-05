package main

import (
	"bufio"
	"fmt"
	"os"
	"strconv"
)

func main() {
	br := bufio.NewReader(os.Stdin)
	bw := bufio.NewWriter(os.Stdout)
	defer bw.Flush()

	var n int
	fmt.Fscanln(br, &n)
	stack := NewStack()
	for i := 0; i < n; i++ {
		var v int
		fmt.Fscanln(br, &v)
		if v == 0 {
			stack.Pop()
		} else {
			stack.Push(v)
		}
	}
	bw.WriteString(strconv.Itoa(stack.Sum()))
}

type Stack struct {
	Arr []int
}

func NewStack() Stack {
	return Stack{make([]int, 0)}
}

func (s *Stack) Push(v int) {
	s.Arr = append(s.Arr, v)
}

func (s *Stack) Pop() int {
	v := s.Arr[len(s.Arr)-1]
	s.Arr = s.Arr[:len(s.Arr)-1]
	return v
}

func (s *Stack) Sum() int {
	sum := 0
	for _, v := range s.Arr {
		sum += v
	}
	return sum
}
