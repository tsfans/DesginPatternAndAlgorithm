package cn.hl.ojpratice.newcoder;

public class FindNumberInArray {

	/**
	 * 
	 * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
	 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
	 * 
	 * @date 2017年12月26日下午4:52:57
	 * @param target
	 * @param array
	 * @return
	 */
	static boolean find(int target, int[][] array) {
		boolean flag = false;
        int cols = 0;
        int rows = array[0].length-1;
        while(cols<array.length && rows>=0) {
        	if(array[cols][rows]>target) {
        		rows--;
        		continue;
        	}else if(array[cols][rows]<target) {
        		cols++;
        		continue;
        	}else {
        		flag = true;
        		break;
        	}
        }
		return flag;
	}
	public static void main(String[] args) {
		int target = 29;
		int[][] array = {{1,2,3,4,5},{2,3,4,5,6},{4,5,6,7,8}};
		System.out.println(find(target,array));
	}
}
