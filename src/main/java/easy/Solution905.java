package easy;

/**
 * @author zhangjun
 * @version 2020/09/29  19:42
 */
public class Solution905 {

    public int[] sortArrayByParity(int[] A) {
        int i = 0, j = A.length - 1;
        while (i < j) {
            if ((A[i] & 0x1) > (A[j] & 0x1)) {
                int tmp = A[i];
                A[i] = A[j];
                A[j] = tmp;
            }

            if ((A[i] & 0x1) == 0) i++;
            if ((A[j] & 0x1) == 1) j--;
        }
        return A;
    }
}
