package problem42

type Solution0 struct{}

func (self *Solution0) Trap(hs []int) int {
	ans, _ := self.dfs(hs)
	return ans
}

func (self *Solution0) dfs(hs []int) (int, []int) {
	if len(hs) == 0 {
		return 0, []int{}
	}
	h := hs[0]
	ans, bs := self.dfs(hs[1:])
	w := 0 // current water
	g := 0 // ground height
	for len(bs) > 0 {
		i := bs[0] + 1
		w += (i - 1) * (min(hs[i], h) - g)
		if hs[i] <= h {
			g = hs[i]
			bs = bs[1:]
		} else {
			for j := 0; j < len(bs); j++ { // Can be further optimized
				bs[j] += 1
			}
			bs = append([]int{0}, bs...)
			break
		}
	}
	if len(bs) == 0 {
		bs = []int{0}
	}
	return ans + w, bs
}

func min(a, b int) int {
	if a < b {
		return a
	}
	return b
}
