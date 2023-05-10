/**
 * Copyright (C) 2020 ~ 2022 Meituan. All Rights Reserved.
 */
package cn.hl.ojpratice;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import cn.hl.leetcode.editor.en.TreeNode;

/**
 * @author:   		HuLin
 * @date:    		2022年3月25日 上午10:02:39
 * @description:    DESCRIPTION
 * @version:   		v1.0
 */
public class Test {
    /**
     * 1
     * 2 3
     * 4 5 6 7
     * @param root
     * @return
     */
    static List<Integer> inorder(TreeNode root) {
        if(root == null) return res;
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode curr;
        while(root != null || !stack.isEmpty()) {
            while(root != null) {
                stack.push(root);
                root = root.left;
            }
            
            if(!stack.isEmpty()) {
                curr = stack.pop();
                res.add(curr.val);
                root = curr.right;
            }
        }
        return res;
    }
    
    static List<Integer> res = new ArrayList<>();
    
    public static void main(String[] args) {
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n2 = new TreeNode(2, n4, n5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);
        TreeNode n3 = new TreeNode(3, n6, n7);
        TreeNode n1 = new TreeNode(1, n2, n3);
        inorder(n1);
        System.out.println(res);
    }
    
}
