package medium;

/**
 * @author zhangjun
 * @version 2021/8/29
 */
public class Solution740 {
    public int deleteAndEarn(int[] nums) {
        int [] data = new int[10001];
        int n = 0;
        int max = 0;
        for(int t : nums){
            if(t > max){
                max = t;
            }
            data[t] += t;
        }
        int a = 0,b = 0,c = 0;
        for(int i = 1;i <= max;i++){
            c = Math.max(a + data[i],b);
            a = b;
            b = c;
        }
        return c;
    }
}
