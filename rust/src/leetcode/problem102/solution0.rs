use std::collections::VecDeque;

use super::Solution;

type Tree = std::rc::Rc<std::cell::RefCell<super::TreeNode>>;

struct Solution0 {}

impl Solution for Solution0 {
    fn level_order(root: Option<Tree>) -> Vec<Vec<i32>> {
        match root {
            None => vec![],
            Some(root) => Problem::from(VecDeque::from([root])).divide(),
        }
    }
}

struct Problem {
    roots: VecDeque<Tree>,
}

impl Problem {
    fn from(roots: VecDeque<Tree>) -> Problem {
        Problem { roots }
    }

    fn divide(self) -> Vec<Vec<i32>> {
        let mut roots = self.roots;
        if roots.len() == 0 {
            return vec![];
        }
        let mut ans = vec![];
        let count = roots.len();
        for _ in 0..count {
            let node = roots.pop_front().unwrap();
            ans.push(node.borrow().val);
            let mut node = node.borrow_mut();
            if let Some(node) = node.left.take() {
                roots.push_back(node)
            }
            if let Some(node) = node.right.take() {
                roots.push_back(node)
            }
        }
        let mut rest = Self::from(roots).divide();
        rest.insert(0, ans);
        rest
    }
}
