package com.nowcoder.topic.bfs.middle;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * NC80 把二叉树打印成多行
 * @author d3y1
 */
public class NC80{
    private ArrayList<ArrayList<Integer>> result = new ArrayList<>();

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 程序入口
     *
     * @param pRoot TreeNode类
     * @return int整型ArrayList<ArrayList<>>
     */
    public ArrayList<ArrayList<Integer>> Print (TreeNode pRoot) {
        levelOrder(pRoot);

        return result;
    }

    /**
     * 层序遍历: 队列
     * @param pRoot
     */
    private void levelOrder(TreeNode pRoot){
        if(pRoot == null){
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(pRoot);

        int size;
        TreeNode currNode;
        ArrayList<Integer> levelList;
        while(!queue.isEmpty()){
            size = queue.size();
            levelList = new ArrayList<>();
            while(size-- > 0){
                currNode = queue.poll();
                levelList.add(currNode.val);
                if(currNode.left != null){
                    queue.offer(currNode.left);
                }
                if(currNode.right != null){
                    queue.offer(currNode.right);
                }
            }
            result.add(levelList);
        }
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