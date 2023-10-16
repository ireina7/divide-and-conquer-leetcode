use super::*;

struct Solution0 {}

impl Solution for Solution0 {
    fn invert_tree(root: Node) -> Node {
        Problem::from(root).divide()
    }
}

struct Problem {
    node: Node,
}

impl Problem {
    fn from(root: Node) -> Problem {
        Problem { node: root }
    }

    fn divide(self) -> Node {
        match self.node {
            None => None,
            Some(node) => {
                let ls = Self::from(node.borrow_mut().left.take());
                let rs = Self::from(node.borrow_mut().right.take());
                node.borrow_mut().left = rs.divide();
                node.borrow_mut().right = ls.divide();
                Some(node)
            }
        }
    }
}
