package medium;

public class Solution684 {

    int [] id;
    int [] size;
    int []result = new int[2];
    public int[] findRedundantConnection(int[][] edges) {
        int length = edges.length;
        id = new int[length + 1];
        size = new int[length + 1];

        initial();

        for(int [] e:edges){
            if(union(e[0],e[1])){
                return result;
            }
        }

        return  null;
    }

    private void initial(){
        for(int i = 1,l = id.length;i < l;i++){
            id[i] = i;
            size[i] = 1;
        }
    }

    private int find(int p){
        int t = id[p];
        if(t != p){
            t = find(t);
            id[p] = t;
        }
        return t;
    }

    private boolean union(int p,int q){
        int i = find(p);
        int j = find(q);

        if(j == i){
            result[0] = p;
            result[1] = q;
            return true;
        }

        if(size[i] > size[j]){
            size[i] += size[j];
            id[j] = i;
        }else{
            size[j] += size[i];
            id[i] = j;
        }
        return false;
    }
}
