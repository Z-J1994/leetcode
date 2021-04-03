package easy;

/**
 * @author zhangjun
 * @version 2020/09/20  18:54
 */
public class Solution1295 {

    public int findNumbers(int[] nums) {
        int count = 0;
        for(int i = 0;i < nums.length;i++){
            int t = nums[i];
            int cnt = 0;
            while(t > 0){
                t /= 10;
                cnt++;
            }
            if(cnt % 2 == 0){
                count++;
            }
        }
        return  count;
    }

}
