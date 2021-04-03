package easy;

/**
 * @author zhangjun
 * @version 2020//09/22  22:47
 */
public class Solution1351 {
    public int countNegatives(int[][] grid) {
        int count = 0;
        int m = grid[0].length;
        for(int i = 0;i < grid.length;i++){
            int row = binarySearch(grid[i]);
            if(row < 0){
                count += m;
                continue;
            }
            if(row >= m){
                continue;
            }
            while(row < m && grid[i][row] >= 0){
                row++;
            }
            count += m - row;
        }
        return count;
    }

    private int binarySearch(int [] arr){
        int lo = 0;
        int hi = arr.length - 1;
        int mid;
        while(lo <= hi){
            mid = (lo + hi) / 2;
            if(arr[mid] > 0){
                lo = mid + 1;
            }else if(arr[mid] < 0){
                hi = mid - 1;
            }else{
                return mid;
            }
        }
        return hi;
    }

}
