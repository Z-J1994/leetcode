package easy;

/**
 * @author zhangjun
 * @version 2021/5/6
 */
public class Solution1720 {
    public int[] decode(int[] encoded, int first) {
        int length = encoded.length;
        int [] decode = new int[length + 1];
        decode[0] = first;
        for(int i = 0;i < length;i++){
            decode[i + 1] = encoded[i] ^ decode[i];
        }
        return decode;
    }
}
