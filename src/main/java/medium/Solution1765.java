package medium;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution1765 {
    public int[][] highestPeak(int[][] isWater) {
        int m = isWater.length;
        int n = isWater[0].length;
        boolean [][] visited = new boolean[m][n];
        Deque<Pair> queue = new ArrayDeque<>();
        for(int i = 0;i < m;i++){
            for(int j = 0;j < n;j++){
                if(isWater[i][j] == 1){
                    queue.offer(new Pair(i,j));
                    visited[i][j] = true;
                    isWater[i][j] = 0;
                }else{
                    isWater[i][j] = 1;
                }
            }
        }
        int height = 1;
        int size = queue.size();
        while(!queue.isEmpty()){
            Pair p = queue.poll();
            if(p.x > 0 && isWater[p.x - 1][p.y] != 0 && !visited[p.x - 1][p.y]){
                isWater[p.x - 1][p.y] = height;
                visited[p.x - 1][p.y] = true;
                queue.offer(new Pair(p.x - 1,p.y));
            }
            if(p.x + 1 < m && isWater[p.x + 1][p.y] != 0 && !visited[p.x + 1][p.y]){
                isWater[p.x + 1][p.y] = height;
                visited[p.x + 1][p.y] = true;
                queue.offer(new Pair(p.x + 1,p.y));
            }
            if(p.y > 0 && isWater[p.x][p.y - 1] != 0 && !visited[p.x][p.y - 1]){
                isWater[p.x][p.y - 1] = height;
                visited[p.x][p.y - 1] = true;
                queue.offer(new Pair(p.x,p.y - 1));
            }
            if(p.y + 1 < n && isWater[p.x][p.y + 1] != 0 && !visited[p.x][p.y + 1]){
                isWater[p.x][p.y + 1] = height;
                visited[p.x][p.y + 1] = true;
                queue.offer(new Pair(p.x,p.y + 1));
            }
            if(--size == 0){
                ++height;
                size = queue.size();
            }
        }
        return isWater;
    }

    private static class Pair{
        private int x;
        private int y;
        public Pair(int x,int y){
            this.x = x;
            this.y = y;
        }
    }
}
