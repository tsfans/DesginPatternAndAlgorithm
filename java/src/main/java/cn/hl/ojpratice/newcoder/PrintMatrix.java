package cn.hl.ojpratice.newcoder;

import java.util.ArrayList;

import cn.hl.ojpratice.common.Utils;

/**
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
 * 例如，如果输入如下矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 
 * 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 * 
 * @author HULIN
 */
public class PrintMatrix {

	/**
	 * int[][] matrix = new int[m][n]
	 * m = matrix.length;
	 * n = matrix[0].length
	 * m为行数,n为列数
	 * 
	 * @param matrix
	 * @return
	 */
	public ArrayList<Integer> printMatrix(int [][] matrix) {
	    int rowStart = 0;
	    int colStart = 0;
	    int rowEnd = matrix.length-1;
	    int colEnd = matrix[0].length-1;
	    ArrayList<Integer> arr = new ArrayList<Integer>();
	    while(rowEnd>=rowStart && colEnd>=colStart) {
	    	//从左到右
	    	for(int i=colStart;i<=colEnd;i++) {
	    		arr.add(matrix[rowStart][i]);
	    	}
	    	//从上到下
	    	if(rowStart!=rowEnd) {
	    		for(int i=rowStart+1;i<=rowEnd;i++) {
	    			arr.add(matrix[i][colEnd]);
	    		}
	    	}
	    	if(rowStart!=rowEnd && colStart!=colEnd) {
	    		//从右到左
	    		for(int i=colEnd-1;i>=colStart;i--) {
	    			arr.add(matrix[rowEnd][i]);
	    		}
	    		//从下到上
	    		for(int i=rowEnd-1;i>rowStart;i--) {
	    			arr.add(matrix[i][colStart]);
	    		}
	    	}
	    	rowStart++;
	    	colStart++;
	    	rowEnd--;
	    	colEnd--;
	    }
		
		return arr;
    }
	public static void main(String[] args) {
		int[][] matrix = {{1,2,3,4,5}};
		PrintMatrix m = new PrintMatrix();
		ArrayList<Integer> arr = m.printMatrix(matrix);
		Utils.printArray(arr);
	}
}
