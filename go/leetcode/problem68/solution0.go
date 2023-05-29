package problem68

type Solution0 struct{}

func (self *Solution0) FullJustify(words []string, maxWidth int) []string {
	ans := []string{}
	if len(words) == 0 {
		return ans
	}
	numBlank := 0
	width := len(words[0])
	for i := 1; i < len(words) && width+len(words[i]) < maxWidth; i++ {
		width += len(words[i])
		numBlank += 1
	}
	// todo
	return ans
}
