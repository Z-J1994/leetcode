package utils;

import java.util.ArrayList;
import java.util.List;

public class Parser {
    public static int [][] stringToIntMatrix(String s){
        List<int[]> result = new ArrayList<>();
        char c;
        for(int i = 2,l = s.length() - 2;i < l;i+=3){
            int [] element = new int[2];
            while((c = s.charAt(i)) >= '0' && c <= '9'){
                element[0] = element[0] * 10 + c - '0';
                i++;
            }
            while((c = s.charAt(++i)) >= '0' && c <= '9'){
                element[1] = element[1] * 10 + c - '0';
            }
            result.add(element);
        }
        return result.toArray(new int[result.size()][]);
    }

    private int getLength(String s,char separator){
        return 0;
    }
}
