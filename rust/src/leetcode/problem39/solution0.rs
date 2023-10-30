use super::Solution;

struct Solution0;

impl Solution for Solution0 {
    fn combination_sum(candidates: Vec<i32>, target: i32) -> Vec<Vec<i32>> {
        let mut problem = Problem::from(&candidates, target);
        problem.divide();
        problem.ans
    }
}

struct Problem<'a> {
    cands: &'a [i32],
    target: i32,
    i: usize,
    sum: i32,

    ans: Vec<Vec<i32>>,
    cur: Vec<i32>,
}

impl<'a> Problem<'a> {
    fn from(cands: &'a [i32], target: i32) -> Problem {
        Problem {
            cands,
            target,
            i: 0,
            sum: 0,
            ans: Vec::new(),
            cur: Vec::new(),
        }
    }

    fn divide(&mut self) {
        if self.i >= self.cands.len() {
            if self.sum == self.target {
                self.ans.push(self.cur.clone());
                return;
            } else {
                return;
            }
        }
        let i = self.i;
        // let sum = self.cur.iter().sum::<i32>();
        if self.sum == self.target {
            self.ans.push(self.cur.clone());
            return;
        }
        if self.sum > self.target {
            return;
        }
        let acc = self.sum;
        let num = self.cands[i];
        self.i += 1;
        self.divide();
        let mut count = 0;
        while self.sum <= self.target {
            count += 1;
            self.sum += num;
            self.cur.push(num);
            self.divide();
        }
        self.i = i;
        self.sum = acc;
        while count > 0 {
            self.cur.pop();
            count -= 1;
        }
    }
}

#[test]
fn test() {
    let cands = vec![2, 3, 5];
    let target = 8;
    let ans = Solution0::combination_sum(cands, target);
    dbg!(ans);
}
