package cn.hl.leetcode.editor.en;
//A message containing letters from A-Z can be encoded into numbers using the 
//following mapping: 
//
// 
//'A' -> "1"
//'B' -> "2"
//...
//'Z' -> "26"
// 
//
// To decode an encoded message, all the digits must be grouped then mapped 
//back into letters using the reverse of the mapping above (there may be multiple 
//ways). For example, "11106" can be mapped into: 
//
// 
// "AAJF" with the grouping (1 1 10 6) 
// "KJF" with the grouping (11 10 6) 
// 
//
// Note that the grouping (1 11 06) is invalid because "06" cannot be mapped 
//into 'F' since "6" is different from "06". 
//
// Given a string s containing only digits, return the number of ways to decode 
//it. 
//
// The test cases are generated so that the answer fits in a 32-bit integer. 
//
// 
// Example 1: 
//
// 
//Input: s = "12"
//Output: 2
//Explanation: "12" could be decoded as "AB" (1 2) or "L" (12).
// 
//
// Example 2: 
//
// 
//Input: s = "226"
//Output: 3
//Explanation: "226" could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2
// 6).
// 
//
// Example 3: 
//
// 
//Input: s = "06"
//Output: 0
//Explanation: "06" cannot be mapped to "F" because of the leading zero ("6" is 
//different from "06").
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 100 
// s contains only digits and may contain leading zero(s). 
// 
// Related Topics String Dynamic Programming 👍 6565 👎 3771

import java.util.HashSet;
import java.util.Set;

public class DecodeWays91 {
    public static void main(String[] args) {
        Solution solution = new DecodeWays91().new Solution();
        String s = "aab";
        System.out.println();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * dp[i] = dp[i-1]*x + dp[i-2]*y
         * x/y = 1 if [i-1,i] or [i-2,i] is a valid encode, else x/y is zero
         */
        public int numDecodings(String s) {
            if (s.startsWith("0")) {
                return 0;
            }
            mapping = new HashSet<>();
            for (int i = 1; i <= 26; i++) {
                mapping.add(String.valueOf(i));
            }
            return decode(s, s.length());
        }

        Set<String> mapping;

        int decode(String s, int i) {
            if (i == 1) {
                return mapping.contains(s.substring(0, i)) ? 1 : 0;
            }
            if (i == 2) {
                return mapping.contains(s.substring(0, i)) ? 1 : 0;
            }
            return decode(s, i - 1) * (mapping.contains(s.substring(i - 1, i)) ? 1 : 0)
                    + decode(s, i - 2) * (mapping.contains(s.substring(i - 2, i)) ? 1 : 0);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}