use std::collections::BinaryHeap;

use super::Solution;

struct Solution0;

impl Solution for Solution0 {
    fn find_kth_largest(nums: Vec<i32>, k: i32) -> i32 {
        Problem::from(&nums, k as usize)
            .divide()
            .expect("no solution")
    }
}

struct Problem {
    k: usize,
    extra: BinaryHeap<i32>,
}

impl Problem {
    fn from(nums: &[i32], k: usize) -> Problem {
        let mut extra = BinaryHeap::new();
        for num in nums {
            extra.push(*num);
        }
        Problem { k, extra }
    }

    // divide on k
    fn divide(&mut self) -> Option<i32> {
        if self.k == 1 {
            return self.extra.pop();
        }
        self.extra.pop();
        self.k -= 1;
        self.divide()
    }
}

#[test]
fn test_basic() {
    let nums = vec![3, 2, 1, 5, 6, 4];
    let k = 2;
    let ans = Solution0::find_kth_largest(nums, k);
    dbg!(ans);
}
