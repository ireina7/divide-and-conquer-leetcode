use std::{collections::HashMap, rc::Rc};

use super::Solution;

struct Solution0 {}

impl Solution for Solution0 {
    fn min_window(s: String, t: String) -> String {
        let mut problem = Problem::from(s.as_bytes(), t.as_bytes());
        problem.divide().expect("pattern not exist")
    }
}

struct Problem<'a> {
    bs: &'a [u8],
    ts: &'a [u8],
    cs: [Option<usize>; 26], // record of char index
    need: [i32; 26],         // current need chars
    need_count: usize,       // total related char count
    i: usize,                // current index
    j: usize,                // start index of previous found
}

impl<'a> Problem<'a> {
    fn from(bs: &'a [u8], ts: &'a [u8]) -> Problem<'a> {
        let cs = [None; 26];
        let mut need = [0; 26];
        for t in ts {
            need[Self::index(*t)] += 1;
        }
        Problem {
            bs,
            ts,
            cs,
            need,
            need_count: ts.len(),
            i: bs.len(),
            j: 0,
        }
    }

    fn index(c: u8) -> usize {
        (c - b'a') as usize
    }

    fn covers(&self) -> bool {
        self.need_count == 0
    }

    fn divide(&mut self) -> Option<String> {
        // base case
        if !self.covers() {
            let mut i = self.i;
            while !self.covers() && i < self.bs.len() {
                let c = self.bs[i];
                let j = Self::index(c);
                if self.need[j] <= 0 {
                    i += 1;
                    continue;
                }
                self.need[j] -= 1;
                self.need_count -= 1;
                i += 1;
            }
            return None;
        }

        let i = self.i;
        let c = self.bs[i];
        self.i -= 1;
        let mut ans = self.divide().unwrap();
        if self.bs[self.j] != c {
            self.need[Self::index(c)] -= 1;
            return Some(ans);
        }
        // c == bs[j]
        self.j += 1;
        while self.covers() {}
        todo!()
    }
}
