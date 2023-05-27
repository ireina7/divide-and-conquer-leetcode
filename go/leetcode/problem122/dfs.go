package problem122

func maxProfit(prices []int) int {
	ans, _ := dfs(prices)
	return ans
}

func dfs(ps []int) (int, int) {
	if len(ps) <= 1 {
		return 0, 0
	}
	ans, pre := dfs(ps[1:])
	pre = max(pre, (ps[1]-ps[0])+pre)
	ans = max(ans, pre)
	return ans, pre
}

func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}
