package easy;

/**
 * @author zhangjun
 * @version 2022/2/9
 */
public class Solution2006 {
    public int countKDifference(int[] nums, int k) {
        int [] map = new int[101];
        int count = 0;
        for(int i = nums.length - 1,t;i >= 0;i--){
            if(nums[i] > k && (t = map[nums[i] - k]) > 0){
                count += t;
            }
            if(nums[i] + k <= 100 && (t = map[nums[i] + k]) > 0){
                count += t;
            }
            map[nums[i]]++;
        }
        return count;
    }
}
