package cn.hl.leetcode.editor.en;
//Given an input string (s) and a pattern (p), implement wildcard pattern 
//matching with support for '?' and '*' where: 
//
// 
// '?' Matches any single character. 
// '*' Matches any sequence of characters (including the empty sequence). 
// 
//
// The matching should cover the entire input string (not partial). 
//
// 
// Example 1: 
//
// 
//Input: s = "aa", p = "a"
//Output: false
//Explanation: "a" does not match the entire string "aa".
// 
//
// Example 2: 
//
// 
//Input: s = "aa", p = "*"
//Output: true
//Explanation: '*' matches any sequence.
// 
//
// Example 3: 
//
// 
//Input: s = "cb", p = "?a"
//Output: false
//Explanation: '?' matches 'c', but the second letter is 'a', which does not 
//match 'b'.
// 
//
// 
// Constraints: 
//
// 
// 0 <= s.length, p.length <= 2000 
// s contains only lowercase English letters. 
// p contains only lowercase English letters, '?' or '*'. 
// 
// Related Topics String Dynamic Programming Greedy Recursion 👍 4341 👎 194

import java.util.LinkedList;

public class WildcardMatching44 {
    public static void main(String[] args) {
        Solution solution = new WildcardMatching44().new Solution();
        int[] nums = new int[]{99, 95, 68, 24, 18};
        int res = solution.maximumTop(nums, 5);
        System.out.println(res);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int maximumTop(int[] nums, int k) {
            if (k == 0) {
                return nums[0];
            }
            return maxTop(nums, k, 0);
        }

        LinkedList<Integer> removed = new LinkedList<>();

        int maxTop(int[] nums, int k, int top) {
            if (top >= nums.length) {
                return -1;
            }
            if (k == 0) {
                return top >= nums.length ? -1 : nums[top];
            }
            if (removed.isEmpty()) {
                // 只能remove top
                removed.add(nums[top]);
                return maxTop(nums, k - 1, top + 1);
            }
            int max = -1;
            // 1.remove top
            removed.add(nums[top++]);
            max = Math.max(max, maxTop(nums, k - 1, top));
            // 撤销选择
            removed.removeLast();
            top--;

            // 2.push max(removed)
            int i = max();
            int maxRemoved = removed.remove(i);
            nums[--top] = maxRemoved;
            max = Math.max(max, maxTop(nums, k - 1, top));
            // 撤销选择
            removed.add(maxRemoved);
            top++;
            return max;
        }

        int max() {
            int max = -1;
            int index = 0;
            for (int i = 0; i < removed.size(); i++) {
                int curr = removed.get(i);
                if (curr > max) {
                    max = curr;
                    index = i;
                }
            }
            return index;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}