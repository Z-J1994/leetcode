package easy;

/**
 * @author zhangjun
 * @version 2020/09/20  15:48
 */
public class Solution1342 {
    public int numberOfSteps (int num) {
        int count = 0;
        while(num > 0){
            if (num % 2 == 0) {
                num >>= 1;
            } else {
                num--;
            }
            count++;
        }
        return count;
    }
}
