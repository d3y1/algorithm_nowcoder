package com.nowcoder.special.pointers.middle;

import java.util.*;

/**
 * NC220 重复的DNA序列
 * @author d3y1
 */
public class NC220{
    // 滑动窗口大小 gap
    private final int L = 10;
    // 映射成二进制
    private HashMap<Character,Integer> binMap = new HashMap<Character,Integer>(){{
        put('A', 0);
        put('C', 1);
        put('G', 2);
        put('T', 3);
    }};

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param DNA string字符串 1
     * @return string字符串一维数组
     */
    public String[] repeatedDNA (String DNA) {
        // return solution1(DNA);
        // return solution2(DNA);
        // return solution3(DNA);
        // return solution33(DNA);
        return solution333(DNA);
        // return solution4(DNA);
    }

    /**
     * 滑动窗口: HashSet
     * @param DNA
     * @return
     */
    private String[] solution1(String DNA){
        List<String> results = new ArrayList<>();
        HashSet<String> subSet = new HashSet<>();

        int len = DNA.length();
        String sub;
        for(int i=0; i+L<=len; i++){
            sub = DNA.substring(i, i+L);
            // 当前sub: 第一次找到 且 今后还会找到
            if(!subSet.contains(sub) && DNA.substring(i+1).contains(sub)){
                subSet.add(sub);
                results.add(sub);
            }
        }

        return results.toArray(new String[results.size()]);
    }

    /**
     * 滑动窗口: HashSet + HashMap
     * @param DNA
     * @return
     */
    private String[] solution2(String DNA){
        List<SubDNA> resultList = new ArrayList<>();
        HashSet<String> subSet = new HashSet<>();
        HashSet<String> foundSet = new HashSet<>();
        HashMap<String, Integer> map = new HashMap<>();

        int len = DNA.length();
        String sub;
        for(int i=0; i+L<=len; i++){
            sub = DNA.substring(i, i+L);
            if(!subSet.contains(sub)){
                subSet.add(sub);
                if(!map.containsKey(sub)){
                    map.put(sub, i);
                }
            }else{
                if(!foundSet.contains(sub)){
                    foundSet.add(sub);
                    resultList.add(new SubDNA(sub, map.get(sub)));
                }
            }
        }

        // 序号升序
        Collections.sort(resultList, new Comparator<SubDNA>(){
            @Override
            public int compare(SubDNA o1, SubDNA o2){
                return o1.firstIdx-o2.firstIdx;
            }
        });

        String[] results = new String[resultList.size()];
        for(int i=0; i<resultList.size(); i++){
            results[i] = resultList.get(i).sub;
        }

        return results;
    }

    /**
     * DNA子串
     */
    private class SubDNA {
        String sub;
        int firstIdx;

        public SubDNA(String sub, int firstIdx){
            this.sub = sub;
            this.firstIdx = firstIdx;
        }
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * 哈希 + 双指针(滑动窗口)
     * @param DNA
     * @return
     */
    private String[] solution3(String DNA){
        int n = DNA.length();

        // 哈希
        HashMap<String, Integer> map = new HashMap<>();
        HashSet<String> resultSet = new HashSet<>();
        // PriorityQueue<SubDNA> minHeap = new PriorityQueue<>((o1,o2) -> (o1.firstIdx-o2.firstIdx));
        PriorityQueue<SubDNA> minHeap = new PriorityQueue<>(new Comparator<SubDNA>(){
            @Override
            public int compare(SubDNA o1, SubDNA o2){
                return o1.firstIdx-o2.firstIdx;
            }
        });

        String target;
        // 双指针(滑动窗口)
        for(int i=0,j=i+L; j<=n; i++,j++){
            target = DNA.substring(i,j);
            if(map.containsKey(target)){
                if(!resultSet.contains(target)){
                    resultSet.add(target);
                    minHeap.offer(new SubDNA(target,map.get(target)));
                }
            }else{
                map.put(target,i);
            }
        }

        int size = minHeap.size();
        String[] result = new String[size];
        int i = 0;
        while(!minHeap.isEmpty()){
            result[i++] = minHeap.poll().sub;
        }

        return result;
    }

    /**
     * 哈希 + 双指针(滑动窗口)
     * @param DNA
     * @return
     */
    private String[] solution33(String DNA){
        int n = DNA.length();

        // 哈希
        HashMap<String, Integer> firstMap = new HashMap<>();
        HashMap<String, Integer> cntMap = new HashMap<>();
        // PriorityQueue<SubDNA> minHeap = new PriorityQueue<>(Comparator.comparingInt(o -> o.firstIdx));
        PriorityQueue<SubDNA> minHeap = new PriorityQueue<>(new Comparator<SubDNA>(){
            @Override
            public int compare(SubDNA o1, SubDNA o2){
                return o1.firstIdx-o2.firstIdx;
            }
        });

        String target;
        // 双指针(滑动窗口)
        for(int i=0,j=i+L; j<=n; i++,j++){
            target = DNA.substring(i,j);
            if(firstMap.containsKey(target)){
                if(cntMap.get(target) == 1){
                    cntMap.put(target,2);
                    minHeap.offer(new SubDNA(target,firstMap.get(target)));
                }
            }else{
                firstMap.put(target,i);
                cntMap.put(target,1);
            }
        }

        int size = minHeap.size();
        String[] result = new String[size];
        int i = 0;
        while(!minHeap.isEmpty()){
            result[i++] = minHeap.poll().sub;
        }

        return result;
    }

    /**
     * 哈希 + 双指针(滑动窗口) + 位运算
     *
     * 由于DNA中只含有4种字符, 可以将每个字符用2个比特表示, 即:
     * A 表示为二进制 00
     * C 表示为二进制 01
     * G 表示为二进制 10
     * T 表示为二进制 11
     *
     * 如此, 一个长为10的字符串就可以用20个比特表示, 而一个int整数有32个比特, 足够容纳该字符串
     * 因此可以将DNA的每个长为10的子串用一个int整数表示(只用低20位)
     *
     * 注意到上述字符串到整数的映射是一一映射, 每个整数都对应着一个唯一的字符串
     * 因此可以将上面的哈希表改为存储每个长为10的子串的整数表示
     *
     * 如果对每个长为10的子串都单独计算其整数表示, 那么时间复杂度为O(NL)
     * 为了优化时间复杂度, 我们可以用一个大小固定为10的滑动窗口来计算子串的整数表示
     * 设当前滑动窗口对应的整数表示为target, 当要计算下一个子串时,
     * 就将滑动窗口向右移动一位, 此时会有一个新的字符进入窗口, 以及窗口最左边的字符离开窗口,
     * 这些操作对应的位运算, 按计算顺序表示如下:
     *
     * 滑动窗口向右移动一位: target = target<<2, 由于每个字符用2个比特表示, 所以要左移2位(原来的低位变成了高位)
     * 一个新的字符ch进入窗口: target = target|bin[ch], 这里bin[ch]为字符ch的对应二进制
     * 窗口最左边的字符离开窗口: target = target&((1<<20)-1), 由于我们只考虑target的低20位比特, 需要将其余位置零, 即与上(1<<20)-1
     * 将这三步合并, 就可以用O(1)的时间计算出下一个子串的整数表示, 即 target = ((target<<2)|bin[ch]) & ((1<<20)-1)
     *
     * @param DNA
     * @return
     */
    private String[] solution333(String DNA){
        int n = DNA.length();
        if(n <= L){
            return new String[0];
        }

        // 哈希
        HashMap<Integer, Integer> firstMap = new HashMap<>();
        HashMap<Integer, Integer> cntMap = new HashMap<>();
        // PriorityQueue<SubDNA> minHeap = new PriorityQueue<>(Comparator.comparingInt(o -> o.firstIdx));
        PriorityQueue<SubDNA> minHeap = new PriorityQueue<>(new Comparator<SubDNA>(){
            @Override
            public int compare(SubDNA o1, SubDNA o2){
                return o1.firstIdx-o2.firstIdx;
            }
        });

        String sub;
        int target = 0;
        for(int i=0; i<L-1; i++) {
            target = (target<<2) | binMap.get(DNA.charAt(i));
        }
        // 双指针(滑动窗口)
        for(int i=0,j=i+L; j<=n; i++,j++){
            sub = DNA.substring(i,j);
            // 位运算
            target = ((target<<2) | binMap.get(DNA.charAt(j-1))) & ((1<<(L*2))-1);
            if(firstMap.containsKey(target)){
                if(cntMap.get(target) == 1){
                    cntMap.put(target,2);
                    minHeap.offer(new SubDNA(sub,firstMap.get(target)));
                }
            }else{
                firstMap.put(target,i);
                cntMap.put(target,1);
            }
        }

        int size = minHeap.size();
        String[] result = new String[size];
        int i = 0;
        while(!minHeap.isEmpty()){
            result[i++] = minHeap.poll().sub;
        }

        return result;
    }

    /**
     * 哈希 + 双指针(滑动窗口) + 字符串
     * @param DNA
     * @return
     */
    private String[] solution4(String DNA){
        int n = DNA.length();

        // 哈希
        HashSet<String> resultSet = new HashSet<>();
        ArrayList<String> list = new ArrayList<>();

        String target;
        int lastIdx;
        // 双指针(滑动窗口)
        for(int i=0,j=i+L; j<=n; i++,j++){
            target = DNA.substring(i,j);
            if(!resultSet.contains(target)){
                // 字符串
                lastIdx = DNA.lastIndexOf(target);
                if(i < lastIdx){
                    resultSet.add(target);
                    list.add(target);
                }
            }
        }

        int size = list.size();
        String[] result = new String[size];
        list.toArray(result);

        return result;
    }
}