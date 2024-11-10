package com.nowcoder.special.pointers.middle;

import java.util.ArrayList;

/**
 * NC405 乘积小于K的子数组数量
 * @author d3y1
 */
public class NC405{
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param nums int整型ArrayList
     * @param k int整型
     * @return int整型
     */
    public int subarrayCnt (ArrayList<Integer> nums, int k) {
        return solution(nums, k);
    }

    /**
     * 贪心+双指针
     * @param nums
     * @param k
     * @return
     */
    private int solution(ArrayList<Integer> nums, int k){
        int n = nums.size();
        int cnt = 0;
        int product;
        // 双指针
        for(int i=0; i<n; i++){
            product = 1;
            // 贪心
            for(int j=i; j<n; j++){
                product *= nums.get(j);
                if(product < k){
                    cnt++;
                }else{
                    break;
                }
            }
        }

        return cnt;
    }
}