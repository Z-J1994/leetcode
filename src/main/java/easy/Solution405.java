package easy;

/**
 * @author zhangjun
 * @version 2020/10/09  20:10
 */
public class Solution405 {
    public String toHex(int num) {
        if(num == 0){
            return "0";
        }
        StringBuilder result = new StringBuilder();
        String [] alphabet = {"0","1","2","3","4","5","6","7","8","9","a","b","c","d","e","f"};
        while(num != 0){
            int t = num & 0xF;
            num >>>= 4;
            result.append(alphabet[t]);
        }
        return result.reverse().toString();
    }
}
