package easy;

/**
 * @author zhangjun
 * @version 2022/11/23
 */
public class Solution1742 {
    public int countBalls(int lowLimit, int highLimit) {
        int c = 0;
        for (int i = highLimit; i > 0; i /= 10, c++) ;
        int[] map = new int[(c + 1) * 10];
        while (lowLimit <= highLimit) {
            for (int j = lowLimit % 10,t = bitSum(lowLimit); j < 10 && lowLimit <= highLimit; j++, lowLimit++) {
                map[t++]++;
            }
        }
        int max = 0;
        for (int j : map) {
            if (j > max) {
                max = j;
            }
        }
        return max;
    }

    private int bitSum(int n) {
        int s = 0;
        while (n > 0) {
            s += n % 10;
            n /= 10;
        }
        return s;
    }
}
