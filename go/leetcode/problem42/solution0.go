package problem42

type Solution0 struct{}

func (self *Solution0) Trap(hs []int) int {

	return 0
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
		if bs[0] <= h {
			w += bs[0] * (bs[0] - g)
			g = bs[0]
			bs[0] = 0
		} else {
			break
		}
	}
	return ans, bs
}
