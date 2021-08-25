package easy;

/**
 * description
 *
 * @author zhangjun
 * data 2021/08/25 12:52
 */
public class LCS01 {
    public int leastMinutes(int n) {
        int count = 1;
        for(int i = 1;i < n;i <<= 1,count++);
        return count;
    }
}
