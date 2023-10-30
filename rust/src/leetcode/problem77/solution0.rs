use super::Solution;

struct Solution0;

impl Solution for Solution0 {
    fn combine(n: i32, k: i32) -> Vec<Vec<i32>> {
        let mut problem = Problem::from(n, k);
        problem.divide();
        problem.ans
    }
}

struct Problem {
    n: i32,
    k: i32,
    i: i32,

    ans: Vec<Vec<i32>>,
    cur: Vec<i32>,
}

impl Problem {
    fn from(n: i32, k: i32) -> Self {
        Self {
            n,
            k,
            i: 1,
            ans: Vec::new(),
            cur: Vec::new(),
        }
    }

    fn divide(&mut self) {
        if self.cur.len() == self.k as usize {
            self.ans.push(self.cur.clone());
            return;
        }
        if self.i == self.n + 1 {
            return;
        }
        if (self.n - self.i + 1 + self.cur.len() as i32) < self.k {
            return;
        }
        self.i += 1;
        self.divide();
        self.i -= 1;

        self.cur.push(self.i);
        self.i += 1;
        self.divide();
        self.i -= 1;
        self.cur.pop();
    }
}

#[test]
fn test() {
    let n = 4;
    let k = 2;
    let ans = Solution0::combine(n, k);
    dbg!(ans);
}
