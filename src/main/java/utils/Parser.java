package utils;

import java.util.ArrayList;
import java.util.List;

public class Parser {
    public static int[][] stringToIntMatrix(String s, int row, int column) {
        List<int[]> result = new ArrayList<>();
        char c;
        for (int i = 2, r = 0; r < row; i += 2, r++) {
            int[] element = new int[column];
            for (int j = 0; j < column; j++) {
                int sign = 1;
                if (!((c = s.charAt(i)) >= '0' && c <= '9')) {
                    if (c != '-') {
                        throw new IllegalArgumentException("只能包含数字");
                    }
                    sign = -1;
                    i++;
                }
                while ((c = s.charAt(i)) >= '0' && c <= '9') {
                    element[j] = element[j] * 10 + c - '0';
                    i++;
                }
                element[j] *= sign;
                i++;
            }
            result.add(element);
        }
        return result.toArray(new int[result.size()][]);
    }

    public static int[] StringToIntArray(String s) {
        int l = 0;
        int lastIndex = s.length() - 1;
        for (int i = 1; i < lastIndex; i++) {
            if (s.charAt(i) == ',') {
                l++;
            }
        }
        int[] result = new int[l + 1];
        int index = 0;
        int n = 0;
        for (int i = 1; i < lastIndex; i++) {
            char c = s.charAt(i);
            if (c == ',') {
                result[index++] = n;
                n = 0;
            } else {
                n = n * 10 + c - 48;
            }
        }
        result[index] = n;
        return result;
    }

}
