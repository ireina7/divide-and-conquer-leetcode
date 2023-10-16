use std::{cell::RefCell, rc::Rc};

use super::Solution;

struct Solution0 {}

impl Solution for Solution0 {
    fn diameter_of_binary_tree(root: Option<Rc<RefCell<super::TreeNode>>>) -> i32 {
        Problem::from(root).divide()
    }
}

struct Problem {
    root: Option<Rc<RefCell<super::TreeNode>>>,
    max_path_length_root: i32,
}

impl Problem {
    fn from(root: Option<Rc<RefCell<super::TreeNode>>>) -> Problem {
        Problem {
            root,
            max_path_length_root: 0,
        }
    }

    fn divide(&mut self) -> i32 {
        match &mut self.root {
            None => {
                self.max_path_length_root = 0;
                0
            }
            Some(root) => {
                let mut problem = Self::from(root.borrow_mut().left.take());
                let ls = problem.divide();
                let ls_half = problem.max_path_length_root;

                let mut problem = Self::from(root.borrow_mut().right.take());
                let rs = problem.divide();
                let rs_half = problem.max_path_length_root;

                let mut ans = i32::max(ls, rs);
                ans = ans.max(ls_half + rs_half);

                self.max_path_length_root = i32::max(ls_half, rs_half) + 1;
                ans
            }
        }
    }
}
