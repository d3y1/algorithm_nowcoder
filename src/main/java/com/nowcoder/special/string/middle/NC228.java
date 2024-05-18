package com.nowcoder.special.string.middle;

/**
 * NC228 判断子序列
 * @author d3y1
 */
public class NC228{
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param S string字符串
     * @param T string字符串
     * @return bool布尔型
     */
    public boolean isSubsequence (String S, String T) {
        int sLen = S.length();
        int tLen = T.length();
        if(sLen > tLen){
            return false;
        }

        // 双指针
        int i = 0;
        int j = 0;
        while(i<sLen && j<tLen){
            if(S.charAt(i) == T.charAt(j)){
                i++;
                j++;
            }else{
                j++;
            }
        }

        return i==sLen;
    }
}