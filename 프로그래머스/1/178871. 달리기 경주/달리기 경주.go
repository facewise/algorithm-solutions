func solution(players []string, callings []string) []string {
	ans := make([]string, len(players))
	m := make(map[string]int, len(players))
	for i, p := range players {
		m[p] = i
		ans[i] = p
	}
	for _, call := range callings {
		i := m[call]
		tmp := ans[i-1]
		ans[i-1] = ans[i]
		ans[i] = tmp
		m[call] = i-1
		m[tmp] = i
	}
	return ans
}
