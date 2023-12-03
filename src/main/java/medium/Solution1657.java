package medium;

import java.util.Arrays;

/**
 * @author zhangjun
 * @since 2023/11/30 13:11
 */
public class Solution1657 {

    public boolean closeStrings(String word1, String word2) {
        if(word1.length() != word2.length()){
            return false;
        }
        int [] s1 = new int[26];
        int [] s2 = new int[26];
        for(int i = 0;i < word1.length();i++){
            ++s1[word1.charAt(i) - 97];
            ++s2[word2.charAt(i) - 97];
        }
        for(int i = 0;i < 26;i++){
            if((s1[i] == 0 )  ^ (s2[i] == 0)){
                return false;
            }
            if(s1[i] != s2[i]){
                for(int j = i + 1;j < 26;j++){
                    if(s1[j] != s2[j] && s2[j] == s1[i]){
                        int t = s2[i];
                        s2[i] = s2[j];
                        s2[j] = t;
                        break;
                    }
                }
                if(s1[i] != s2[i]){
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution1657 s = new Solution1657();
        System.out.println(s.closeStrings("abc", "bca") == true);
        System.out.println(s.closeStrings("a", "aa") == false);
        System.out.println(s.closeStrings("cabbba", "abbccc") == true);
        System.out.println(s.closeStrings("cabbba", "aabbss") == false);
        System.out.println(s.closeStrings("uau", "ssx") == false);
    }

}
