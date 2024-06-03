package com.nowcoder.special.string.middle;

import java.util.Stack;

/**
 * NC375 去除重复字母
 * @author d3y1
 */
public class NC375{
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param str string字符串
     * @return string字符串
     */
    public String removeDuplicateLetters (String str) {
        Stack<Character> stack = new Stack<>();
        boolean[] isVisited = new boolean[26];
        int[] last = new int[26];
        char[] chars = str.toCharArray();
        int len = chars.length;

        // 字符最后位置索引
        for(int i=0; i<len; i++){
            last[chars[i]-'a'] = i;
        }

        for(int i=0; i<len; i++){
            if(isVisited[chars[i]-'a']){
                continue;
            }
            // 单调栈
            while(!stack.isEmpty() && stack.peek()>chars[i] && last[stack.peek()-'a']>i){
                isVisited[stack.pop()-'a'] = false;
            }
            stack.push(chars[i]);
            isVisited[chars[i]-'a'] = true;
        }

        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }

        return sb.reverse().toString();
    }
}