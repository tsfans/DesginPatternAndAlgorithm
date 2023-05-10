package cn.hl.ojpratice.newcoder;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import cn.hl.ojpratice.common.TreeNode;

/**
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 *
 */
public class FromTopToBottomTreePrinter {

  public ArrayList<Integer> fromTopToBottom(TreeNode root) {
    if(root==null) return null;
    Queue<TreeNode> q  = new LinkedList<>();
    q.add(root);
    ArrayList<Integer> arr = new ArrayList<>();
    while(!q.isEmpty()) {
      TreeNode node = q.poll();
      if(node == null) continue;
      arr.add(node.val);
      q.add(node.left);
      q.add(node.right);
    }
    
    return arr;
  }
  
  public static void main(String[] args) {
    TreeNode n8 = new TreeNode(8);
    TreeNode n9 = new TreeNode(9);
    TreeNode n10 = new TreeNode(10);
    TreeNode n6 = new TreeNode(6);
    TreeNode n7 = new TreeNode(7);
    TreeNode n5 = new TreeNode(n10,5,null);
    TreeNode n4 = new TreeNode(n8,4,n9);
    TreeNode n3 = new TreeNode(n6,3,n7);
    TreeNode n2 = new TreeNode(n4,2,n5);
    TreeNode n1 = new TreeNode(n2,1,n3);
    for(int i :new FromTopToBottomTreePrinter().fromTopToBottom(n1)){
      System.out.println(i);
    }
  }
}
