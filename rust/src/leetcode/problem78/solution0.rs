use super::Solution;

struct Solution0;

impl Solution for Solution0 {
    fn subsets(nums: Vec<i32>) -> Vec<Vec<i32>> {
        let mut problem = Problem::from(&nums);
        problem.divide();
        problem.ans
    }
}

struct Problem<'a> {
    nums: &'a [i32],
    i: usize,
    ans: Vec<Vec<i32>>,
    cur: Vec<i32>,
}

impl Problem<'_> {
    fn from(nums: &[i32]) -> Problem {
        Problem {
            nums,
            i: 0,
            ans: Vec::new(),
            cur: Vec::new(),
        }
    }

    fn divide(&mut self) {
        if self.i >= self.nums.len() {
            self.ans.push(self.cur.clone());
            return;
        }
        let num = self.nums[self.i];
        self.i += 1;
        self.cur.push(num);
        self.divide();
        self.cur.pop();
        self.i -= 1;

        self.i += 1;
        self.divide();
        self.i -= 1;
    }
}

#[test]
fn test() {
    let nums = vec![1, 2, 3];
    let ans = Solution0::subsets(nums);
    dbg!(ans);
}
