package easy;

/**
 * @author zhangjun
 * @version 2021/8/20
 */
public class Solution541 {
    public String reverseStr(String s, int k) {
        char [] chars = s.toCharArray();
        int length = s.length();
        boolean b = true;
        if(length < k){
            reverse(chars,0,length - 1);
            b = !b;
        }
        int i = k;
        while(i <= length){
            if(b){
                reverse(chars,i - k,i - 1);
            }
            b = !b;
            i += k;
        }
        if(i - k < length && b){
            reverse(chars,i - k,length - 1);
        }
        return new String(chars);
    }

    private void reverse(char [] chars ,int lo,int hi){
        while(lo < hi){
            char c = chars[lo];
            chars[lo] = chars[hi];
            chars[hi] = c;
            ++lo;
            --hi;
        }
    }
}
