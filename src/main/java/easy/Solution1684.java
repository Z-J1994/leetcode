package easy;

/**
 * @author zhangjun
 * @version 2022/11/8
 */
public class Solution1684 {
    public int countConsistentStrings(String allowed, String[] words) {
        boolean [] alphabet = new boolean[26];
        for(int i = 0 ;i < allowed.length();i++){
            alphabet[allowed.charAt(i) - 'a'] = true;
        }
        int count = 0;
        for(String word : words){
            int f = 1;
            for(int i = 0;i < word.length();i++){
                if(!alphabet[word.charAt(i) - 'a']){
                    f = 0;
                    break;
                }
            }
            count += f;
        }
        return count;
    }
}
