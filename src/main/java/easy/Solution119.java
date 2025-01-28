package easy;

import java.util.Arrays;
import java.util.List;

/**
 * @author zhangjun
 * @date 2021/2/12
 */
public class Solution119 {

    //基于杨辉三角的性质,第n行第m列的通项公式为c(n - 1,m - 1)
    public List<Integer> getRow(int rowIndex) {
        if (rowIndex == 0) {
            return List.of(1);
        }
        Integer[] numbers = new Integer[rowIndex + 1];
        numbers[0] = 1;
        for (int m = 1, l = rowIndex / 2; m <= l; m++) {
            //c(n,m) = c(n,m - 1) * (n - m + 1) / m
            numbers[m] = (int) ((numbers[m - 1] * (rowIndex - m + 1L)) / m);
        }
        for (int offset = ((rowIndex + 1) & 1), i = rowIndex / 2 - offset, j = i + 1 + offset;
             i >= 0 && j < numbers.length; i--, j++) {
            numbers[j] = numbers[i];
        }
        return Arrays.asList(numbers);
    }

    public static void main(String[] args) {
        Solution119 s = new Solution119();

        for (int i = 0; i < 34; i++) {
            System.out.println(s.getRow(i).toString());
        }
    }

}
