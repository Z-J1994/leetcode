package easy;

/**
 * @author zhangjun
 * @version 2020/09/29  21:15
 */
public class Solution476 {
    public int findComplement(int num) {

        int index = 0;
        for(int i = 31;i > 0;i--){
            if(((num >>> i) & 0x1) == 1){
                index = i;
                break;
            }
        }
        int offset = 31 - index;
        num = ~num;
        num <<= offset;
        num >>>= offset;
        return num;
    }
}
