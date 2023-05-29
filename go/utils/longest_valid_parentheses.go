package utils

func longestValidParentheses(s string) int {
	ans := 0
	for i := 0; i < len(s); i++ {
		n := dfs([]byte(s[i:]))
		if n > ans {
			ans = n
		}
	}
	return ans
}

func dfs(s []byte) int {
	if len(s) == 0 {
		return 0
	}
	if s[0] == '(' {
		if len(s) > 1 && s[1] == ')' {
			return 2 + dfs(s[2:])
		}
		inner := dfs(s[1:])
		if len(s) <= inner+1 {
			return 0
		}
		if s[inner+1] == ')' {
			cur := inner + 2
			if len(s) > inner+2 {
				cur += dfs(s[inner+2:])
			}
			return cur
		}
		return 0
	}
	return 0
}

type Memo struct {
	memo map[int]int
	s    string
}

func (self *Memo) dfs(i int) int {
	if n, ok := self.memo[i]; ok {
		return n
	}
	s := []byte(self.s)[i:]
	if len(s) == 0 {
		return 0
	}
	ans := 0
	if s[0] == '(' {
		if len(s) > 1 && s[1] == ')' {
			ans = 2 + self.dfs(i+2)
		} else {
			inner := self.dfs(i + 1)
			if len(s) <= inner+1 {
				ans = 0
			} else if s[inner+1] == ')' {
				cur := inner + 2
				if len(s) > inner+2 {
					cur += self.dfs(i + inner + 2)
				}
				ans = cur
			}
		}
	}
	self.memo[i] = ans
	return ans
}

func (self *Memo) LongestValidParenthesesFromIndex(i int) int {
	ans := 0
	for i := 0; i < len(self.s); i++ {
		n := self.dfs(i)
		if n > ans {
			ans = n
		}
	}
	return ans
}

type DP struct {
	s    string
	memo []int
}

func (self *DP) dp(i int) int {
	memo := self.memo
	for i := len(self.s); i >= 0; i-- {
		if i == len(self.s) {
			memo[i] = 0
			continue
		}
		s := self.s[i:]
		if s[0] == '(' {
			if len(s) > 1 && s[1] == ')' {
				memo[i] = 2 + memo[i+2]
				continue
			}
			inner := memo[i+1]
			if len(s) <= inner+1 {
				memo[i] = 0
				continue
			}
			if s[inner+1] == ')' {
				cur := inner + 2
				if len(s) > inner+2 {
					cur += memo[i+inner+2]
				}
				memo[i] = cur
				continue
			}
		}
		memo[i] = 0
	}
	return memo[0]
}

func (self *DP) LongestValidParenthesesFromIndex(i int) int {
	self.dp(0)
	ans := 0
	for i := 0; i < len(self.s); i++ {
		if self.memo[i] > ans {
			ans = self.memo[i]
		}
	}
	return ans
}
