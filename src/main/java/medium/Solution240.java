package medium;

public class Solution240 {
    public boolean searchMatrix(int[][] matrix, int target) {

        int n = matrix[0].length - 1;
        for(int [] row : matrix){
            if(row[0] <= target && row[n] >= target){
                int lo = 0,hi = n;
                while(lo <= hi){
                    int mid = (lo + hi) >>> 1;
                    if(row[mid] > target){
                        hi = mid - 1;
                    }else if(row[mid] < target){
                        lo = mid + 1;
                    }else{
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
