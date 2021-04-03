package hard;

import java.util.PriorityQueue;

/**
 * @author zhangjun
 * @date 2021/1/30
 */
public class Solution778 {

//    堆 + bfs
//    public int swimInWater(int[][] grid) {
//        int [][] direct = {{1,0},{0,1},{-1,0},{0,-1}};
//        int N = grid.length;
//        boolean [][] marked = new boolean[N][N];
//        Heap heap = new Heap(N);
//        int max = grid[0][0];
//        heap.add(max,0,0);
//        marked[0][0] = true;
//        N -= 1;
//        while(!heap.isEmpty()){
//            Heap.Pair t = heap.delete();
//            if(t.height > max){
//                max = t.height;
//            }
//            for(int k = 0;k < 4;k++){
//                int newI = t.i + direct[k][0];
//                int newJ = t.j + direct[k][1];
//                if(newI >= 0 && newI <= N && newJ >= 0 && newJ <= N && !marked[newI][newJ]){
//                    int l = grid[newI][newJ];
//                    if(newI == N && newJ == N){
//                        return max > l? max : l;
//                    }
//                    marked[newI][newJ] = true;
//                    heap.add(l,newI,newJ);
//                }
//            }
//        }
//       return -1;
//    }
//
//    private class Heap{
//        private class Pair{
//            int height;
//            int i;
//            int j;
//            public Pair(int height,int i,int j){
//                this.height = height;
//                this.i = i;
//                this.j = j;
//            }
//        }
//        private Pair [] values;
//        private int size;
//        public Heap(int capacity){
//            values = new Pair[capacity * capacity + 1];
//            size = 0;
//        }
//
//        private boolean isEmpty(){
//            return size == 0;
//        }
//
//        private void sink(int parent){
//            int size = this.size;
//            int child = parent * 2;
//            Pair parentValue = values[parent];
//            while(child <= size){
//                Pair minValue = values[child];
//                if(child < size){
//                    Pair childValue = values[child + 1];
//                    if(minValue.height >= childValue.height){
//                        minValue = childValue;
//                        child += 1;
//                    }
//                }
//                if(minValue.height >= parentValue.height){
//                    break;
//                }
//                values[parent] = minValue;
//                parent = child;
//                child = parent * 2;
//            }
//            values[parent] = parentValue;
//        }
//
//        private void swim(int child){
//            Pair childValue = values[child];
//            values[0] = childValue;
//            int parent = child / 2;
//            Pair parentValue = values[parent];
//            while(childValue.height < parentValue.height){
//                values[child] = parentValue;
//                child = parent;
//                parent = child / 2;
//                parentValue = values[parent];
//            }
//            values[child] = childValue;
//        }
//
//        private void add(int height,int i,int j){
//            values[++size] = new Pair(height,i,j);
//            swim(size);
//        }
//
//        private Pair delete(){
//            Pair e = values[1];
//            values[1] = values[size--];
//            sink(1);
//            return e;
//        }
//    }


    //  二分求左边界 + bfs
    public int swimInWater(int[][] grid) {
        int N = grid.length;
        int end = N - 1;
        int lo = Math.max(grid[0][0],grid[end][end]);
        int hi = 0;
        for(int i = 0;i < N;i++){
            for(int j = 0;j < N;j++){
                int k = grid[i][j];
                if(k > hi){
                    hi = k;
                }
            }
        }

        while(lo < hi){
            boolean [][] visited = new boolean[N][N];
            int mid = lo + (hi - lo) / 2;
            dfs(grid,visited,0,0,end,mid);
            if(!visited[end][end]){
                lo = mid + 1;
            }else{
                hi = mid;
            }
        }
        return lo;
    }

    private void dfs(int[][] grid,boolean [][] visited,int i,int j,int end,int limit){
        if(visited[i][j]){
            return;
        }
        if(grid[i][j] > limit){
            return;
        }
        visited[i][j] = true;

        if(i > 0){
            dfs(grid,visited,i - 1,j,end,limit);
        }
        if(j > 0){
            dfs(grid,visited,i,j - 1,end,limit);
        }

        if(i < end){
            dfs(grid,visited,i + 1,j,end,limit);
        }
        if(j < end){
            dfs(grid,visited,i,j + 1,end,limit);
        }
    }

    public static void main(String[] args) {
        Solution778 s = new Solution778();

        int [][] grid1 = {{0,1,2,3,4},{24,23,22,21,5},{12,13,14,15,16},{11,17,18,19,20},{10,9,8,7,6}};
        int [][] grid2 = {{0,2},{1,3}};
        int [][] grid3 = {{11,15,3,2},{6,4,0,13},{5,8,9,10},{1,14,12,7}};
        System.out.println(s.swimInWater(grid1));
        System.out.println(s.swimInWater(grid2));
        System.out.println(s.swimInWater(grid3));
    }
}
