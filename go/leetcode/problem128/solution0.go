package problem128

// Dynamic programming?
type Solution0 struct {
	memo0 map[int]int
	memo1 map[int]int
}

// TODO 重构
func (self *Solution0) LongestConsecutive(nums []int) int {
	ans := 0

	return ans
}

func max(a, b int) int {
	if a < b {
		return b
	}
	return a
}
