package cn.hl.leetcode.editor.en;
//Given n pairs of parentheses, write a function to generate all combinations 
//of well-formed parentheses. 
//
// 
// Example 1: 
// Input: n = 3
//Output: ["((()))","(()())","(())()","()(())","()()()"]
// Example 2: 
// Input: n = 1
//Output: ["()"]
// 
// 
// Constraints: 
//
// 
// 1 <= n <= 8 
// 
// Related Topics String Dynamic Programming Backtracking 👍 11696 👎 460

import java.util.LinkedList;
import java.util.List;

public class GenerateParentheses22 {
    public static void main(String[] args) {
        Solution solution = new GenerateParentheses22().new Solution();
        List<String> res = solution.generateParenthesis(3);
        System.out.println(res);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> generateParenthesis(int n) {
            if (n == 0) {
                return null;
            }
            LinkedList<String> res = new LinkedList<>();
            backtracking(n, n, "", res);
            return res;
        }

        /**
         * left,right各为n个
         * 对于一个「合法」的括号字符串组合 p，必然对于任何 0 <= i < len(p) 都有：子串 p[0..i] 中左括号的数量都大于或等于右括号      * 的数量。
         */
        void backtracking(int left, int right, String track, LinkedList<String> res) {
            // 右比左少不合法
            if (right < left) {
                return;
            }
            // 小于0也不合法
            if (left < 0 || right < 0) {
                return;
            }
            // 左右括号同时用尽时找到结果
            if (left == 0 && right == 0) {
                res.add(track);
                return;
            }

            // 做选择: 尝试添加左括号
            track = track + "(";
            backtracking(left - 1, right, track, res);
            // 撤销选择
            track = track.substring(0, track.length() - 1);

            // 做选择: 尝试添加右括号
            track = track + ")";
            backtracking(left, right - 1, track, res);
            // 撤销选择
            track = track.substring(0, track.length() - 1);
        }

    }

//leetcode submit region end(Prohibit modification and deletion)

}