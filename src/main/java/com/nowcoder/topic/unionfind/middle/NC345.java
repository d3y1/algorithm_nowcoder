package com.nowcoder.topic.unionfind.middle;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * NC345 城市群数量
 * @author d3y1
 */
public class NC345 {
    private int result = 0;
    private int N;
    private boolean[] isVisited;
    private HashSet<Integer>[] adj;

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param m int整型ArrayList<ArrayList<>>
     * @return int整型
     */
    public int citys (ArrayList<ArrayList<Integer>> m) {
        // return solution1(m);
        // return solution2(m);
        return solution3(m);
    }

    /**
     * dfs
     * @param m
     * @return
     */
    private int solution1(ArrayList<ArrayList<Integer>> m){
        N = m.size();
        isVisited = new boolean[N];
        adj = new HashSet[N];
        for(int i = 0; i < N; i++){
            adj[i] = new HashSet<>();
        }

        for(int i = 0; i < N; i++){
            for(int j = i+1; j < N; j++){
                if(m.get(i).get(j) == 1){
                    adj[i].add(j);
                    adj[j].add(i);
                }
            }
        }

        for(int i = 0; i < N; i++){
            if(!isVisited[i]){
                dfs(i);
                result++;
            }
        }

        return result;
    }

    /**
     * 递归
     * @param city
     */
    private void dfs(int city){
        if(isVisited[city]){
            return;
        }

        isVisited[city] = true;

        for(int adjCity: adj[city]){
            dfs(adjCity);
        }
    }

    /**
     * bfs
     * @param m
     * @return
     */
    private int solution2(ArrayList<ArrayList<Integer>> m){
        N = m.size();
        isVisited = new boolean[N];
        adj = new HashSet[N];
        for(int i = 0; i < N; i++){
            adj[i] = new HashSet<>();
        }

        for(int i = 0; i < N; i++){
            for(int j = i+1; j < N; j++){
                if(m.get(i).get(j) == 1){
                    adj[i].add(j);
                    adj[j].add(i);
                }
            }
        }

        for(int i = 0; i < N; i++){
            if(!isVisited[i]){
                bfs(i);
                result++;
            }
        }

        return result;
    }

    /**
     * 非递归: 队列
     * @param city
     */
    private void bfs(int city){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(city);

        int currCity;
        while(!queue.isEmpty()){
            currCity = queue.poll();
            isVisited[currCity] = true;
            for(int adjCity: adj[currCity]){
                if(!isVisited[adjCity]){
                    queue.offer(adjCity);
                }
            }
        }
    }

    /**
     * 并查集
     * @param m
     * @return
     */
    private int solution3(ArrayList<ArrayList<Integer>> m){
        int n = m.size();
        UnionFind uf = new UnionFind(n);
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                if(m.get(i).get(j) == 1){
                    uf.union(i,j);
                }
            }
        }

        return uf.connects();
    }

    /**
     * 并查集类
     */
    private class UnionFind {
        int connect;
        int[] parent;

        UnionFind(int n){
            this.connect = n;
            parent = new int[n];
            for(int i=0; i<n; i++){
                parent[i] = i;
            }
        }

        int find(int x){
            while(x != parent[x]){
                // parent[x] = parent[parent[x]];
                x = parent[x];
            }
            return x;
        }

        void union(int p, int q){
            int rootP = find(p);
            int rootQ = find(q);
            if(rootP != rootQ){
                parent[rootP] = rootQ;
                this.connect--;
            }
        }

        int connects(){
            return this.connect;
        }
    }
}