package com.nowcoder.special.string.hard;

/**
 * NC284 表示数值的字符串
 * @author d3y1
 */
public class NC284{
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param str string字符串
     * @return bool布尔型
     */
    public boolean isNumeric (String str) {
        // \d = 数字
        // *  = 0次或者多次 = {0, }
        // +  = 1次或者多次 = {1, }
        // ?  = 0次或者1次  = {0,1}
        // \\ = 表示一个\
        String regex = "(\\s)*[+-]?((\\d+(\\.(\\d+)?)?)|(\\.\\d+))([Ee][+-]?\\d+)?(\\s)*";

        return str.matches(regex);
    }
}