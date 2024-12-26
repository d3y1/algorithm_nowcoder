package com.nowcoder.topic.stack.hard;

import java.util.Stack;

/**
 * NC240 计算器(一)
 * @author d3y1
 */
public class NC240 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 相似 -> NC241 计算器(二)   [nowcoder]
     * 相似 -> HJ50 四则运算      [nowcoder]
     *
     * 栈
     *
     * @param s string字符串
     * @return int整型
     */
    public int calculate (String s) {
        int n = s.length();
        char sign = '+';

        Stack<Integer> stack = new Stack<>();

        char chI,chJ;
        int num = 0;
        for(int i=0; i<n; i++){
            chI = s.charAt(i);

            // 数字
            if(Character.isDigit(chI)){
                num = num*10+(chI-'0');
            }

            // 括号 -> 递归
            if(chI == '('){
                // 括号深度
                int cnt = 1;
                for(int j=i+1; j<n; j++){
                    chJ = s.charAt(j);
                    if(chJ == '('){
                        cnt++;
                    }else if(chJ == ')'){
                        cnt--;
                    }
                    if(cnt == 0){
                        num = calculate(s.substring(i+1,j));
                        i = j;
                        break;
                    }
                }
            }

            // 运算
            if(!Character.isDigit(chI) || i==n-1){
                switch(sign){
                    case '+': stack.push(num); break;
                    case '-': stack.push(-num); break;
                    case '*': stack.push(stack.pop()*num); break;
                    case '/': stack.push(stack.pop()/num); break;
                    default: break;
                }
                sign = chI;
                num = 0;
            }
        }

        // 结果
        int result = 0;
        while(!stack.isEmpty()){
            result += stack.pop();
        }

        return result;
    }
}