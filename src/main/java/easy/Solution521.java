package easy;

/**
 * @author zhangjun
 * @version 2020/09/29  15:49
 */
public class Solution521 {
    public int findLUSlength(String a, String b) {
        if (a.length() != b.length()) {
            return Math.max(a.length(), b.length());
        }
        char[] ca = a.toCharArray();
        char[] cb = b.toCharArray();
        for(int length = ca.length;length > 0;length--){
            for(int offset = 0;offset + length <= ca.length;offset++){
                if(operation(ca,offset,cb,length)){
                    return length;
                }
            }
        }
        return -1;
    }

    private boolean operation(char [] ca,int offset,char [] cb,int length){
        for(int i = 0,k = 0;i + length <= cb.length;i++){
            if(ca[offset + k] == cb[i]){
                k++;
                int j = i + 1;
                for(;k < length && (ca[offset + k] == cb[j]);){
                    j++;
                    k++;
                }
                if(k == length){
                    return false;
                }
            }
            k = 0;
        }
        return true;
    }
}
