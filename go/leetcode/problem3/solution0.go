package problem3

// 典型的分治哦
type Solution0 struct {
	s    string
	memo map[byte]int
}

func (self *Solution0) LengthOfLongestSubstring(s string) int {
	n := len(s)
	if n == 0 {
		return 0
	}
	ans, _ := self.dfs(n - 1)
	return ans
}

func (self *Solution0) dfs(i int) (int, int) {
	if i == 0 {
		self.memo[self.s[0]] = 0
		return 1, 1
	}
	c := self.s[i]
	ans, pre := self.dfs(i - 1)
	j, exist := self.memo[c]
	self.memo[c] = i
	if !exist || i-pre > j {
		pre += 1
		return max(ans, pre), pre
	}
	pre = i - j
	return max(ans, pre), pre
}

func max(a, b int) int {
	if a < b {
		return b
	}
	return a
}
