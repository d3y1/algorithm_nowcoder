package com.nowcoder.special.dfs.middle;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * NC329 电话号码的字母组合
 * @author d3y1
 */
public class NC329{
    private HashMap<Character, String> numLettersMap = new HashMap<Character, String>(){{
        put('2', "ABC");
        put('3', "DEF");
        put('4', "GHI");
        put('5', "JKL");
        put('6', "MNO");
        put('7', "PQRS");
        put('8', "TUV");
        put('9', "WXYZ");
    }};

    private int LEN;
    private ArrayList<String> result = new ArrayList<>();

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 程序入口
     *
     * @param num string字符串
     * @return string字符串ArrayList
     */
    public ArrayList<String> phoneNumber (String num) {
        LEN = num.length();

        dfs(num, 0, "");

        return result;
    }

    /**
     * dfs
     * @param num
     * @param depth
     * @param word
     */
    private void dfs(String num, int depth, String word){
        if(depth == LEN){
            result.add(word.toLowerCase());
            return;
        }

        for(char ch: numLettersMap.get(num.charAt(depth)).toCharArray()){
            dfs(num, depth+1, word+ch);
        }
    }
}