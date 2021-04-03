package easy;

/**
 * @author zhangjun
 * @version 2020/09/22  21:56
 */
public class Solution461 {
    public int hammingDistance(int x, int y) {
        int count = 0;
        x ^= y;
        if((x & 0x1) == 1){
            count++;
        }
        while(x > 0){
            if(((x >>= 1) & 0x1) == 1){
                count++;
            }
        }
        return count;
    }
}
