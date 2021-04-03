package easy;

/**
 * @author zhangjun
 * @version 2020/10/02  16:12
 */
public class Solution922 {
    public int[] sortArrayByParityII(int[] A) {
        for(int i = 0,j = A.length - 1;i < A.length && j > 0;){
            while(i < A.length && (A[i] & 0x1) == 0){
                i += 2;
            }
            while(j > 0 && (A[j] & 0x1) == 1){
                j -= 2;
            }
            if(i < A.length && j > 0){
                int t = A[i];
                A[i] = A[j];
                A[j] = t;
            }
        }
        return A;
    }
}
