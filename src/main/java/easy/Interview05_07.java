package easy;

/**
 *
 * @author zhangjun
 * @version 2020/09/29  21:49
 */
public class Interview05_07 {
    public int exchangeBits(int num) {
        int result = 0;

        for(int i = 31;i > 0;){
            result |= ((num >>> i) & 0x1) << (i - 1);
            i--;
            result |= ((num >>> i) & 0x1) << (i + 1);
            i--;
        }
        return result;
    }
}
