use super::Solution;

struct Solution0 {}

impl Solution for Solution0 {
    fn max_sliding_window(nums: Vec<i32>, k: i32) -> Vec<i32> {
        let k = k as usize;
        let mut ans = nums.clone();
        let mut problem = Problem::from(&nums, k, &mut ans);
        problem.divide();
        ans.into_iter().take(nums.len() - k + 1).collect()
    }
}

struct Problem<'a> {
    nums: &'a [i32],
    k: usize,
    ans: &'a mut [i32],
}

impl<'a> Problem<'a> {
    fn from(nums: &'a [i32], k: usize, ans: &'a mut [i32]) -> Problem<'a> {
        Problem { nums, k, ans }
    }

    fn divide(&mut self) {
        if self.k == 1 {
            return;
        }
        let k = self.k;
        self.k /= 2;
        self.divide();

        for i in 0..self.nums.len() - k + 1 {
            self.ans[i] = self.ans[i].max(self.ans[i + k / 2]);
            if k % 2 != 0 {
                self.ans[i] = self.ans[i].max(self.nums[i + k - 1]);
            }
        }
    }
}

#[test]
fn test() {
    let nums = vec![-6, -10, -7, -1, -9, 9, -8, -4, 10];
    let k = 7;
    let ans = Solution0::max_sliding_window(nums, k);
    println!("window ans: {:?}", ans);
}
