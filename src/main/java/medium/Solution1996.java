package medium;

import java.util.Arrays;

public class Solution1996 {
    public int numberOfWeakCharacters(int[][] properties) {
        Arrays.sort(properties, (a, b) -> {
            int t = a[0] - b[0];
            if (t == 0) {
                t = b[1] - a[1];
            }
            return t;
        });
        int sum = 0;
        int max = 0;
        for (int i = properties.length - 1; i >= 0; i--) {
            if (max > properties[i][1]) {
                ++sum;
            } else {
                max = properties[i][1];
            }
        }
        return sum;
    }
}
