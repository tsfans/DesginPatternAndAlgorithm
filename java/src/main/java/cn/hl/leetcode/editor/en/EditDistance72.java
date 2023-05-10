package cn.hl.leetcode.editor.en;
//Given two strings word1 and word2, return the minimum number of operations 
//required to convert word1 to word2. 
//
// You have the following three operations permitted on a word: 
//
// 
// Insert a character 
// Delete a character 
// Replace a character 
// 
//
// 
// Example 1: 
//
// 
//Input: word1 = "horse", word2 = "ros"
//Output: 3
//Explanation: 
//horse -> rorse (replace 'h' with 'r')
//rorse -> rose (remove 'r')
//rose -> ros (remove 'e')
// 
//
// Example 2: 
//
// 
//Input: word1 = "intention", word2 = "execution"
//Output: 5
//Explanation: 
//intention -> inention (remove 't')
//inention -> enention (replace 'i' with 'e')
//enention -> exention (replace 'n' with 'x')
//exention -> exection (replace 'n' with 'c')
//exection -> execution (insert 'u')
// 
//
// 
// Constraints: 
//
// 
// 0 <= word1.length, word2.length <= 500 
// word1 and word2 consist of lowercase English letters. 
// 
// Related Topics String Dynamic Programming 👍 7730 👎 90

public class EditDistance72 {
    public static void main(String[] args) {
        Solution solution = new EditDistance72().new Solution();
        String s = "leetcode";
        String t = "coats";
        int res = solution.minSteps(s, t);
        System.out.println(res);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minSteps(String s, String t) {
            int ls = s.length();
            int lt = t.length();
            int[] st = new int[128];
            for (int i = 0; i < ls; i++) {
                st[s.charAt(i)]++;
            }
            int[] tt = new int[128];
            for (int i = 0; i < lt; i++) {
                tt[t.charAt(i)]++;
            }
            int step = 0;
            for (int i = 0; i < 128; i++) {
                step += Math.abs(st[i] - tt[i]);
            }
            // for(int i = 0; i < lt; i++){
            //     if(st[t.charAt(i)] == tt[t.charAt(i)]) continue;
            //     step += Math.abs(st[t.charAt(i)] - tt[t.charAt(i)]);
            // }
            return step;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}