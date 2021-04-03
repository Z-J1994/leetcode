package hard;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author zhangjun
 * @date 2021/2/14
 */
public class Solution765 {
    public int minSwapsCouples(int[] row) {
        int length = row.length;
        int vertices = length / 2;

        int [] id = new int[vertices];
        int [] size = new int[vertices];
        for(int i = 0;i < vertices;i++){
            id[i] = i;
            size[i] = 1;
        }
        int count = vertices;
        int result = 0;
        for(int i = 0;i < length;i += 2){
            int t = row[i] / 2;
            int g = row[i + 1] / 2;
            if(t != g){
                count -= union(id,size,t,g);
                result++;
            }else{
                count--;
            }
        }
        return result - count;
    }

    private int find(int [] id,int p){
        int t = id[p];
        if(t != p){
            t = find(id,t);
            id[p] = t;
        }
        return t;
    }

    private int union(int [] id,int [] size,int x,int y){
        x = find(id,x);
        y = find(id,y);

        if(x == y){
            return 0;
        }

        if(size[x] > size[y]){
            size[x] += size[y];
            id[y] = id[x];
        }else {
            size[y] += size[x];
            id[x] = id[y];
        }
        return 1;
    }

}
