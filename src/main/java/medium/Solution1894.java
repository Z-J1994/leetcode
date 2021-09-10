package medium;

/**
 * @author zhangjun
 * @version 2021/9/10
 */
public class Solution1894 {
    public int chalkReplacer(int[] chalk, int k) {
        int length = chalk.length - 1;
        long sum = 0;
        for(int i = 0;i <= length;i++){
            sum += chalk[i];
            if(sum > k){
                return i;
            }
        }
        long t = k % sum;
        int i = -1;
        while(t >= 0){
            t -= chalk[++i];
        }
        return i;
    }
}
