package problem53

import "golang.org/x/exp/constraints"

// Super easy divide-and-conquer
type Solution0 struct{}

func (self *Solution0) MaxSubArray(nums []int) int {
	ans, _ := self.dfs(nums)
	return ans
}

func (self *Solution0) dfs(nums []int) (int, int) {
	if len(nums) == 0 {
		return 0, 0
	}
	if len(nums) == 1 {
		return nums[0], nums[0]
	}
	num := nums[0]
	ans, pre := self.dfs(nums[1:])
	cur := max(num, num+pre)
	ans = max(ans, cur)
	pre = cur
	return ans, pre
}

func max[T constraints.Ordered](a, b T) T {
	if a > b {
		return a
	}
	return b
}
