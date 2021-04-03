package medium;

/**
 * @author zhangjun
 * @date 2021/1/19
 */
public class Solution1584 {

    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        int[] distance = new int[n];
        int max = Integer.MAX_VALUE;

        for(int i = 0;i < n;i++){
            distance[i] = max;
        }

        int result = 0;
        for(int i = 0,t = 1;t < n;t++){
            int min = max;
            int minIndex = i;
            distance[i] = -1;
            for(int j = 0;j < n;j++) {
                if(distance[j] >= 0){
                    int g = Math.min(distance[j],Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]));
                    distance[j] = g;
                    if(min > g){
                        min = g;
                        minIndex = j;
                    }
                }
            }
            i = minIndex;
            result += distance[i];
        }
        return result;
    }

    public static void main(String[] args) {
        Solution1584 s = new Solution1584();
        
        int [][] points = {{2,-3},{-17,-8},{13,8},{-17,-15}};
        System.out.println(s.minCostConnectPoints(points));
    }
}
