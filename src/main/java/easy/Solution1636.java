package easy;

import java.util.Arrays;

/**
 * @author zhangjun
 * @since 2022/9/19 13:02
 */
public class Solution1636 {
    public int[] frequencySort(int[] nums) {
        int [] map = new int[202];
        for(int num : nums){
            map[num + 100]++;
        }
        int [][] s = new int[nums.length][2];
        int index = 0;
        for(int num : nums){
            s[index][0] = map[num + 100];
            s[index][1] = num;
            index++;
        }
        Arrays.sort(s, (a, b) -> {
            if(a[0] == b[0]){
                return b[1] - a[1];
            }
            return a[0] - b[0];
        });
        index = 0;
        for(int [] i : s){
            nums[index++] = i[1];
        }
        return nums;
    }
}
