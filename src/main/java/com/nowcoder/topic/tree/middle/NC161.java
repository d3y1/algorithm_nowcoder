package com.nowcoder.topic.tree.middle;

import java.util.ArrayList;
import java.util.Stack;

/**
 * NC161 二叉树的中序遍历
 * @author d3y1
 */
public class NC161 {
    private ArrayList<Integer> list = new ArrayList<>();

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param root TreeNode类
     * @return int整型一维数组
     */
    public int[] inorderTraversal (TreeNode root) {
        // return solution1(root);
        return solution2(root);
    }

    /**
     * 递归
     * @param root
     * @return
     */
    private int[] solution1(TreeNode root){
        inOrder(root);

        int[] results = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            results[i] = list.get(i);
        }

        return results;
    }

    /**
     * 中序遍历(dfs)
     * @param root
     */
    private void inOrder(TreeNode root){
        if(root == null){
            return;
        }

        inOrder(root.left);
        list.add(root.val);
        inOrder(root.right);
    }

    /**
     * 迭代(栈)
     * @param root
     * @return
     */
    private int[] solution2(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();

        TreeNode curr;
        while(root!=null || !stack.isEmpty()){
            // 最左边
            while(root != null){
                stack.push(root);
                root = root.left;
            }

            curr = stack.pop();
            list.add(curr.val);

            root = curr.right;
        }

        int[] results = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            results[i] = list.get(i);
        }

        return results;
    }

    private class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
        public TreeNode(int val){
            this.val = val;
        }
    }
}