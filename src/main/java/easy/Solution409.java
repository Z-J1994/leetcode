package easy;

/**
 * @author zhangjun
 * @version 2022/3/10
 */
public class Solution409 {
    public int longestPalindrome(String s) {
        int [] alphabet = new int [128];
        for(int i = 0;i < s.length();i++){
            alphabet[s.charAt(i)]++;
        }
        int count = 0;
        for(int i = 'A';i <= 'Z';i++){
            count += (alphabet[i] & -2) + (alphabet[i + 32] & -2);
        }
        return count + (count < s.length() ? 1 : 0);
    }
}
