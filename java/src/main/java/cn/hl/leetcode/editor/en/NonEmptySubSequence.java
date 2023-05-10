package cn.hl.leetcode.editor.en;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 求1-n的所有非空子序列
 * 2^n - 1
 */
public class NonEmptySubSequence {

	public static void main(String[] args) {
		NonEmptySubSequence.Solution solution = new NonEmptySubSequence().new Solution();
		List<List<Integer>> res = solution.subSequence(3);
		System.out.println(res);
		System.out.println(res.size());
	}

	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {

		List<List<Integer>> res = new ArrayList<>();

		List<List<Integer>> subSequence(int n) {
			LinkedList<Integer> backtrace = new LinkedList<>();
			backtrace(backtrace, 1, n);
			return res;
		}

		void backtrace(LinkedList<Integer> backtrace, int start, int n) {
			if (start > n) {
				if (backtrace.isEmpty()) {
					return;
				}
				List<Integer> list = new ArrayList<>(backtrace);
				res.add(list);
				return;
			}
			// 对于每个数字都有两种选择
			// 1.不选当前数字,后续也就不需要撤销
			backtrace(backtrace, start + 1, n);

			// 2.选当前数字
			backtrace.add(start);
			// 继续下一个选择
			backtrace(backtrace, start + 1, n);
			// 撤销当前选择
			backtrace.removeLast();
		}

	}

	//leetcode submit region end(Prohibit modification and deletion)
}
