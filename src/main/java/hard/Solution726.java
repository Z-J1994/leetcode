package hard;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author zhangjun
 * @version 2021/7/5
 */
public class Solution726 {
    public String countOfAtoms(String formula) {
        int length = formula.length();
        char [] chars = formula.toCharArray();
        LinkedList<Map<String,Integer>> stack = new LinkedList<>();
        Map<String,Integer> current = new HashMap<>();
        int index = 0;
        int count = 0;
        for(int i = 0;i < length;i++){
            char c = chars[i];
            if(c >= 'A' && c <= 'Z'){
                if(count > 0){
                    String key = new String(chars,index,count);
                    int t = current.getOrDefault(key,0);
                    current.put(key,t + 1);
                    index = i;
                    count = 0;
                }
                count++;
            }else if(c >= '0' && c<= '9'){
                int m = c - 48;
                while(i + 1 < length && chars[i + 1] >= '0' && chars[i + 1] <= '9'){
                    ++i;
                    m = m * 10 + chars[i] - 48;
                }
                String key = new String(chars,index,count);
                int t = current.getOrDefault(key,0);
                current.put(key,t + m);
                index = i + 1;
                count = 0;
            }else if(c == '('){
                if(count > 0){
                    String key = new String(chars,index,count);
                    int t = current.getOrDefault(key,0);
                    current.put(key,t + 1);
                }
                index = i + 1;
                count = 0;
                stack.push(current);
                current = new HashMap<>();
            }else if(c == ')'){
                if(count > 0){
                    String key = new String(chars,index,count);
                    int t = current.getOrDefault(key,0);
                    current.put(key,t + 1);
                }
                int factor = 0;
                while(i + 1 < length && chars[i + 1] >= '0' && chars[i + 1] <= '9'){
                    i++;
                    factor = factor * 10 + chars[i] - 48;
                }
                if(factor == 0){
                    factor = 1;
                }
                Map<String,Integer> previous = stack.pop();
                for(Map.Entry<String,Integer> e : current.entrySet()){
                    int t = previous.getOrDefault(e.getKey(),0);
                    previous.put(e.getKey(),t + e.getValue() * factor);
                }
                current = previous;
                index = i + 1;
                count = 0;
            }else{
                ++count;
            }
        }
        if(count != 0){
            String key = new String(chars,index,count);
            int t = current.getOrDefault(key,0);
            current.put(key,t + 1);
        }
        String [] strs = current.keySet().toArray(new String[0]);
        Arrays.sort(strs);
        StringBuilder sb = new StringBuilder();
        for(String s : strs){
            sb.append(s);
            int c = current.get(s);
            if(c != 1){
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
