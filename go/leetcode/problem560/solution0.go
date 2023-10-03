package problem560

type Solution0 struct {
	sum  int
	sums map[int]bool
}

func (self *Solution0) SubarraySum(nums []int, k int) int {
	if len(nums) == 0 {
		return 0
	}
	num := nums[0]
	ans := self.SubarraySum(nums[1:], k)
	if num == k {
		return ans + 1
	}
	_, exist := self.sums[k-num]
	self.sum += num
	self.sums[self.sum] = true
	if !exist {
		return ans
	}
	return ans + 1
}
