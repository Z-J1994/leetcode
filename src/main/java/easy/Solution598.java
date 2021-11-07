package easy;

public class Solution598 {
    public int maxCount(int m, int n, int[][] ops) {
        int minX = m;
        int minY = n;
        for (int[] operation : ops) {
            if (minX > operation[0]) {
                minX = operation[0];
            }
            if (minY > operation[1]) {
                minY = operation[1];
            }
        }
        return minY * minX;
    }
}
