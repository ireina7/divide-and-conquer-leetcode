use super::Solution;

struct Solution0;

impl Solution for Solution0 {
    fn permute(nums: Vec<i32>) -> Vec<Vec<i32>> {
        let mut problem = Problem::from(&nums);
        problem.divide();
        problem.ans
    }
}

struct Problem<'a> {
    nums: &'a [i32],
    memo: Vec<bool>,
    ans: Vec<Vec<i32>>,
    cur: Vec<i32>,
}

impl<'a> Problem<'a> {
    fn from(nums: &'a [i32]) -> Problem {
        let memo = vec![false; nums.len()];
        Problem {
            nums,
            memo,
            ans: Vec::new(),
            cur: Vec::new(),
        }
    }

    fn divide(&mut self) {
        let mut i = None;
        for j in 0..self.memo.len() {
            if !self.memo[j] {
                i = Some(j);
                let num = self.nums[j];
                self.memo[j] = true;
                self.cur.push(num);
                self.divide();
                self.cur.pop();
                self.memo[j] = false;
            }
        }
        if let None = i {
            self.ans.push(self.cur.clone());
            return;
        }
    }
}

#[test]
fn test() {
    let nums = vec![1, 2, 3];
    let ans = Solution0::permute(nums);
    dbg!(ans);
}
