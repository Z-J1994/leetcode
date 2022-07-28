package easy;

/**
 * @author zhangjun
 * @since 2022/7/28 12:40
 */
public class Solution1399 {
    public int countLargestGroup(int n) {
        int[] count = new int[37];
        for (int i = 1; i <= n; i++) {
            int s = 0;
            for (int j = i; j > 0; j /= 10) {
                s += j % 10;
            }
            count[s]++;
        }
        int maxIndex = 0;
        int maxCount = 0;
        for(int i = 1;i < 37;i++){
            if(count[i] > count[maxIndex]){
                maxIndex = i;
                maxCount = 1;
            }else if(count[i] == count[maxIndex]){
                maxCount++;
            }
        }
        return maxCount;
    }
}
