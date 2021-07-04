package easy;

/**
 * @author zhangjun
 * @version 2021/7/4
 */
public class Solution645 {
    public int[] findErrorNums(int[] nums) {
        int length = nums.length;
        int [] map = new int[length + 1];
        int [] result = new int[2];
        for(int i : nums){
            map[i]++;
        }
        for(int i = 1;i <= length;++i){
            int t  = map[i];
            if(t == 2){
                result[0] = i;
            }
            else if(t == 0){
                result[1] = i;
            }
        }
        return result;
    }
}
