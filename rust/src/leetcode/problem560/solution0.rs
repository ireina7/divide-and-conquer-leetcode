use super::Solution;
use std::collections::HashMap;

struct Solution0 {}

impl Solution for Solution0 {
    fn subarray_sum(nums: Vec<i32>, k: i32) -> i32 {
        let mut problem = Problem::from(&nums, k);
        problem.divide_and_conquer() as i32
    }
}

// * The problem
struct Problem<'a> {
    nums: &'a [i32],
    k: i32,
    sum_map: HashMap<i32, usize>,
    pre_sums: Vec<i32>,
    i: usize,
}

impl<'a> Problem<'a> {
    // * Build problem
    fn from(nums: &'a [i32], k: i32) -> Problem<'a> {
        let mut sum_map = HashMap::new();
        sum_map.insert(0, 1);
        return Problem {
            nums,
            k,
            sum_map,
            pre_sums: Vec::new(),
            i: nums.len() - 1,
        };
    }

    fn add(&mut self, i: usize) {
        let sum = if i == 0 {
            self.nums[0]
        } else {
            self.pre_sums[i - 1] + self.nums[i]
        };
        self.pre_sums.push(sum);
        self.sum_map.insert(
            sum,
            if self.sum_map.contains_key(&sum) {
                self.sum_map[&sum] + 1
            } else {
                1
            },
        );
    }

    // * Divide and conquer!
    fn divide_and_conquer(&mut self) -> usize {
        if self.i == 0 {
            self.add(0);
            return if self.nums[0] == self.k { 1 } else { 0 };
        }
        let i = self.i;
        let j = i - 1;
        let k = self.k;
        self.i = j;
        let mut ans = self.divide_and_conquer();
        let key = self.pre_sums[i - 1] - (k - self.nums[i]);
        ans += self.sum_map.get(&key).unwrap_or(&0);
        self.add(i);
        ans
    }
}

#[test]
fn test_me() {
    let nums = vec![1, -1, 0];
    let k = 0;
    let ans = Solution0::subarray_sum(nums, k);

    println!("Got {}", ans);
}
