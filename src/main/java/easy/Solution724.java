package easy;

/**
 * @author zhangjun
 * @date 2021/1/28
 */
public class Solution724 {
    public int pivotIndex(int[] nums) {
        int length = nums.length;
        int sum = 0;
        for(int i = 0;i < length;i++){
            sum += nums[i];
        }
        for(int i = 0,t = 0,s;i < length;i++){
            s = nums[i];
            if((t << 1) + s == sum){
                return i;
            }
            t += s;
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution724 s = new Solution724();
        int [] nums1 = {1, 7, 3, 6, 5, 6};
        System.out.println(s.pivotIndex(nums1));
    }
}
