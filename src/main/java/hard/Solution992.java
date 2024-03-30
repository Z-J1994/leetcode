package hard;

import utils.Parser;

public class Solution992 {

    public int subarraysWithKDistinct(int[] nums, int k) {
        int[] map = new int[nums.length + 1];
        int count, size = 0, j = -1,t = 0;
        while (++j < nums.length) {
            if (++map[nums[j]] == 1) {
                if (++size == k) {
                    break;
                }
            }
        }
        if (size != k) {
            return 0;
        }
        while (map[nums[t]] > 1) {
            --map[nums[t++]];
        }
        count = t + 1;
        for (int i = 0; ++j < nums.length; ) {
            if (++map[nums[j]] == 1) {
                map[nums[t++]] = 0;
                i = t;
            }
            while (map[nums[t]] > 1) {
                --map[nums[t++]];
            }
            count += t - i + 1;
        }
        return count;
    }


    public static void main(String[] args) {
        Solution992 s = new Solution992();
        System.out.println(s.subarraysWithKDistinct(Parser.StringToIntArray("[1,1,1,2,1,2,2,1]"), 1) == 12);
    }
}
