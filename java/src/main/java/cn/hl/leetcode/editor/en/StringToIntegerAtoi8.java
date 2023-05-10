package cn.hl.leetcode.editor.en;
//Implement the myAtoi(string s) function, which converts a string to a 32-bit 
//signed integer (similar to C/C++'s atoi function). 
//
// The algorithm for myAtoi(string s) is as follows: 
//
// 
// Read in and ignore any leading whitespace. 
// Check if the next character (if not already at the end of the string) is '-' 
//or '+'. Read this character in if it is either. This determines if the final 
//result is negative or positive respectively. Assume the result is positive if 
//neither is present. 
// Read in next the characters until the next non-digit character or the end of 
//the input is reached. The rest of the string is ignored. 
// Convert these digits into an integer (i.e. "123" -> 123, "0032" -> 32). If 
//no digits were read, then the integer is 0. Change the sign as necessary (from 
//step 2). 
// If the integer is out of the 32-bit signed integer range [-2³¹, 2³¹ - 1], 
//then clamp the integer so that it remains in the range. Specifically, integers 
//less than -2³¹ should be clamped to -2³¹, and integers greater than 2³¹ - 1 should 
//be clamped to 2³¹ - 1. 
// Return the integer as the final result. 
// 
//
// Note: 
//
// 
// Only the space character ' ' is considered a whitespace character. 
// Do not ignore any characters other than the leading whitespace or the rest 
//of the string after the digits. 
// 
//
// 
// Example 1: 
//
// 
//Input: s = "42"
//Output: 42
//Explanation: The underlined characters are what is read in, the caret is the 
//current reader position.
//Step 1: "42" (no characters read because there is no leading whitespace)
//         ^
//Step 2: "42" (no characters read because there is neither a '-' nor '+')
//         ^
//Step 3: "42" ("42" is read in)
//           ^
//The parsed integer is 42.
//Since 42 is in the range [-2³¹, 2³¹ - 1], the final result is 42.
// 
//
// Example 2: 
//
// 
//Input: s = "   -42"
//Output: -42
//Explanation:
//Step 1: "   -42" (leading whitespace is read and ignored)
//            ^
//Step 2: "   -42" ('-' is read, so the result should be negative)
//             ^
//Step 3: "   -42" ("42" is read in)
//               ^
//The parsed integer is -42.
//Since -42 is in the range [-2³¹, 2³¹ - 1], the final result is -42.
// 
//
// Example 3: 
//
// 
//Input: s = "4193 with words"
//Output: 4193
//Explanation:
//Step 1: "4193 with words" (no characters read because there is no leading 
//whitespace)
//         ^
//Step 2: "4193 with words" (no characters read because there is neither a '-' 
//nor '+')
//         ^
//Step 3: "4193 with words" ("4193" is read in; reading stops because the next 
//character is a non-digit)
//             ^
//The parsed integer is 4193.
//Since 4193 is in the range [-2³¹, 2³¹ - 1], the final result is 4193.
// 
//
// 
// Constraints: 
//
// 
// 0 <= s.length <= 200 
// s consists of English letters (lower-case and upper-case), digits (0-9), ' ',
// '+', '-', and '.'. 
// 
// Related Topics String 👍 1382 👎 3934

public class StringToIntegerAtoi8 {
    public static void main(String[] args) {
        Solution solution = new StringToIntegerAtoi8().new Solution();
        String s = "1095502006p8";
        int res = solution.myAtoi(s);
        System.out.println(res);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        String nums = "0123456789";

        public int myAtoi(String s) {
            if (s == null || s.length() == 0) {
                return 0;
            }
            StringBuilder sb = new StringBuilder();
            boolean neg = false;
            // 是否读取过非空字符
            boolean read = false;
            for (int i = 0; i < s.length(); i++) {
                // 忽略开头的空字符
                if (!read && s.charAt(i) == ' ') {
                    continue;
                }
                // 忽略开头的0
                if (sb.length() == 0 && s.charAt(i) == '0') {
                    read = true;
                    continue;
                }
                // 判断符号
                if (!read && s.charAt(i) == '-') {
                    neg = true;
                    read = true;
                    continue;
                }
                if (!read && s.charAt(i) == '+') {
                    read = true;
                    continue;
                }
                // 非数字终止读取
                if (!nums.contains(String.valueOf(s.charAt(i)))) {
                    break;
                }
                read = true;
                sb.append(s.charAt(i));
            }
            if (sb.length() == 0) {
                return 0;
            }
            boolean is = isValid(sb, neg);
            return is ? parseInt(sb, neg) : neg ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        }

        int parseInt(StringBuilder sb, boolean neg) {
            int res = 0;
            for (int i = 0; i < sb.length(); i++) {
                int multiply = (int) Math.pow(10, sb.length() - 1 - i);
                res += Integer.parseInt(String.valueOf(sb.charAt(i))) * multiply;
            }
            return neg ? -res : res;
        }

        boolean isValid(StringBuilder sb, boolean neg) {
            String minInt = String.valueOf(Integer.MIN_VALUE);
            minInt = minInt.substring(1, minInt.length());
            String maxInt = String.valueOf(Integer.MAX_VALUE);
            String limit = neg ? minInt : maxInt;

            if (sb.length() > limit.length()) {
                return false;
            }
            if (sb.length() < limit.length()) {
                return true;
            }
            for (int i = 0; i < sb.length(); i++) {
                int i1 = Integer.parseInt(String.valueOf(sb.charAt(i)));
                int i2 = Integer.parseInt(String.valueOf(limit.charAt(i)));
                if (i1 > i2) {
                    return false;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}