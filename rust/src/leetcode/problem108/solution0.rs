use super::Solution;
use super::TreeNode;
use std::{cell::RefCell, rc::Rc};

type Node = Option<std::rc::Rc<std::cell::RefCell<super::TreeNode>>>;

struct Solution0 {}

impl Solution for Solution0 {
    fn sorted_array_to_bst(nums: Vec<i32>) -> Node {
        Problem::from(&nums).divide()
    }
}

struct Problem<'a> {
    nums: &'a [i32],
}

impl<'a> Problem<'a> {
    fn from(nums: &'a [i32]) -> Problem {
        Problem { nums }
    }

    fn divide(&self) -> Node {
        if self.nums.len() == 0 {
            return None;
        }
        let mid = self.nums.len() / 2;
        let ls = &self.nums[..mid];
        let rs = &self.nums[mid + 1..];

        Some(Rc::new(RefCell::new(TreeNode {
            val: self.nums[mid],
            left: Self::from(ls).divide(),
            right: Self::from(rs).divide(),
        })))
    }
}
