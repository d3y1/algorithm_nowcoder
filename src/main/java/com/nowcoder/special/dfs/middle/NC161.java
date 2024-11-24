package com.nowcoder.special.dfs.middle;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * NC161 二叉树的中序遍历
 * @author d3y1
 */
public class NC161{
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 程序入口
     *
     * @param root TreeNode类
     * @return int整型一维数组
     */
    public int[] inorderTraversal (TreeNode root) {
        return solution1(root);
    }

    /**
     * dfs
     * @param root
     * @return
     */
    private int[] solution1(TreeNode root){
        List<Integer> list = new ArrayList<>();

        inorder(list, root);

        int[] result = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            result[i] = list.get(i);
        }

        return result;
    }

    /**
     * 递归
     * @param list
     * @param root
     */
    private void inorder(List<Integer> list, TreeNode root){
        // 空节点
        if(root == null){
            return;
        }

        // 左子树
        inorder(list, root.left);
        // 根结点
        list.add(root.val);
        // 右子树
        inorder(list, root.right);
    }

    /**
     * 非递归: 栈
     * @param root
     * @return
     */
    private int[] solution2(TreeNode root){
        List<Integer> list = new ArrayList<>();
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

        int[] result = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            result[i] = list.get(i);
        }

        return result;
    }

    private class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}