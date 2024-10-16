package com.nowcoder.special.sort.middle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.TreeSet;

/**
 * NC389 最大差值(二)
 * @author d3y1
 */
public class NC389{
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param nums int整型一维数组
     * @return int整型
     */
    public int maxGap (ArrayList<Integer> nums) {
        return solution1(nums);
        // return solution2(nums);
        // return solution3(nums);
    }

    /**
     * 小根堆
     * @param nums
     * @return
     */
    private int solution1(ArrayList<Integer> nums){
        int max = 0;

        int n = nums.size();
        if(n < 2){
            return max;
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int num: nums){
            minHeap.offer(num);
        }

        int pre = minHeap.poll();
        int top,gap;
        while(!minHeap.isEmpty()){
            top = minHeap.poll();
            gap = top-pre;
            max = Math.max(max, gap);

            pre = top;
        }

        return max;
    }

    /**
     * TreeSet
     * @param nums
     * @return
     */
    private int solution2(ArrayList<Integer> nums){
        int max = 0;

        int n = nums.size();
        if(n < 2){
            return max;
        }

        TreeSet<Integer> treeSet = new TreeSet<>();
        for(int num: nums){
            treeSet.add(num);
        }

        int pre = treeSet.pollFirst();
        int top,gap;
        while(!treeSet.isEmpty()){
            top = treeSet.pollFirst();
            gap = top-pre;
            max = Math.max(max, gap);

            pre = top;
        }

        return max;
    }

    /**
     * 直接排序
     * @param nums
     * @return
     */
    private int solution3(ArrayList<Integer> nums){
        int max = 0;

        int n = nums.size();
        if(n < 2){
            return max;
        }

        Collections.sort(nums);

        int gap;
        for(int i=1; i<n; i++){
            gap = nums.get(i)-nums.get(i-1);
            max = Math.max(max, gap);
        }

        return max;
    }
}