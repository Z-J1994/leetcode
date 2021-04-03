package easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangjun
 * @version 2020/10/01  17:35
 */
public class Solution1002 {
    public List<String> commonChars(String[] A) {
        int [] chars = new int[26];
        for(int j = 0;j < A[0].length();j++){
            chars[A[0].charAt(j) - 97]++;
        }
        for(int i = 0;i < A.length;i++){
            int [] str = new int[26];
            for(int j = 0;j < A[i].length();j++){
                str[A[i].charAt(j) - 97]++;
            }
            for(int j = 0;j < 26;j++){
                if(chars[j] > str[j]){
                    chars[j] = str[j];
                }
            }
        }
        List<String> list = new ArrayList<>();
        for(int j = 0;j < 26;j++){
            if(chars[j] != 0){
                for(int i = 0;i < chars[j];i++){
                    char c = (char)(j + 97);
                    list.add(c + "");
                }
            }
        }
        return  list;
    }
}
