package medium;

/**
 * @author zhangjun
 * @date 2021/2/19
 */
public class Solution1004 {
    public int longestOnes(int[] A, int K) {
        int length = A.length;
        int max = 0;
        int l = 0;
        int r = 0;
        int len = 0;
        while(r < length){
            if(A[r] == 1){
                r++;
                len++;
                max = len > max ? len : max;
            }else if(K > 0){
                r++;
                K--;
                len++;
                max = len > max ? len : max;
            }else{
                while(A[l] == 1){
                    l++;
                    len--;
                }
                l++;
                K++;
                len--;
            }
        }

        return max;
    }
}
