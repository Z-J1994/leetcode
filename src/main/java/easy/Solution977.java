package easy;

/**
 * @author zhangjun
 * @version 2020/09/27  20:39
 */
public class Solution977 {
    public int[] sortedSquares(int[] A) {
        int length = A.length;
        int p = 0;
        int [] result = new int[length];
        while(p < length && A[p] < 0){
            p++;
        }
        int i = 0,j = p - 1;
        while (j >= 0 && p < length){
            int aj = A[j] * A[j];
            int ak = A[p] * A[p];
            if(aj > ak){
                result[i++] = ak;
                p++;
            }else{
                result[i++] = aj;
                j--;
            }
        }
        while(j >= 0){
            result[i++] = A[j] * A[j];
            j--;
        }
        while(p < length){
            result[i++] = A[p] * A[p];
            p++;
        }
        return result;
    }
}
