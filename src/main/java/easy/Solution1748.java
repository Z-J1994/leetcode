package easy;

/**
 * @author zhangjun
 * @version 2022/2/6
 */
public class Solution1748 {
    public int sumOfUnique(int[] nums) {
        int [] map = new int[101];
        for(int i : nums){
            map[i]++;
        }
        int sum = 0;
        for(int i = 0;i < 101;i++){
            if(map[i] == 1){
                sum += i;
            }
        }
        return sum;
    }
}
