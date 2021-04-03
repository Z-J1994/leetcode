package easy;

/**
 * @author zhangjun
 * @date 2021/2/17
 */
public class Solution566 {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int oldRow = nums.length;
        int oldColumn = nums[0].length;
        int sum = oldColumn * oldRow;
        if(r * c != sum){
            return nums;
        }

        int [][] result = new int[r][c];
        int newRow = 0;
        int newColumn = 0;
        for(int i = 0;i < oldRow;i++){
            for(int j = 0;j < oldColumn;j++){
                result[newRow][newColumn++] = nums[i][j];
                if(newColumn == c){
                    newColumn = 0;
                    newRow++;
                }
            }
        }

        return result;
    }
}
