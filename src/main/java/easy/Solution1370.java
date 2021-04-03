package easy;

/**
 * @author zhangjun
 * @version 2020/09/24  22:51
 */
public class Solution1370 {
    public String sortString(String s) {
        int [] chars = new int[26];
        char [] str = new char[s.length()];
        for(int i = 0;i < s.length();i++){
            chars[s.charAt(i) - 97]++;
        }

        for(int i = 0; i < str.length;){
            for(int j = 0;j < 26;j++){
                if(chars[j] > 0){
                    chars[j]--;
                    str[i++] = (char)(j + 97);
                }
            }
            for(int j = 25;j >= 0;j--){
                if(chars[j] > 0){
                    chars[j]--;
                    str[i++] = (char)(j + 97);
                }
            }
        }
        return new String(str);
    }
}
