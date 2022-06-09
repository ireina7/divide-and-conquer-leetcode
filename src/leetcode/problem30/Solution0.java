package leetcode.problem30;
import java.util.*;

/**
 * https://leetcode.cn/problems/substring-with-concatenation-of-all-words/
 * */
public class Solution0 {
    String[] words;
    Map<String, Integer> dict;
    Map<String, Integer> subWords;
    String s;
    public List<Integer> findSubstring(String s, String[] words) {
        this.s = s;
        this.words = words;
        this.dict = new HashMap<>();
        this.subWords = new HashMap<>();
        for(String word : words) {
            dict.put(word, dict.getOrDefault(word, 0) + 1);
        }
        return search();
    }
    // I do not have time!
    // I need time to write good algorithm, currently evil code here
    List<Integer> search() {
        int wordLen = words[0].length();
        int n = words.length * wordLen;
        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i < s.length() - n + 1; i++) {
            this.subWords = new HashMap<>();
            int j = i;
            while(j < i + n) {
                String curWord = s.substring(j, j + wordLen);
                if(!dict.containsKey(curWord) || subWords.get(curWord) == dict.get(curWord)) {
                    break;
                }
                subWords.put(curWord, subWords.getOrDefault(curWord, 0) + 1);
                j += wordLen;
            }
            if(j == i + n) {
                ans.add(i);
            }
        }
        return ans;
    }
    
    List<Integer> dfs(int i) {
        int wordLen = words[0].length();
        int n = words.length * wordLen;
        List<Integer> ans = new ArrayList<>();
        if(i == 0) {
            return ans;
        }
        List<Integer> pre = dfs(i - 1);
        
        return ans;
    }
}










