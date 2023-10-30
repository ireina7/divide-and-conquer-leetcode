use super::MinStack;

struct Solution0 {
    stack: Vec<(i32, i32)>,
}

impl MinStack for Solution0 {
    fn new() -> Self {
        Self { stack: Vec::new() }
    }

    fn push(&mut self, val: i32) {
        let top = self.stack.last();
        let min = match top {
            None => val,
            Some((_, min)) => *min.min(&val),
        };
        self.stack.push((val, min));
    }

    fn pop(&mut self) {
        self.stack.pop();
    }

    fn top(&self) -> i32 {
        self.stack.last().unwrap().0
    }

    fn get_min(&self) -> i32 {
        self.stack.last().unwrap().1
    }
}
