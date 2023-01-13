package easy;

/**
 * @author zhangjun
 * @version 2023/1/13
 */
public class Solution2287 {
    public int rearrangeCharacters(String s, String target) {
        int [] map = new int [26];
        int [] template = new int[26];
        for(int i = 0,l = target.length();i < l;i++){
            template[target.charAt(i) - 'a']++;
        }

        for(int i = 0,index,l = s.length();i < l;i++){
            index = s.charAt(i) - 'a';
            if(template[index] > 0){
                map[index]++;
            }
        }
        int min = 101;
        for(int i = 0,t;i < 26;i++){
            if(template[i] > 0 && (t = map[i] / template[i])  < min){
                min = t;
            }
        }
        return min;
    }
}
