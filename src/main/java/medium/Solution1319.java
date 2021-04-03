package medium;

/**
 * @author zhangjun
 * @date 2021/1/23
 */
public class Solution1319 {
    public int makeConnected(int n, int[][] connections) {

        if(connections.length + 1 < n){
            return -1;
        }
        int [] id = new int[n];
        int [] size = new int[n];
        for(int i = 0;i < n;i++){
            id[i] = i;
            size[i] = 1;
        }
        int count = n;
        for(int [] computers:connections){
            count -= union(id,size,computers[0],computers[1]);

        }
        return count - 1;
    }

    private int find(int [] id,int p){
        int t = id[p];
        if(t != p){
            t = find(id,t);
            id[p] = t;
        }
        return t;
    }

    private int union(int [] id,int [] size,int p,int q){
        int i = find(id,p);
        int j = find(id,q);

        if(i == j){
            return 0;
        }
        if(size[i] < size[j]){
            int t = i;
            i = j;
            j = t;
        }
        size[i] += size[j];
        id[j] = i;
        return 1;
    }
}
