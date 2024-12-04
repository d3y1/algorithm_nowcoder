package com.nowcoder.topic.dfs.middle;

/**
 * NC215 将二叉搜索树改为累加树
 * @author d3y1
 */
public class NC215{
    private int preVal = 0;

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 程序入口
     *
     * @param root TreeNode类
     * @return TreeNode类
     */
    public TreeNode convertBST (TreeNode root) {
        inOrder(root);

        return root;
    }

    /**
     * 递归: 中序遍历(变体)[右中左]
     * @param root
     */
    private void inOrder(TreeNode root){
        if(root == null){
            return;
        }

        inOrder(root.right);

        root.val += preVal;
        preVal = root.val;

        inOrder(root.left);
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