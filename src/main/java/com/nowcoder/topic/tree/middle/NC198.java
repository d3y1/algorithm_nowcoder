package com.nowcoder.topic.tree.middle;

import java.util.LinkedList;
import java.util.Queue;

/**
 * NC198 判断是不是完全二叉树
 * @author d3y1
 */
public class NC198 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param root TreeNode类
     * @return bool布尔型
     */
    public boolean isCompleteTree (TreeNode root) {
        return levelOrder(root);
    }

    /**
     * 层序遍历
     * @param root
     * @return
     */
    private boolean levelOrder(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        TreeNode tNode;
        while(queue.peek() != null){
            tNode = queue.poll();
            queue.offer(tNode.left);
            queue.offer(tNode.right);
        }

        while(!queue.isEmpty() && queue.peek()==null){
            queue.poll();
        }

        return queue.isEmpty();
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