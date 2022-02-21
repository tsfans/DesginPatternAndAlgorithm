package cn.hl.leetcode.editor.en;
//You have a lock in front of you with 4 circular wheels. Each wheel has 10 
//slots: '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'. The wheels can rotate 
//freely and wrap around: for example we can turn '9' to be '0', or '0' to be '9'. 
//Each move consists of turning one wheel one slot. 
//
// The lock initially starts at '0000', a string representing the state of the 4
// wheels. 
//
// You are given a list of deadends dead ends, meaning if the lock displays any 
//of these codes, the wheels of the lock will stop turning and you will be unable 
//to open it. 
//
// Given a target representing the value of the wheels that will unlock the 
//lock, return the minimum total number of turns required to open the lock, or -1 if 
//it is impossible. 
//
// 
// Example 1: 
//
// 
//Input: deadends = ["0201","0101","0102","1212","2002"], target = "0202"
//Output: 6
//Explanation: 
//A sequence of valid moves would be "0000" -> "1000" -> "1100" -> "1200" -> "12
//01" -> "1202" -> "0202".
//Note that a sequence like "0000" -> "0001" -> "0002" -> "0102" -> "0202" 
//would be invalid,
//because the wheels of the lock become stuck after the display becomes the 
//dead end "0102".
// 
//
// Example 2: 
//
// 
//Input: deadends = ["8888"], target = "0009"
//Output: 1
//Explanation: We can turn the last wheel in reverse to move from "0000" -> "000
//9".
// 
//
// Example 3: 
//
// 
//Input: deadends = ["8887","8889","8878","8898","8788","8988","7888","9888"], 
//target = "8888"
//Output: -1
//Explanation: We cannot reach the target without getting stuck.
// 
//
// 
// Constraints: 
//
// 
// 1 <= deadends.length <= 500 
// deadends[i].length == 4 
// target.length == 4 
// target will not be in the list deadends. 
// target and deadends[i] consist of digits only. 
// 
// Related Topics Array Hash Table String Breadth-First Search 👍 2578 👎 87

import java.util.*;

public class OpenTheLock752 {
    public static void main(String[] args) {
        Solution solution = new OpenTheLock752().new Solution();
        String[] deadends = new String[]{"0000"};
        int res = solution.openLock(deadends, "8888");
        System.out.println(res);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * BSF
         */
        public int openLock(String[] deadends, String target) {
            Queue<String> q = new LinkedList<>();
            // 起点
            q.add("0000");
            Set<String> visited = new HashSet<>();
            // 将死路也添加进去
            visited.addAll(Arrays.asList(deadends));
            // 起点可能也在禁止列表中
            if (visited.contains("0000")) {
                return -1;
            }
            // 防止走回头路
            visited.add("0000");
            int step = 0;
            while (!q.isEmpty()) {
                int size = q.size();
                // 当前队列所有节点往周围节点前进
                for (int i = 0; i < size; i++) {
                    String curr = q.poll();
                    // 判断是否到终点
                    if (curr.equals(target)) {
                        return step;
                    }
                    // 依次转动密码锁
                    for (int j = 0; j < 4; j++) {
                        // 每个锁可以向上或向下转
                        String up = rollUp(curr, j);
                        // 避免重复访问或禁止访问
                        if (!visited.contains(up)) {
                            q.add(up);
                            visited.add(up);
                        }
                        String down = rollDown(curr, j);
                        // 避免重复访问或禁止访问
                        if (!visited.contains(down)) {
                            q.add(down);
                            visited.add(down);
                        }
                    }
                }
                // 更新步数
                step++;
            }
            // 无解返回-1
            return -1;
        }

        private String rollDown(String curr, int j) {
            char[] c = curr.toCharArray();
            if (curr.charAt(j) == '9') {
                c[j] = '0';
            } else {
                c[j] += 1;
            }
            return String.valueOf(c);
        }

        private String rollUp(String curr, int j) {
            char[] c = curr.toCharArray();
            if (curr.charAt(j) == '0') {
                c[j] = '9';
            } else {
                c[j] -= 1;
            }
            return String.valueOf(c);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}