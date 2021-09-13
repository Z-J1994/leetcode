package medium;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zhangjun
 * @version 2021/9/13
 */
public class Solution447 {
    public int numberOfBoomerangs(int[][] points) {
        int result = 0;
        int n = points.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }
                Integer dis = getDistance(points[i], points[j]);
                if (map.containsKey(dis)) {
                    result += map.get(dis) * 2;
                    map.put(dis, map.get(dis) + 1);
                } else {
                    map.put(dis, 1);
                }
            }
            map.clear();
        }

        return result;
    }

    private static Integer getDistance(int[] i, int[] j){
        int x = i[0] - j[0];
        int y = i[1] - j[1];
        return x * x + y * y;
    }
}
