package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhangjun
 * @version 2021/10/8
 */
public class Solution187 {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> result = new ArrayList<>();
        if(s.length() < 10){
            return result;
        }
        char [] chars = s.toCharArray();
        Map<Integer,Integer> map = new HashMap<>();

        int key = 0;
        for(int i = 0;i < 10;i++){
            key = (key << 2) | convert(chars[i]);
        }
        map.put(key,1);
        int mask = (-1) >>> 12;
        for(int i = 10;i < chars.length;i++){
            key = ((key << 2) | convert(chars[i])) & mask;

            Integer count = map.get(key);
            if(count == null){
                count = 0;
            }else if(count == 1){
                result.add(new String(chars,i - 9,10));
            }
            map.put(key,++count);
        }
        return result;
    }
    private int convert(char c){
        switch(c){
            case 'A':return 0;
            case 'T':return 1;
            case 'C':return 2;
            case 'G':return 3;
        }
        throw new IllegalArgumentException();
    }
}
