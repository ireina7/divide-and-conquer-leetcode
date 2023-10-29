use super::Solution;

struct Solution0;

impl Solution for Solution0 {
    fn h_index(citations: Vec<i32>) -> i32 {
        Problem::from(&citations, 0, citations.len() as i32).divide()
    }
}

#[derive(Debug)]
struct Problem<'a> {
    cs: &'a [i32],
    h_min: i32,
    h_max: i32,
}

impl<'a> Problem<'a> {
    fn from(cs: &'a [i32], h_min: i32, h_max: i32) -> Problem {
        Problem { cs, h_min, h_max }
    }

    fn divide(&self) -> i32 {
        if self.h_max < self.h_min {
            return 0;
        }
        if self.check() {
            return self.h_max;
        }
        let k = self.h_min + ((self.h_max - self.h_min) >> 1);
        let problem = Self::from(self.cs, self.h_min, k);
        if problem.check() {
            if k == self.h_min {
                return self.h_min;
            }
            let problem = Self::from(self.cs, k, self.h_max);
            problem.divide()
        } else {
            if k == self.h_max {
                return 0;
            }
            let problem = Self::from(self.cs, self.h_min, k);
            problem.divide()
        }
    }

    /// check if current H satisfies
    fn check(&self) -> bool {
        let mut count = 0;
        for cite_num in self.cs {
            if *cite_num >= self.h_max {
                count += 1;
            }
            if count >= self.h_max {
                return true;
            }
        }
        count >= self.h_max
    }
}

#[test]
fn test() {
    let cs = vec![1, 3, 1];
    let ans = Solution0::h_index(cs);
    dbg!(ans);
}
