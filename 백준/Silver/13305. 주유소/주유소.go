package main

import (
	"bufio"
	"os"
	"strconv"
	"strings"
)

func main() {
	br := bufio.NewReader(os.Stdin)
	bw := bufio.NewWriter(os.Stdout)
	defer bw.Flush()

	var n int
	text, _ := br.ReadString('\n')
	text = strings.TrimSpace(text)
	n, _ = strconv.Atoi(text)
	roads := make([]int, n-1)
	cities := make([]int, n)

	text, _ = br.ReadString('\n')
	text = strings.TrimSpace(text)
	s := strings.Split(text, " ")
	for i := 0; i < n-1; i++ {
		roads[i], _ = strconv.Atoi(s[i])
	}

	text, _ = br.ReadString('\n')
	text = strings.TrimSpace(text)
	s = strings.Split(text, " ")
	for i := 0; i < n; i++ {
		cities[i], _ = strconv.Atoi(s[i])
	}

	sum := 0
	pointer := 0

	for pointer < n-1 {
		costForNext := cities[pointer] * roads[pointer]
		next := pointer + 1
		distanceSum := roads[pointer]
		for next < n-1 {
			before := cities[pointer]
			if before > cities[next] {
				break
			}
			if cities[next]*roads[next]+costForNext < cities[pointer]*(distanceSum+roads[next]) {
				break
			}
			distanceSum += roads[next]
			costForNext = cities[pointer] * distanceSum
			next++
		}
		sum += costForNext
		pointer = next
	}

	bw.WriteString(strconv.Itoa(sum))
}
