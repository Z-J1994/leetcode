package medium;

/**
 * @author zhangjun
 * @version 2022/12/16
 */
public class Solution1785 {
    public int minElements(int[] nums, int limit, int goal) {
        long sum = 0;
        for(int i : nums){
            sum += i;
        }
        return (int)((Math.abs(goal - sum) + (limit - 1)) / limit);
    }
}
