package medium;

/**
 * @author zhangjun
 * @version 2022/2/24
 */
public class Solution1706 {
    public int[] findBall(int[][] grid) {
        int [] answer = new int[grid[0].length];
        for(int i = 0;i < grid[0].length;i++){
            answer[i] = drop(grid,i);
        }
        return answer;
    }

    private int drop(int [][] grid,int index){
        for(int i = 0;i < grid.length;i++){
            if(index < 0 || index >= grid[0].length){
                return -1;
            }
            if((grid[i][index] == 1) && (++index == grid[0].length || grid[i][index] == -1)){
                return -1;
            }
            if((grid[i][index] == -1) && (--index == -1 || grid[i][index] == 1)){
                return -1;
            }
        }
        return index;
    }
}
