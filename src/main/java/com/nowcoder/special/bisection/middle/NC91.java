package com.nowcoder.special.bisection.middle;

/**
 * NC91 最长上升子序列(三)
 * @author d3y1
 */
public class NC91{
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * retrun the longest increasing subsequence
     * @param arr int整型一维数组 the array
     * @return int整型一维数组
     */
    public int[] LIS (int[] arr) {
        return solution(arr);
    }

    /**
     * 二分
     * @param arr
     * @return
     */
    private int[] solution(int[] arr){
        int n = arr.length;

        // 表示从前面到以第i个数字结尾的最长上升子序列的长度(arr[i]必须被选取)
        int[] dp = new int[n];
        // 最长上升子序列 单调增
        int[] seq = new int[n];

        // init
        seq[0] = arr[0];
        dp[0] = 1;

        // 最长上升子序列最大索引(最右索引)
        int index = 0;
        // 当前元素arr[i]插入seq位置
        int pos;
        int left,right,mid;
        for(int i=1; i<n; i++){
            if(seq[index] < arr[i]){
                index++;
                pos = index;
                seq[pos] = arr[i];
                dp[i] = pos+1;
            }
            // 二分
            else{
                left = 0;
                right = index;
                while(left <= right){
                    mid = (left+right)/2;
                    if(seq[mid] < arr[i]){
                        left = mid + 1;
                    }else{
                        right = mid - 1;
                    }
                }
                pos = left;
                seq[pos] = arr[i];
                dp[i] = pos+1;
                index = Math.max(index, pos);
            }
        }

        // 最长上升子序列的长度
        int max = index+1;
        int[] result = new int[max];
        for(int i=n-1,j=max; j>0; i--){
            if(dp[i] == j){
                result[--j] = arr[i];
            }
        }

        return result;
    }
}