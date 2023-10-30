trait MinStack {
    fn new() -> Self;
    fn push(&mut self, val: i32);
    fn pop(&mut self);
    fn top(&self) -> i32;
    fn get_min(&self) -> i32;
}

pub mod solution0;
