trait Problem: Sized {
    /// The output of the algorithm
    type Output;

    /// Effect for problem space
    type Space<A>: IntoIterator<Item = A>;

    /// Divide into subproblems
    fn divide(&self) -> Self::Space<Self>;

    fn solve(&self) -> Option<Self::Output>;

    /// Map self.conquer into subproblems
    fn map(&self, space: Self::Space<Self>) -> Self::Space<Self>;

    /// conquer returns the output of algorithm, None if no solution
    fn fold(&self, space: Self::Space<Self>) -> Self;
}

struct Search<'a> {
    nums: &'a [i32],
    target: i32,
    i: usize,
}

impl<'a> Problem for Search<'a> {
    type Output = usize;
    type Space<A> = Option<A>;

    fn divide(&self) -> Self::Space<Self> {
        if self.i == self.nums.len() {
            return None;
        }
        Some(Search {
            nums: self.nums,
            target: self.target,
            i: self.i + 1,
        })
    }

    fn solve(&self) -> Option<Self::Output> {
        todo!()
    }

    fn map(&self, space: Self::Space<Self>) -> Self::Space<Self> {
        todo!()
    }

    fn fold(&self, space: Self::Space<Self>) -> Self {
        todo!()
    }
}

#[test]
fn test() {
    let nums = [1, 2, 3, 4, 5, 6, 7];
    let problem = Search {
        nums: &nums,
        target: 5,
        i: 0,
    };
    let ans = problem.solve();
    println!("search ans: {:?}", ans.into_iter().next());
}
