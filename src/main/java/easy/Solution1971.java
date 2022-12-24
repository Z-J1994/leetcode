package easy;

/**
 * @author zhangjun
 * @version 2022/12/19
 */
public class Solution1971 {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        UnionFind uf = new UnionFind(n);
        for(int [] edge : edges){
            uf.union(edge[0],edge[1]);
        }
        return uf.find(source) == uf.find(destination);
    }

    private static class UnionFind{
        private final int [] data;
        private final int [] size;

        private  UnionFind(int capacity){
            data = new int[capacity];
            size = new int[capacity];
            for(int i = 0;i < capacity;i++){
                data[i] = i;
                size[i] = 1;
            }
        }

        private int find(int i){
            return (i == data[i]) ? i : (data[i] = find(data[i]));
        }

        private void union(int x,int y){
            int i = find(x);
            int j = find(y);
            if(j == i){
                return;
            }
            if(size[i] > size[j]){
                data[j] = i;
                size[i] += size[j];
            }else{
                data[i] = j;
                size[j] += size[i];
            }
        }
    }
}
