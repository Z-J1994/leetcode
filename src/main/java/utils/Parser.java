package utils;

import java.util.ArrayList;
import java.util.List;

public class Parser {
    public static int[][] stringToIntMatrix(String s, int rowNumber) {
        List<int[]> result = new ArrayList<>();
        char c;
        for (int i = 2, l = s.length() - 2; i < l; i += 2) {
            int[] element = new int[rowNumber];
            for (int j = 0; j < rowNumber; j++) {
                while ((c = s.charAt(i)) >= '0' && c <= '9') {
                    element[j] = element[j] * 10 + c - '0';
                    i++;
                }
                i++;
            }
            result.add(element);
        }
        return result.toArray(new int[result.size()][]);
    }

    private int getLength(String s, char separator) {
        return 0;
    }
}
