package easy;

/**
 * @author zhangjun
 * @version 2020/09/28  19:19
 */
public class Solution1550 {
    public boolean threeConsecutiveOdds(int[] arr) {
        int count = 0;
        for(int i = 0;i < arr.length;i++){
            if((arr[i] & 0x1) == 1){
                count++;
                if(count == 3){
                    return true;
                }
            }else{
                count = 0;
            }
        }
        return false;
    }
}
