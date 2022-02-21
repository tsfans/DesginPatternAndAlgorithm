package cn.hl.leetcode.editor.en;
//Given a signed 32-bit integer x, return x with its digits reversed. If 
//reversing x causes the value to go outside the signed 32-bit integer range [-2³¹, 2³¹ -
// 1], then return 0. 
//
// Assume the environment does not allow you to store 64-bit integers (signed 
//or unsigned). 
//
// 
// Example 1: 
//
// 
//Input: x = 123
//Output: 321
// 
//
// Example 2: 
//
// 
//Input: x = -123
//Output: -321
// 
//
// Example 3: 
//
// 
//Input: x = 120
//Output: 21
// 
//
// 
// Constraints: 
//
// 
// -2³¹ <= x <= 2³¹ - 1 
// 
// Related Topics Math 👍 6612 👎 9301

public class ReverseInteger7 {
    public static void main(String[] args) {
        Solution solution = new ReverseInteger7().new Solution();
        int i = -1563847412;
        int res = solution.reverse(i);
        System.out.println(res);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int reverse(int x) {
            if (x == 0) {
                return 0;
            }
            boolean neg = x < 0;
            // 去除负号
            if (neg) {
                x = x * -1;
            }
            // 去除尾0
            while (x % 10 == 0) {
                x = x / 10;
            }
            StringBuilder sb = new StringBuilder();
            String xStr = String.valueOf(x);
            for (int i = xStr.length() - 1; i >= 0; i--) {
                // 反转数字
                sb.append(xStr.charAt(i));
            }
            // 判断是否超出范围
            boolean is = isValid(sb, neg);

            return is ? parseInt(sb, neg) : 0;
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
            // 去除负号
            minInt = minInt.substring(1, minInt.length());
            String limit = neg ? minInt : String.valueOf(Integer.MAX_VALUE);
            // 位数多肯定大
            if (sb.length() > limit.length()) {
                return false;
            }
            // 位数少肯定小
            if (sb.length() < limit.length()) {
                return true;
            }
            // 位数相等逐位比较
            for (int i = 0; i < sb.length(); i++) {
                int i1 = Integer.parseInt(String.valueOf(sb.charAt(i)));
                int i2 = Integer.parseInt(String.valueOf(limit.charAt(i)));
                if (i1 > i2) {
                    return false;
                }
                if (i1 < i2) {
                    return true;
                }
                // 相等则继续比较下一位
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}