package easy;

/**
 * @author zhangjun
 * @version 2020/09/22  23:11
 */
public class Solution709 {
//    public String toLowerCase(String str) {
//        return str.toLowerCase();
//    }

    /**
     *          大写变小写、小写变大写 : 字符 ^= 32;
     *         大写变小写、小写变小写 : 字符 |= 32;
     *         小写变大写、大写变大写 : 字符 &= -33;
     *
     *         65(A)->二进制表示为100 0001
     *         32的二进制表示为 010 0000
     *         100 0001|010 0000=110 0001->97(a)
     *
     *
     * */
    public String toLowerCase(String str) {
        char [] chars = str.toCharArray();
        for(int i = 0;i < chars.length;i++){
            chars[i] |= 32;
        }
        return new String(chars);
    }

}
