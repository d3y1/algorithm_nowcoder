package com.nowcoder.topic.hash.hard;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * NC93 设计LRU缓存结构
 * @author d3y1
 */
public class NC93 {
    private Deque<Integer> keyQueue = new LinkedList<>();
    private HashMap<Integer,Integer> kvMap = new HashMap<>();
    private int capacity;

    public NC93(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        // 存在
        if(kvMap.containsKey(key)){
            keyQueue.remove(key);
            keyQueue.offerFirst(key);
            return kvMap.get(key);
        }

        // 不存在
        return -1;
    }

    public void set(int key, int value) {
        // 存在
        if(kvMap.containsKey(key)){
            keyQueue.remove(key);
        }
        // 不存在
        else{
            // LRU key
            int rmKey;
            if(keyQueue.size() >= capacity){
                rmKey = keyQueue.peekLast();
                kvMap.remove(rmKey);
                keyQueue.remove(rmKey);
            }
        }
        keyQueue.offerFirst(key);
        kvMap.put(key, value);
    }
}