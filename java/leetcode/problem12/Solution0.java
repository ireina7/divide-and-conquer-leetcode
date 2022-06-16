package leetcode.problem12;

/** https://leetcode.cn/problems/integer-to-roman/
 *
 * 字符      数值
 * I         1
 * V         5
 * X         10
 * L         50
 * C         100
 * D         500
 * M         1000
 * */
public class Solution0 {
  String[] thousands = {"", "M", "MM", "MMM"};
  String[] hundreds  = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
  String[] tens      = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
  String[] ones      = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};


  /** This is trivial to implement divide-and-conquer, just hard coded for convenience.
   * */
  public String intToRoman(int num) {
    StringBuffer roman = new StringBuffer();
    roman.append(thousands[num / 1000]);
    roman.append(hundreds[num % 1000 / 100]);
    roman.append(tens[num % 100 / 10]);
    roman.append(ones[num % 10]);
    return roman.toString();
  }
}
