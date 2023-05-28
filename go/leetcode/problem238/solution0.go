package problem238

type Solution0 struct{}

func (self *Solution0) productExceptSelf(nums []int) []int {
	n := len(nums)
	ls := make([]int, n)
	rs := make([]int, n)
	ls[0] = nums[0]
	rs[n-1] = nums[n-1]
	for i := 1; i < n; i++ {
		ls[i] = nums[i] * ls[i-1]
		rs[n-i-1] = nums[n-i-1] * rs[n-i]
	}
	ans := make([]int, n)
	ans[0] = rs[1]
	ans[n-1] = ls[n-2]
	for i := 1; i < n-1; i++ {
		ans[i] = ls[i-1] * rs[i+1]
	}
	return ans
}
