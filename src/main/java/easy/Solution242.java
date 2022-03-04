package easy;

/**
 * @author zhangjun
 * @version 2022/3/4
 */
public class Solution242 {
    public boolean isAnagram(String s, String t) {
        if (t.length() != s.length()) {
            return false;
        }
        int[] alphabet = new int[26];
        for (int i = 0; i < s.length(); i++) {
            ++alphabet[s.charAt(i) - 97];
            --alphabet[t.charAt(i) - 97];
        }
        for(int i : alphabet){
            if(i != 0){
                return false;
            }
        }
        return true;
    }
}
