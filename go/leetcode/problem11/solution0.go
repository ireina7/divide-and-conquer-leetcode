package problem11

type Solution0 struct {
}

func (self *Solution0) MaxArea(hs []int) int {
	if len(hs) <= 1 {
		return 0
	}
	n := len(hs)
	i := hs[0]
	j := hs[n-1]
	area := min(i, j) * (n - 1)
	var maxArea int
	if i < j {
		maxArea = self.MaxArea(hs[1:n])
	} else if i > j {
		maxArea = self.MaxArea(hs[0 : n-1])
	} else {
		maxArea = self.MaxArea(hs[1 : n-1])
	}
	maxArea = max(maxArea, area)
	return maxArea
}

func max(a, b int) int {
	if a < b {
		return b
	}
	return a
}

func min(a, b int) int {
	if a < b {
		return a
	}
	return b
}
