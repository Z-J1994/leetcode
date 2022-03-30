package easy;

public class Solution812 {
    public double largestTriangleArea(int[][] points) {
        double max = 0;
        for (int i = 0, A, B, C; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                A = points[j][1] - points[i][1];
                B = points[i][0] - points[j][0];
                C = points[j][0] * points[i][1] - points[i][0] * points[j][1];
                double l = Math.sqrt(Math.pow(points[i][0] - points[j][0], 2) + Math.pow(points[i][1] - points[j][1], 2));
                for (int k = j + 1; k < points.length; k++) {
                    double area = l * Math.abs(A * points[k][0] + B * points[k][1] + C) / Math.sqrt(A * A + B * B);
                    if (area > max) {
                        max = area;
                    }
                }
            }
        }
        return max / 2;
    }
}
