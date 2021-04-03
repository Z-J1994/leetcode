package easy;

/**
 * @author zhangjun
 * @version 2020/09/19  12:52
 */
public class Solution1486 {
    public int xorOperation(int n, int start) {
        int sum = start;
        for(int i = 1,j = 0;i < n;i++){
            sum ^= (start + 2 * i);
            j++;
        }
        return sum;
    }
}
