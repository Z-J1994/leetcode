package easy;

/**
 * @author zhangjun
 * @version 2022/12/1
 */
public class Solution1779 {
    public int nearestValidPoint(int x, int y, int[][] points) {
        int result = -1;
        int min = 0x7fffffff;
        for(int i = 0,t;i < points.length;i++){
            if((x == points[i][0] && (t = Math.abs(points[i][1] - y)) < min)
                    || (y == points[i][1] && (t = Math.abs(points[i][0] - x)) < min)){
                min = t;
                result = i;
            }
        }
        return result;
    }
}
