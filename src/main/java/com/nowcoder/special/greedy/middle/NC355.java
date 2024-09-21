package com.nowcoder.special.greedy.middle;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * NC355 划分字母区间
 * @author d3y1
 */
public class NC355{
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param s string字符串
     * @return int整型ArrayList
     */
    public ArrayList<Integer> splitString (String s) {
//        return solution3(s);
        return solution4(s);
    }

    /**
     * 贪心+双指针+字符串
     * @param s
     * @return
     */
    private ArrayList<Integer> solution3(String s){
        int n = s.length();

        ArrayList<Integer> result = new ArrayList<>();

        // 双指针
        int left = 0;
        int right = 0;
        int pre = -1;
        while(left < n){
            // 贪心
            right = Math.max(right, s.lastIndexOf(s.charAt(left)));
            if(left == right){
                result.add(right-pre);
                pre = right;
            }
            left++;
        }

        return result;
    }

    /**
     * 贪心+双指针+哈希
     * @param s
     * @return
     */
    private ArrayList<Integer> solution4(String s){
        int n = s.length();

        // 哈希 字符:最右索引
        HashMap<Character, Integer> rightIndexMap = new HashMap<>();
        char ch;
        for(int i=n-1; i>=0; i--){
            ch = s.charAt(i);
            if(!rightIndexMap.keySet().contains(ch)){
                rightIndexMap.put(ch, i);
            }
        }

        ArrayList<Integer> result = new ArrayList<>();

        // 双指针
        int left = 0;
        int right = 0;
        for(int i=0; i<n; i++){
            ch = s.charAt(i);
            // 贪心
            right = Math.max(right, rightIndexMap.get(ch));
            if(i == right){
                result.add(right-left+1);
                left = i+1;
            }
        }

        return result;
    }
}