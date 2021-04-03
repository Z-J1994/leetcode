package hard;

/**
 * @author zhangjun
 * @date 2021/1/27
 */
public class Solution1579 {
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        int length = n + 1;
        int [] idA = new int[length];
        int [] idB = new int[length];

        for(int i = 1;i < length;i++){
            idA[i] = i;
            idB[i] = i;
        }
        int es = edges.length;
        for(int [] edge : edges){
            if(edge[0] == 3){
                int t = union(idA,edge[1],edge[2]);
                es -= t;
                n -= t;
            }
        }

        for(int i = 1;i < length;i++){
            idB[i] = idA[i];
        }

        int countA = n;
        int countB = n;
        int t;
        for(int [] edge : edges){
            switch(edge[0]){
                case 1:
                    t = union(idA,edge[1],edge[2]);
                    es -= t;
                    countA -= t;break;
                case 2:
                    t = union(idB,edge[1],edge[2]);
                    es -= t;
                    countB -= t;break;
            }
        }
        return  (countA == 1&& countB == 1) ? es : -1;
    }

    private int find(int [] id,int p){
        int t = id[p];
        if(t != p){
            t = find(id,t);
            id[p] = t;
        }
        return t;
    }
    private int union(int [] id,int p,int q){
        p = find(id, p);
        q = find(id,q);
        if(q == p){
            return 0;
        }
        id[p] = q;
        return 1;
    }
}
