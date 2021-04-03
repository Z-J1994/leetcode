package easy;

/**
 * @author zhangjun
 * @version 2020/10/07  20:34
 */
public class Interview17_10 {
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

        int l = nums.length / 2 + 1;
        count = 0;
        for(int i = 0;i < nums.length;++i){
            if(nums[i] == t){
                count++;
            }
            if(count == l){
                return t;
            }
        }
        return -1;
    }
}
