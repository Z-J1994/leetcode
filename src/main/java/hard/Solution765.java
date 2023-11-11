package hard;

/**
 * @author zhangjun
 * @date 2021/2/14
 */
public class Solution765 {
    public int minSwapsCouples(int[] row) {
        int[] indexes = new int[row.length];
        for (int i = 0; i < row.length; i++) {
            indexes[row[i]] = i;
        }
        int count = 0;
        for (int i = 0, t; i < row.length; i += 2) {
            if ((row[i] & 1) == 0) {
                t = row[i] + 1;
            } else {
                t = row[i] - 1;
            }
            if (row[i + 1] != t) {
                int temp = row[indexes[t]];
                row[indexes[t]] = row[i + 1];
                row[i + 1] = temp;
                count++;

                indexes[row[indexes[t]]] = indexes[t];

            }
        }
        return count;
    }

}
