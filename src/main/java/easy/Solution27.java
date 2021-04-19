package easy;

/**
 * @author zhangjun
 * @version 2021/4/19
 */
public class Solution27 {
    public int removeElement(int[] nums, int val) {
        int index = 0;
        for(int i = 0,l = nums.length;i < l;i++){
            int t = nums[i];
            if(t != val){
                nums[index++] = t;
            }
        }
        return index;
    }
}
