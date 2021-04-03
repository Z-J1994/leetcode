package easy;

/**
 * @author zhangjun
 * @version 2020/10/01  15:17
 */
public class Solution908 {
    public int smallestRangeI(int[] A, int K) {
        int min = 0;
        int max = 0;
        for(int i = 0;i < A.length;i++){
            if(A[i] > A[max]){
                max = i;
            }
            if(A[i] < A[min]){
                min = i;
            }
        }
        int t = A[max] - A[min];
        return t < 2 * K ? 0 : t - 2*K;
    }

//    public int smallestRangeI(int[] A, int K) {
//        int min = 10000;
//        int max = 0;
//        for(int i = 0;i < A.length;i++){
//            if(A[i] > max){
//                max = A[i];
//            }
//            if(A[i] < min){
//                min = A[i];
//            }
//        }
//        int t = max - min;
//        return t < 2 * K ? 0 : t - 2*K;
//    }
}
