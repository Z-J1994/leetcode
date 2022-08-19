package hard;

import java.util.HashMap;
import java.util.Map;

public class Solution1224 {
    public int maxEqualFreq(int[] nums) {
        Map<Integer, IntHolder> counter = new HashMap<>();
        int[] map = new int[nums.length + 2];
        int maxIndex = 0;
        counter.put(nums[0], new IntHolder(1));
        map[1] = 1;
        int size = 1;
        for (int i = 1, n,c; i < nums.length; i++) {
            n = nums[i];
            IntHolder holder = counter.get(n);
            if (holder == null) {
                holder = new IntHolder(0);
                counter.put(n, holder);
            } else if (--map[holder.value] == 0) {
                --size;
            }
            c = ++holder.value;
            if (++map[holder.value] == 1) {
                size++;
            }
            if ((size == 1 && (map[c] == 1 || map[c] == i + 1)) || (size == 2 && (map[1] == 1 || (map[c] == 1 && map[c - 1] > 0) || (map[c + 1] == 1 && map[c] > 0)))) {
                maxIndex = i;
            }
        }
        return maxIndex + 1;
    }

    private static class IntHolder {
        private int value;

        public IntHolder(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        Solution1224 s = new Solution1224();
        System.out.println(s.maxEqualFreq(new int[]{2, 2, 1, 1, 5, 3, 3, 5}) == 7);
        System.out.println(s.maxEqualFreq(new int[]{1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4, 5}) == 13);
        System.out.println(s.maxEqualFreq(new int[]{10, 2, 8, 9, 3, 8, 1, 5, 2, 3, 7, 6}) == 8);
        System.out.println(s.maxEqualFreq(new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}) == 16);
        System.out.println(s.maxEqualFreq(new int[]{1, 1, 1, 2, 2, 2, 3, 3, 3}) == 7);
        System.out.println(s.maxEqualFreq(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 9}) == 10);
    }
}
