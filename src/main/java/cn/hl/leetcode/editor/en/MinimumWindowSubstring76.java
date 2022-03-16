package cn.hl.leetcode.editor.en;
//Given two strings s and t of lengths m and n respectively, return the minimum 
//window substring of s such that every character in t (including duplicates) is 
//included in the window. If there is no such substring, return the empty string 
//"". 
//
// The testcases will be generated such that the answer is unique. 
//
// A substring is a contiguous sequence of characters within the string. 
//
// 
// Example 1: 
//
// 
//Input: s = "ADOBECODEBANC", t = "ABC"
//Output: "BANC"
//Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' 
//from string t.
// 
//
// Example 2: 
//
// 
//Input: s = "a", t = "a"
//Output: "a"
//Explanation: The entire string s is the minimum window.
// 
//
// Example 3: 
//
// 
//Input: s = "a", t = "aa"
//Output: ""
//Explanation: Both 'a's from t must be included in the window.
//Since the largest window of s only has one 'a', return empty string.
// 
//
// 
// Constraints: 
//
// 
// m == s.length 
// n == t.length 
// 1 <= m, n <= 10⁵ 
// s and t consist of uppercase and lowercase English letters. 
// 
//
// 
//Follow up: Could you find an algorithm that runs in O(m + n) time? Related 
//Topics Hash Table String Sliding Window 👍 9496 👎 516

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring76 {
    public static void main(String[] args) {
        Solution solution = new MinimumWindowSubstring76().new Solution();
        String s = "a";
        String t = "aa";
        String res = solution.minWindow(s, t);
        System.out.println(res);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 双指针维护滑动窗口
         */
        public String minWindow(String s, String t) {
            // 目标结果
            Map<Character, Integer> target = new HashMap<>();
            for (char c : t.toCharArray()) {
                target.put(c, 1);
            }
            // 滑动窗口
            int[] window = new int[128];
            // 匹配的字符数
            int match = 0;
            // 左右指针起始位置
            int left = 0, right = 0, start = 0, len = Integer.MAX_VALUE;
            while (right < s.length()) {
                char r = s.charAt(right);
                // 扩大窗口
                right++;
                // 更新窗口数据
                if (target.containsKey(r)) {
                    window[r]++;
                    // 目标字符串可能有重复字符,所以当出现次数一致时再更新
                    if (window[r] == target.get(r)) {
                        match++;
                    }
                }
                // 所有字符出现次数均一致时缩小窗口
                while (match == target.size()) {
                    // 先更新结果
                    if (right - left < len) {
                        len = right - left;
                        start = left;
                    }
                    char l = s.charAt(left);
                    // 收缩窗口
                    left++;
                    // 更新窗口数据
                    if (target.containsKey(l)) {
                        if (window[l] == target.get(l)) {
                            match--;
                        }
                        window[l]--;
                    }
                }
            }
            return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}