package easy;

/**
 *
 * @author zhangjun
 * @version 2020/10/07  19:51
 */
public class Solution169 {
    public int majorityElement(int[] nums) {
        int t = nums[0];
        int count = 1;

        for(int i = 1;i < nums.length;++i){
            if(t != nums[i]){
                --count;
                if(count == 0){
                    t = nums[i];
                    ++count;
                }
            }else{
                ++count;
            }
        }
        return t;
    }
}
