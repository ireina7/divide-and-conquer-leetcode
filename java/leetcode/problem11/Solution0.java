package leetcode.problem11;

/** https://leetcode.cn/problems/container-with-most-water/
 * */
public class Solution0 {
  int[] hs;
  public int maxArea(int[] height) {
    this.hs = height;
    return search(0, hs.length - 1);
  }
  int area(int i, int j) {
    return Math.min(hs[i], hs[j]) * (j - i);
  }
  int search(int i, int j) {
    if(i >= j) return 0;
    int l = hs[i];
    int r = hs[j];
    int v = area(i, j);
    int ans = 0;
    if(l < r) {
      ans = Math.max(v, search(i + 1, j));
    } else if(l > r) {
      ans = Math.max(v, search(i, j - 1));
    } else {
      ans = Math.max(v, search(i + 1, j - 1));
    }
    return ans;
  }
}
