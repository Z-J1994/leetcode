package medium;

/**
 * @author zhangjun
 * @version 2021/9/20
 */
public class Solution673 {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int [][] map = new int [n][2];
        int top = 0;
        map[top][0] = 1;
        map[top][1] = 1;
        for(int i = 1;i < n;i++){
            int max = 0;
            int count = 0;
            int t = nums[i];
            for(int j = 0;j < i;j++){
                if(nums[j] < t){
                    if(map[j][0] > max){
                        max = map[j][0];
                        count = map[j][1];
                    }else if(map[j][0] == max){
                        count += map[j][1];
                    }
                }
            }
            map[i][0] = max + 1;
            map[i][1] = count == 0 ? 1 : count;
        }

        int count = map[0][1];
        int max = map[0][0];
        for(int i = 1;i < n;i++){
            if(map[i][0] > max){
                max = map[i][0];
                count = map[i][1];
            }else if(map[i][0] == max){
                count += map[i][1];
            }
        }
        return count;
    }
}
