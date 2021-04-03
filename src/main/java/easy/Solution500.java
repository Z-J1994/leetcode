package easy;

/**
 * @author zhangjun
 * @version 2020/09/28  16:56
 */
public class Solution500 {
    public String[] findWords(String[] words) {
        int [] map = {1, 2, 2, 1, 3, 1, 1, 1, 3, 1, 1, 1, 2, 2, 3, 3, 3, 3, 1, 3, 3, 2, 3, 2, 3, 2};
        StringBuilder result = new StringBuilder();
        for(int i = 0;i < words.length;i++){
            boolean marked = true;
            for(int j = 1;j < words[i].length();j++){
                char p = words[i].charAt(j - 1);
                char c = words[i].charAt(j);
                if(p < 97){
                    p += 32;
                }
                if(c < 97){
                    c+=32;
                }
                if(map[p - 97] != map[c - 97]){
                    marked = false;
                }
            }
            if(marked){
                result.append(words[i]).append(",");
            }
        }
        String [] str = result.toString().split(",");
        if(str.length == 1 && str[0].isBlank()){
            return new String [0];
        }
        return str;
    }
}
