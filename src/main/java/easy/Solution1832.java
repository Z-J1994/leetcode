package easy;

/**
 * @author zhangjun
 * @version 2022/12/13
 */
public class Solution1832 {
    public boolean checkIfPangram(String sentence) {
        int t = 0;
        int x = (1 << 26) - 1;
        for(int i = 0,l = sentence.length();i < l && t != x;i++){
            t |= 1 << (sentence.charAt(i) - 'a');
        }
        return x == t;
    }
}
