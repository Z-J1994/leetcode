package easy;

/**
 * @author zhangjun
 * @date 2021/2/7
 */
public class Solution665 {
    public boolean checkPossibility(int[] nums) {
        int length = nums.length;
        if(length == 1){
            return true;
        }
        int count = 0;
        int p = nums[1];
        if(nums[0] > p){
            count++;
        }
        for(int i = 2;i < length;i++){
            int t = nums[i];
            if(p > t){
                count++;
                if(count == 2){
                    return false;
                }
                if(t < nums[i - 2]){
                    t = p;
                }
            }
            p = t;
        }
        return true;
    }
}
