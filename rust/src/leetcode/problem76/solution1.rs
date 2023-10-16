use std::collections::HashMap;

use super::Solution;
struct Solution1 {}

impl Solution for Solution1 {
    fn min_window(s: String, t: String) -> String {
        let mut ans = "";
        let mut ans_len = s.len();
        let mut count = t.len();
        let mut map = HashMap::new();
        for c in t.chars() {
            let cnt = map.entry(c).or_insert(0);
            *cnt += 1;
        }

        let ss = s.chars().collect::<Vec<char>>();

        let mut l = 0;
        for r in 0..ss.len() {
            if !map.contains_key(&ss[r]) {
                continue;
            }
            if let Some(n) = map.get_mut(&ss[r]) {
                *n -= 1;
                if *n >= 0 {
                    count -= 1;
                }
            }

            while count == 0 {
                if ans_len > r - l {
                    ans = &s[l..=r];
                    ans_len = r - l + 1;
                }
                if !map.contains_key(&ss[l]) {
                    l += 1;
                    continue;
                }
                if let Some(n) = map.get_mut(&ss[l]) {
                    *n += 1;
                    if *n > 0 {
                        count += 1;
                    }
                }
                l += 1;
            }
        }
        ans.to_string()
    }
}
