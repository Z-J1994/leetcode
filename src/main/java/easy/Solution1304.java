package easy;

/**
 * @author zhangjun
 * @version 2020/09/24  22:43
 */
public class Solution1304 {
    public int[] sumZero(int n) {
        int [] result = new int[n];
        int mid = n / 2;
        if(n % 2 == 1){
            result[mid] = 0;
        }
        int t = 1;
        for(int i = 0,j = n - 1;i < j;i++,j--){
            result[i] = t;
            result[j] = -t;
            t++;
        }
        return result;
    }
}
