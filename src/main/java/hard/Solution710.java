package hard;

import java.util.Arrays;
import java.util.Random;

public class Solution710 {

    private static class Solution {
        private final int[] bases;
        private final int[] prefixSum;
        private final Random random = new Random();
        private final int max;
        private final int bound;

        public Solution(int n, int[] blacklist) {
            bases = new int[blacklist.length + 1];
            prefixSum = new int[bases.length];
            Arrays.sort(blacklist);
            int index = 0;
            int p = 0;
            int count = 0;
            for (int c : blacklist) {
                if (p != c) {
                    bases[index] = p;
                    prefixSum[index++] = count += c - p;
                }
                p = c + 1;
            }
            if (p <= n - 1) {
                bases[index] = p;
                prefixSum[index++] = count += (n - p);
            }

            max = index;
            bound = count;
        }

        public int pick() {
            int element = random.nextInt(bound) + 1;
            int lo = 0, hi = max;
            while (lo < hi) {
                int mid = (lo + hi) >>> 1;
                if (prefixSum[mid] < element) {
                    lo = mid + 1;
                } else {
                    hi = mid;
                }
            }
            return bases[hi] + prefixSum[hi] - element;
        }


        public static void main(String[] args) {
            Solution s = new Solution(7, new int[]{2, 3, 5});
            for (int i = 0; i < 7; i++) {
                System.out.println(s.pick());
            }
        }
    }

}
