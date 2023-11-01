package medium;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhangjun
 * @version 2023/1/12
 */
public class Solution1807 {

    public String evaluate(String s, List<List<String>> knowledge) {
        Map<String,String> map = new HashMap<>();
        for(List<String> list : knowledge){
            map.put(list.get(0),list.get(1));
        }

        StringBuilder builder = new StringBuilder(s.length());
        for(int i = 0,l = s.length();i < l;i++){
            char c = s.charAt(i);
            if(c == '('){
                int j = i + 1;
                while(s.charAt(j) != ')'){
                    j++;
                }
                String key = s.substring(i+1,j);
                String t = map.get(key);
                if(t != null){
                    builder.append(t);
                }else{
                    builder.append('?');
                }
                i = j;
            }else{
                builder.append(c);
            }
        }
        return builder.toString();
    }

}
