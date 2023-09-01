package problem128

// Dynamic programming?
type Solution0 struct {
	memo map[int]int
}

func NewSolution0() *Solution0 {
	return &Solution0{
		memo: map[int]int{},
	}
}

// TODO 重构
func (self *Solution0) LongestConsecutive(nums []int) int {
	if len(nums) == 0 {
		return 0
	}
	if len(nums) == 1 {
		self.memo[nums[0]] = 1
		return 1
	}
	num := nums[0]
	ans := self.LongestConsecutive(nums[1:])
	numLen, numExist := self.memo[num]
	if numExist {
		return max(ans, numLen)
	}
	newLen := 1
	pre, preExist := self.memo[num-1]
	if preExist {
		newLen += pre
	}
	suc, sucExist := self.memo[num+1]
	if sucExist {
		newLen += suc
	}
	ans = max(ans, newLen)
	self.memo[num] = newLen
	self.memo[num+suc] = newLen
	self.memo[num-pre] = newLen
	return ans
}

func max(a, b int) int {
	if a < b {
		return b
	}
	return a
}
