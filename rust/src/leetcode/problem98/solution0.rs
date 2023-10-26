use std::borrow::BorrowMut;

use super::Solution;

type Tree = Option<std::rc::Rc<std::cell::RefCell<super::TreeNode>>>;
struct Solution0;

impl Solution for Solution0 {
    fn is_valid_bst(root: Tree) -> bool {
        Problem::from(root, None, None).divide()
    }
}

struct Problem {
    root: Tree,
    min: Option<i32>, // None means infinity
    max: Option<i32>,
}

impl Problem {
    fn from(root: Tree, min: Option<i32>, max: Option<i32>) -> Problem {
        Problem { root, min, max }
    }

    fn divide(self) -> bool {
        match self.root {
            None => true,
            Some(node) => {
                let num = node.borrow().val;
                if let Some(min) = self.min {
                    if num <= min {
                        return false;
                    }
                }
                if let Some(max) = self.max {
                    if num >= max {
                        return false;
                    }
                }
                let ls = Self::from(node.borrow().left.clone(), self.min, Some(num));
                let rs = Self::from(node.borrow().right.clone(), Some(num), self.max);
                ls.divide() && rs.divide()
            }
        }
    }
}
