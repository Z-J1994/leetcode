package easy;

/**
 * @author zhangjun
 * @version 2020/10/02  20:10
 */
public class Offer39 {
    public int majorityElement(int[] nums) {
        int count = 1;
        int value = nums[0];
        for(int i = 1;i < nums.length;i++){
            if(value == nums[i]){
                ++count;
            }else {
                --count;
                if(count == 0){
                    value = nums[i];
                    ++count;
                }
            }
        }
        return value;
    }
}
