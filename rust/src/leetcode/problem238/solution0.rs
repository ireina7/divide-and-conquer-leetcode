use super::Solution;

struct Solution0 {}

impl Solution for Solution0 {
    fn product_except_self(nums: Vec<i32>) -> Vec<i32> {
        let mut problem = Problem::from(&nums);
        problem.divide();
        println!("ls: {:?}", problem.ls);
        println!("rs: {:?}", problem.rs);
        problem.ans
    }
}

struct Problem<'a> {
    nums: &'a [i32],
    ls: Vec<i32>,
    rs: Vec<i32>,
    ans: Vec<i32>,
    i: usize,
}

impl<'a> Problem<'a> {
    fn from(nums: &'a [i32]) -> Problem<'a> {
        let n = nums.len();
        let mut ls = vec![1; n];
        let mut rs = vec![1; n];
        let mut prod = 1;
        for (i, num) in nums.iter().enumerate() {
            ls[i] = prod;
            prod *= num;
        }
        prod = 1;
        for (i, num) in nums.iter().rev().enumerate() {
            rs[n - i - 1] = prod;
            prod *= num;
        }
        let ans = vec![0; nums.len()];
        Problem {
            nums,
            ls,
            rs,
            ans,
            i: 0,
        }
    }

    fn divide(&mut self) {
        let i = self.i;
        if i == self.nums.len() - 1 {
            self.ans[i] = self.ls[i];
            return;
        }
        self.ans[i] = self.ls[i] * self.rs[i];
        self.i += 1;
        self.divide()
    }
}

#[test]
fn test() {
    let nums = vec![1, 2, 3, 4];
    let ans = Solution0::product_except_self(nums);
    println!("ans: {:?}", ans);
}
