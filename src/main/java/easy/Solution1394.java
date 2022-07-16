package easy;

/**
 * @author zhangjun
 * @since 2022/7/12 12:35
 */
public class Solution1394 {
    public int findLucky(int[] arr) {
        int [] map = new int[501];
        for(int i : arr){
            map[i]++;
        }
        for(int i = 500;i > 0;i--){
            if(map[i] == i){
                return i;
            }
        }
        return -1;
    }
}
