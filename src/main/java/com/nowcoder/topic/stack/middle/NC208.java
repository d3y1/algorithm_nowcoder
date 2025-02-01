package com.nowcoder.topic.stack.middle;

import java.util.Stack;

/**
 * NC208 每日温度
 * @author d3y1
 */
public class NC208 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 每日温度
     * @param dailyTemperatures int整型一维数组
     * @return int整型一维数组
     */
    public int[] temperatures (int[] dailyTemperatures) {
        int n = dailyTemperatures.length;
        int[] results = new int[n];

        Stack<Integer> stack = new Stack<>();
        // Deque<Integer> stack = new ArrayDeque<>();
        // Deque<Integer> stack = new LinkedList<>();

        for(int i=n-1; i>=0; i--){
            // 单调栈 单调减(从右向左遍历)
            while(!stack.isEmpty() && dailyTemperatures[stack.peek()]<=dailyTemperatures[i]){
                stack.pop();
            }
            // if(stack.isEmpty()){
            //     results[i] = 0;
            // }else{
            //     results[i] = stack.peek()-i;
            // }
            results[i] = stack.isEmpty() ? 0 : stack.peek()-i;
            stack.push(i);
        }

        return results;
    }
}