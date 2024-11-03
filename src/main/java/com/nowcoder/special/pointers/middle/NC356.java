package com.nowcoder.special.pointers.middle;

import java.util.HashMap;

/**
 * NC356 至多包含K种字符的子串
 * @author d3y1
 */
public class NC356{
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param s string字符串
     * @param k int整型
     * @return int整型
     */
    public int longestSubstring (String s, int k) {
        return solution(s,k);
    }

    /**
     * 哈希+双指针
     * @param s
     * @param k
     * @return
     */
    private int solution(String s, int k){
        int n = s.length();
        if(n <= k){
            return n;
        }

        // 哈希
        HashMap<Character, Integer> map = new HashMap<>();

        int result = 0;
        char chL,chR;
        // 双指针 毛毛虫
        for(int i=0,j=0; j<n; j++){
            chR = s.charAt(j);
            map.put(chR, map.getOrDefault(chR, 0)+1);
            while(map.size() > k){
                chL = s.charAt(i);
                map.put(chL, map.get(chL)-1);
                if(map.get(chL) == 0){
                    map.remove(chL);
                }
                i++;
            }
            result = Math.max(result, j-i+1);
        }

        return result;
    }
}