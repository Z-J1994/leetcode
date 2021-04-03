package easy;

/**
 * @author zhangjun
 * @version 2020/10/02  16:08
 */
public class Interview08_03 {
    public int findMagicIndex(int[] nums) {
        for(int i = 0;i < nums.length;i++){
            if(nums[i] == i){
                return i;
            }
        }
        return -1;
    }
}
