package medium;

import java.util.Arrays;

public class Solution593 {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        int[][] points = new int[][]{p1, p2, p3, p4};
        Arrays.sort(points, (a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];
            }
            return b[1] - a[1];
        });

        if (check(points[0], points[1], points[2]) && check(points[3], points[2], points[1])) {
            double d1 = Math.pow((points[2][1] - points[0][1]), 2) + Math.pow((points[2][0] - points[0][0]), 2);
            double d2 = Math.pow((points[1][1] - points[0][1]), 2) + Math.pow((points[1][0] - points[0][0]), 2);
            double d3 = Math.pow((points[2][1] - points[3][1]), 2) + Math.pow((points[2][0] - points[3][0]), 2);
            double d4 = Math.pow((points[1][1] - points[3][1]), 2) + Math.pow((points[1][0] - points[3][0]), 2);
            return d1 == d2 && d1 == d3 && d1 == d4 && d1 != 0;
        }
        return false;
    }

    private boolean check(int[] p1, int[] p2, int[] p3){
        return (p3[1] - p1[1]) * (p2[1] - p1[1]) == -(p3[0] - p1[0]) * (p2[0] - p1[0]);
    }
}
