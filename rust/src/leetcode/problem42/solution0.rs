use std::collections::VecDeque;

use super::Solution;

struct Solution0 {}

impl Solution for Solution0 {
    fn trap(height: Vec<i32>) -> i32 {
        let mut problem = Problem::from(&height);
        problem.divide()
    }
}

struct Problem<'a> {
    hs: &'a [i32],
    pre: VecDeque<usize>,
    i: usize,
}

impl<'a> Problem<'a> {
    fn from(hs: &'a [i32]) -> Problem<'a> {
        let pre = VecDeque::new();
        Problem {
            hs,
            pre,
            i: hs.len() - 1,
        }
    }

    // Divide on index
    fn divide(&mut self) -> i32 {
        let i = self.i;
        if i == 0 {
            self.pre.push_back(0);
            return 0;
        }
        self.i -= 1;
        let mut water = self.divide();
        let h = self.hs[i];
        let mut floor = 0;
        while self.pre.len() > 0 {
            let j = self.pre.back().unwrap();
            if self.hs[*j] <= h {
                water += (i - j - 1) as i32 * (self.hs[*j] - floor);
            } else {
                water += (i - j - 1) as i32 * (h - floor);
                break;
            }
            floor = self.hs[*j];
            self.pre.pop_back();
        }
        self.pre.push_back(i);
        water
    }
}

#[test]
fn test() {
    //      #
    // #    #
    // #  # #
    // ## ###
    // ## ###
    let hs = vec![4, 2, 0, 3, 2, 5];
    let ans = Solution0::trap(hs);
    println!("water: {:?}", ans);
}
