package easy;

/**
 * @author zhangjun
 * @since 2022/8/9 12:37
 */
public class Solution1413 {
    public int minStartValue(int[] nums) {
        int s = 0;
        int min = 0;
        for(int i : nums){
            s += i;
            if(s < min){
                min = s;
            }
        }
        return 1 - min;
    }
}
