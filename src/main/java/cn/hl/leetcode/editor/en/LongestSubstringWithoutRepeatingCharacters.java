package cn.hl.leetcode.editor.en;
//Given a string s, find the length of the longest substring without repeating 
//characters. 
//
// 
// Example 1: 
//
// 
//Input: s = "abcabcbb"
//Output: 3
//Explanation: The answer is "abc", with the length of 3.
// 
//
// Example 2: 
//
// 
//Input: s = "bbbbb"
//Output: 1
//Explanation: The answer is "b", with the length of 1.
// 
//
// Example 3: 
//
// 
//Input: s = "pwwkew"
//Output: 3
//Explanation: The answer is "wke", with the length of 3.
//Notice that the answer must be a substring, "pwke" is a subsequence and not a 
//substring.
// 
//
// 
// Constraints: 
//
// 
// 0 <= s.length <= 5 * 10⁴ 
// s consists of English letters, digits, symbols and spaces. 
// 
// Related Topics Hash Table String Sliding Window 👍 21125 👎 946

public class LongestSubstringWithoutRepeatingCharacters{
      public static void main(String[] args) {
           Solution solution = new LongestSubstringWithoutRepeatingCharacters().new Solution();
          int max = solution.lengthOfLongestSubstring("pwwkew");
          System.out.println(max);
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        String curr = null;
        int start = 0;
        int end = start + 1;
        while (end <= s.length()){
            curr = s.substring(start, end);
            max = end - start > max ? end - start : max;
            if(end < s.length() && curr.contains(String.valueOf(s.charAt(end)))){
                start += curr.indexOf(s.charAt(end)) + 1;
            }
            end++;
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }