package medium;

import utils.Parser;

import java.util.Arrays;
import java.util.Random;

public class Solution497 {
    private static class Solution {

        private final int[] index;

        private final int[][] vertex;

        private final Random random = new Random();

        private final int max;

        public Solution(int[][] vertex) {
            this.vertex = vertex;
            index = new int[vertex.length];
            int p = 0;
            for (int i = 0; i < vertex.length; i++) {
                p += ((vertex[i][2] - vertex[i][0] + 1) * (vertex[i][3] - vertex[i][1] + 1));
                index[i] = p;
            }
            max = p;
        }

        public int[] pick() {
            int v = random.nextInt(max);
            int lo = -1, hi = index.length - 1;
            while (lo < hi) {
                int mid = (lo + hi + 1) >>> 1;
                if (index[mid] > v) {
                    hi = mid - 1;
                } else {
                    lo = mid;
                }
            }
            lo += 1;
            int a1 = vertex[lo][0];
            int b1 = vertex[lo][1];
            return new int[]{(a1 + random.nextInt((vertex[lo][2] - a1 + 1))), b1 + random.nextInt((vertex[lo][3] - b1 + 1))};
        }


        private boolean check(int[] a) {
            for (int[] v : vertex) {
                if (a[0] >= v[0] && a[0] <= v[2] && a[1] >= v[1] && a[1] <= v[3]) {
                    return true;
                }
            }
            return false;
        }


        public static void main(String[] args) {
            Solution s = new Solution(Parser.stringToIntMatrix("[[-2,-2,1,1],[2,2,4,6]]", 2, 4));
            for (int i = 0; i < 100000000; i++) {
                int[] pick = s.pick();
                if (!s.check(pick)) {
                    System.out.println(Arrays.toString(pick));
                }
            }
        }
    }
}
