package easy;

/**
 * @author zhangjun
 * @version 2020/09/27  18:47
 */
public class Solution642 {
    public int[] diStringMatch(String S) {
        int length = S.length();
        int [] result = new int[length + 1];
        result[length] = length;
        int pre = 0;
        int post = length;
        int i = 0;
        for(char c : S.toCharArray()){
            if(c == 'D'){
                result[i++] = post--;
            }else if(c == 'I'){
                result[i++] = pre++;
            }
        }
        result[length] = pre;
        return result;
    }
}
