package easy;

/**
 * @author zhangjun
 * @version 2022/11/1
 */
public class Solution1662 {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        int i = 0,j = 0;
        for(int k = 0,l = 0,t;i < word1.length && j < word2.length && word1[i].charAt(k++) == word2[j].charAt(l++);){
            t = k % word1[i].length();
            i += k / word1[i].length();
            k = t;

            t = l % word2[j].length();
            j += l / word2[j].length();
            l = t;
        }
        return i == word1.length && j == word2.length;
    }
}
