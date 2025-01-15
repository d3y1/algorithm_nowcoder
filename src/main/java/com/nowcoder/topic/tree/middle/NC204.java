package com.nowcoder.topic.tree.middle;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * NC204 二叉树的最大宽度
 * @author d3y1
 */
public class NC204 {
    private int result = 0;

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param root TreeNode类
     * @return int整型
     */
    public int widthOfBinaryTree (TreeNode root) {
        return solution1(root);
        // return solution2(root);
    }

    /**
     * 迭代: 层序遍历
     * @param root
     * @return
     */
    private int solution1(TreeNode root){
        levelOrder(root);
        return result;
    }

    /**
     * 层序遍历
     * @param root
     */
    private void levelOrder(TreeNode root){
        if(root == null){
            return;
        }

        // 双端队列
        // deque.offer(tNode) -> tNode 不能为 null
        // Deque<TreeNode> deque = new ArrayDeque<>();
        // deque.offer(tNode) -> tNode 可以为 null
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offerLast(root);

        int size;
        TreeNode tNode;
        while(!deque.isEmpty()){
            // 去掉该层左边空节点(first端)
            while(!deque.isEmpty() && deque.peekFirst()==null){
                deque.pollFirst();
            }
            // 去掉该层右边空节点(last端)
            while(!deque.isEmpty() && deque.peekLast()==null){
                deque.pollLast();
            }

            // 节点个数即为宽度
            size = deque.size();
            result = Math.max(result, size);

            // 生成下一层
            while(size-- > 0){
                tNode = deque.pollFirst();
                if(tNode != null){
                    deque.offerLast(tNode.left);
                    deque.offerLast(tNode.right);
                }else{
                    deque.offerLast(null);
                    deque.offerLast(null);
                }
            }
        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////

    private HashMap<Integer,Integer> leftIdxMap = new HashMap<>();

    /**
     * 递归: 前序遍历
     * @param root
     * @return
     */
    private int solution2(TreeNode root){
        preOrder(root, 1, 1);
        return result;
    }

    /**
     * 前序遍历
     * @param root
     * @param level
     * @param currIdx
     */
    private void preOrder(TreeNode root, int level, int currIdx){
        if(root == null){
            return;
        }

        // key(level)存在-直接取值 key(level)不存在-先put,再取值
        int leftIdx = leftIdxMap.computeIfAbsent(level, value->currIdx);
        result = Math.max(result, currIdx-leftIdx+1);

        preOrder(root.left, level+1, 2*currIdx);
        preOrder(root.right, level+1, 2*currIdx+1);
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