package hard;

import java.util.Arrays;
import java.util.List;

public class Solution1610 {
    public int visiblePoints(List<List<Integer>> points, int angle, List<Integer> location) {

        int px = location.get(0);
        int py = location.get(1);
        double[] angles = new double[points.size()];
        int length = 0;
        int equalsCount = 0;
        for (List<Integer> point : points) {
            int x = point.get(0);
            int y = point.get(1);
            if (x == px && y == py) {
                equalsCount++;
                continue;
            }
            double a = Math.toDegrees(Math.atan2(y - py, x - px));
            if (a < 0) {
                a += 360;
            }
            angles[length++] = a;
        }

        Arrays.sort(angles, 0, length);

        int left = 0;
        int right = 0;
        int max = 0;
        while (right < length) {
            while (right < length && angles[right] - angles[left] <= angle) {
                right++;
                if (right - left > max) {
                    max = right - left;
                }
            }
            if(right < length){
                left++;
            }
        }

        right = 0;
        while (left < length) {
            while (right < length && (angles[right] + 360) - angles[left] <= angle) {
                right++;
                if (right + (length - left) > max) {
                    max = right + (length - left);
                }
            }
            left++;
        }
        return equalsCount + max;
    }

    public static void main(String[] args) {
        Solution1610 s = new Solution1610();
//        System.out.println(s.visiblePoints(Arrays.asList(Arrays.asList(1, 0), Arrays.asList(2, 1)), 13, Arrays.asList(1, 1)));
//        System.out.println(s.visiblePoints(Arrays.asList(Arrays.asList(0, 0), Arrays.asList(0, 2)), 90, Arrays.asList(1, 1)));
//        System.out.println(s.visiblePoints(Arrays.asList(Arrays.asList(2, 1), Arrays.asList(2, 2), Arrays.asList(3, 3)), 90, Arrays.asList(1, 1)));
        System.out.println(s.visiblePoints(Arrays.asList(
                Arrays.asList(60,61),
                Arrays.asList(58,47),
                Arrays.asList(17,26),
                Arrays.asList(87,97),
                Arrays.asList(63,63),
                Arrays.asList(26,50),
                Arrays.asList(70,21),
                Arrays.asList(3,89),
                Arrays.asList(51,24),
                Arrays.asList(55,14),
                Arrays.asList(6,51),
                Arrays.asList(64,21),
                Arrays.asList(66,33),
                Arrays.asList(54,35),
                Arrays.asList(87,38),
                Arrays.asList(30,0),
                Arrays.asList(37,92),
                Arrays.asList(92,12),
                Arrays.asList(60,73),
                Arrays.asList(75,98),
                Arrays.asList(1,11),
                Arrays.asList(88,24),
                Arrays.asList(82,92)
        ), 44, Arrays.asList(15, 50)));

    }

    //[60,61],[58,47],[17,26],[87,97],[63,63],[26,50],[70,21],[3,89],[51,24],[55,14],[6,51],[64,21],[66,33],[54,35],[87,38],[30,0],[37,92],[92,12],[60,73],[75,98],[1,11],[88,24],[82,92]
}
