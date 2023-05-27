package problem55

import "fmt"

type Solution0 struct{}

func (self *Solution0) CanJump(nums []int) bool {
	n, err := self.dfs(nums)
	return err == nil && n == 0
}

// Very simple idea:
func (self *Solution0) dfs(nums []int) (int, error) {
	if len(nums) == 0 {
		return 0, fmt.Errorf("Empty slice")
	}
	if len(nums) == 1 {
		return 0, nil
	}
	i, err := self.dfs(nums[1:])
	if err != nil {
		return i, err
	}
	if nums[0] < i+1 {
		return i + 1, nil
	}
	return 0, nil
}
