package utils;

import java.util.ArrayList;
import java.util.List;

public class Parser {
    public static int[][] stringToIntMatrix(String s,int row, int column) {
        List<int[]> result = new ArrayList<>();
        char c;
        for (int i = 2,r = 0;r < row; i += 2,r++) {
            int[] element = new int[column];
            for (int j = 0; j < column; j++) {
                int sign = 1;
                if(!((c = s.charAt(i)) >= '0' && c <= '9')){
                    if(c != '-'){
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

    private int getLength(String s, char separator) {
        return 0;
    }
}
