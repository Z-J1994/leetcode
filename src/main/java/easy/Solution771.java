package easy;

/**
 * @author zhangjun
 * @version 2020/09/19  13:21
 */
public class Solution771 {
    public int numJewelsInStones(String J, String S) {
        int lower = 0;
        int upper = 0;
        int count = 0;
        for(int i = 0;i < J.length();i++){
            char c = J.charAt(i);
            if(c > 'Z'){
                upper |= 1 << (c - 97);
            }else{
                lower |= 1 <<(c - 65);
            }
        }

        for(int i = 0;i < S.length();i++){
            char c = S.charAt(i);
            if(c > 'Z' && ((upper >>> (c - 97)) & 1) == 1){
                count++;
            }else if(c <= 'Z' && ((lower >>> (c - 65)) & 1) == 1){
                count++;
            }
        }
        return count;
    }
}
