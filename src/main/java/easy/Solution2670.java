package easy;

/**
 * @author zhangjun
 * @since 2024/1/31 12:47
 */
public class Solution2670 {
    public int[] distinctDifferenceArray(int[] nums) {
        int [] map  = new int[51];
        int [] diff = new int[nums.length];
        int count = 0;
        for(int i = 0;i < nums.length;i++){
            if(++map[nums[i]] == 1){
                ++count;
            }
            diff[i] = count;
        }
        int [] result = new int[nums.length];
        count = 0;
        for(int i = nums.length - 1;i >= 0;i--){
            result[i] = diff[i] - count;
            map[nums[i]] -= 100;
            if(map[nums[i]] < 0 && map[nums[i]] >= -100){
                ++count;
            }
        }
        return result;
    }
}
