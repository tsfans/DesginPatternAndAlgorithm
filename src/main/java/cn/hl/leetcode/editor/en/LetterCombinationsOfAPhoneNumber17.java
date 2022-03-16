package cn.hl.leetcode.editor.en;
//Given a string containing digits from 2-9 inclusive, return all possible 
//letter combinations that the number could represent. Return the answer in any order. 
//
//
// A mapping of digit to letters (just like on the telephone buttons) is given 
//below. Note that 1 does not map to any letters. 
//
// 
//
// 
// Example 1: 
//
// 
//Input: digits = "23"
//Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
// 
//
// Example 2: 
//
// 
//Input: digits = ""
//Output: []
// 
//
// Example 3: 
//
// 
//Input: digits = "2"
//Output: ["a","b","c"]
// 
//
// 
// Constraints: 
//
// 
// 0 <= digits.length <= 4 
// digits[i] is a digit in the range ['2', '9']. 
// 
// Related Topics Hash Table String Backtracking 👍 9209 👎 641

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsOfAPhoneNumber17 {
    public static void main(String[] args) {
        Solution solution = new LetterCombinationsOfAPhoneNumber17().new Solution();
        String digits = "23";
        List<String> res = solution.letterCombinations(digits);
        System.out.println(res);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        String[] letter = new String[]{"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> res;

        public List<String> letterCombinations(String digits) {
            res = new ArrayList<>();
            if (digits == null || digits.length() == 0) {
                return res;
            }
            backtrace(new StringBuilder(), digits, 0);
            return res;
        }

        /**
         * 回溯遍历,TC=N^k,SC=N*k
         */
        void backtrace(StringBuilder sb, String digits, int start) {
            // 结束条件
            if (sb.length() == digits.length()) {
                // 路径长度等于可选数字长度
                res.add(sb.toString());
                return;
            }
            // 遍历所有选择
            for (int i = start; i < digits.length(); i++) {
                int num = Integer.parseInt(String.valueOf(digits.charAt(i)));
                String curr = letter[num - 2];
                for (char c : curr.toCharArray()) {
                    // 做选择
                    sb.append(c);
                    // 继续遍历下一个数字
                    backtrace(sb, digits, i + 1);
                    // 撤销选择
                    sb.deleteCharAt(sb.length() - 1);
                }
            }

        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}