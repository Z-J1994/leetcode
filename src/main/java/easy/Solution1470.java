package easy;

/**
 * @author zhangjun
 * @version 2020/09/18  21:19
 */
public class Solution1470 {
    public int[] shuffle(int[] nums, int n) {
        int [] array = new int[nums.length];
        for(int i = 0,j = n,k = 0;i < n;){
            array[k++] = nums[i++];
            array[k++] = nums[j++];
        }
        return array;
    }

}
