package problem283

type Solution0 struct {
	pre int
}

func (self *Solution0) MoveZeroes(nums []int) {
	if len(nums) == 0 {
		self.pre = 0
		return
	}
	if len(nums) == 1 {
		if nums[0] == 0 {
			self.pre = 0
		} else {
			self.pre = 1
		}
		return
	}
	n := len(nums)
	last := nums[n-1]
	self.MoveZeroes(nums[:n-1])
	if last == 0 {
		return
	}
	nums[self.pre] = last
	if self.pre != n-1 {
		nums[n-1] = 0
	}
	self.pre += 1
}
