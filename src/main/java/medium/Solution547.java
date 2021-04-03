package medium;

import java.util.ArrayList;
import java.util.List;

public class Solution547 {

//    public int findCircleNum(int[][] isConnected) {
//        int N = isConnected.length;
//        boolean [] marked = new boolean[N];
//        int count = 0;
//        for(int j = 0;j < N;j++){
//            if(!marked[j]){
//                dfs(isConnected,marked,N,j);
//                count++;
//            }
//        }
//        return count;
//    }
//    private void dfs(int[][] isConnected,boolean[] marked,int N,int v){
//        marked[v] = true;
//        for(int i = 0;i < N;i++){
//            if(!marked[i] && isConnected[v][i] == 1){
//                dfs(isConnected,marked,N,i);
//            }
//        }
//    }

    private int [] id;
    private int [] rank;
    public int findCircleNum(int[][] isConnected) {
        int N = isConnected.length;
        id = new int[N];
        rank = new int[N];
        for(int i = 0;i < N;i++){
            id[i] = i;
            rank[i] = 1;
        }
        int count = N;
        for(int i = 0;i < N;i++){
            for(int j = 0;j < i;j++){
                if(isConnected[i][j] == 1 && union(i,j)){
                    count--;
                }
            }
        }
        return count;
    }

    private int find(int p){
        int t = id[p];
        if(p != t){
            t = find(t);
            id[p] = t;
        }
        return t;
    }

    private boolean union(int p,int q){
        int i = find(p);
        int j = find(q);
        if(i == j){
            return false;
        }
        if(rank[i] <= rank[j]){
            rank[j] += rank[i];
            id[i] = j;
        }else{
            rank[i] += rank[j];
            id[j] = i;
        }
        return true;
    }
}