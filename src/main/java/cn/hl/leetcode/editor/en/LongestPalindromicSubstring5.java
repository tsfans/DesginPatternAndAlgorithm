package cn.hl.leetcode.editor.en;
//Given a string s, return the longest palindromic substring in s. 
//
// 
// Example 1: 
//
// 
//Input: s = "babad"
//Output: "bab"
//Explanation: "aba" is also a valid answer.
// 
//
// Example 2: 
//
// 
//Input: s = "cbbd"
//Output: "bb"
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 1000 
// s consist of only digits and English letters. 
// 
// Related Topics String Dynamic Programming 👍 16033 👎 944

public class LongestPalindromicSubstring5 {
    public static void main(String[] args) {
        Solution solution = new LongestPalindromicSubstring5().new Solution();
        String str = "xaabacxcabaaxcabaax";
        String res = solution.longestPalindrome(str);
        System.out.println(res);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * 暴力遍历,时间复杂度O(N^2)
         */
        public String longestPalindrome2(String s) {
            // base case
            if (s == null || s.length() <= 1) {
                return s;
            }
            String res = "";
            for (int i = 0; i < s.length(); i++) {
                int left = i - 1 < 0 ? i : i - 1;
                int mid = i;
                int right = i + 1 >= s.length() ? i : i + 1;
                boolean odd = true;
                boolean even = true;
                while (left >= 0 || right < s.length()) {
                    // 奇数情况,上次结果也必须为true
                    odd = odd && left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right);
                    // 偶数情况,上次结果也必须为true
                    even = even && mid >= 0 && right < s.length() && s.charAt(mid) == s.charAt(right);
                    if (odd) {
                        if ((right - left + 1) > res.length()) {
                            res = s.substring(left, right + 1);
                        }
                        left--;
                    }
                    if (even) {
                        if ((right - mid + 1) > res.length()) {
                            res = s.substring(mid, right + 1);
                        }
                        mid--;
                    }
                    // 均不满足继续遍历
                    if (!odd && !even) {
                        break;
                    }
                    right++;
                }
            }
            return res;
        }

        public String longestPalindrome(String s) {
            // base case
            if (s == null || s.length() <= 1) {
                return s;
            }
            String res = "";
            for (int i = 0; i < s.length(); i++) {
                // 奇数情况,中心点为i
                String odd = palindrome(s, i, i);
                // 偶数情况
                String even = palindrome(s, i, i + 1);
                String l = odd.length() > even.length() ? odd : even;
                // 更新结果
                res = l.length() > res.length() ? l : res;
            }
            return res;
        }

        private String palindrome(String s, int left, int right) {
            while (left >= 0 && right < s.length()
                    && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            }
            return s.substring(left + 1, right);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}