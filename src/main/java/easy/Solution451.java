package easy;

/**
 * @author zhangjun
 * @version 2021/7/3
 */
public class Solution451 {
    public String frequencySort(String s) {
        char [] chars = new char[128];
        int limit = 0;
        for(int i = 0,l = s.length();i < l;i++){
            char c = s.charAt(i);
            chars[c]++;
            if(c > limit){
                limit = c;
            }
        }
        char [] result = new char[s.length()];
        int index = 0;
        for(boolean f = false;!f;){
            f = true;
            int max = 0;
            for(int i = 0;i <= limit;i++){
                if(chars[i] > chars[max]){
                    f = false;
                    max = i;
                }
            }
            int count = chars[max];
            while(count-- > 0){
                result[index++] = (char)max;
            }
            chars[max] = 0;
        }
        return new String(result);
    }
}
