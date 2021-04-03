package easy;

/**
 * @author zhangjun
 * @version 2020/09/20  19:01
 */
public class Solution1266 {
    public int minTimeToVisitAllPoints(int[][] points) {
        int step = 0;

        for(int i = 1;i < points.length;i++){
            int x = points[i - 1][0];
            int y = points[i - 1][1];
            int absX = Math.abs(points[i][0] - x);
            int absY = Math.abs(points[i][1] - y);
            step += Math.max(absX,absY);
        }
        return step;
    }
}
