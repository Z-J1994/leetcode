package easy;

import java.util.HashSet;
import java.util.Set;

/**
 * @author zhangjun
 * @date 2021/2/1
 */
public class Solution888 {
    public int[] fairCandySwap(int[] A, int[] B) {
        int la = A.length - 1;
        int lb = B.length - 1;

        int sumA = 0;
        for(int i = 0;i <= la;i++){
            sumA += A[i];
        }

        Set<Integer> set = new HashSet<>();

        int sumB= 0;
        for(int i = 0;i <= lb;i++){
            sumB += B[i];
            set.add(B[i]);
        }

        if(sumA == sumB){
            return new int[]{0,0};
        }

        int t = (sumA - sumB) / 2;

        for(int i = 0;i <= la;i++){
            int key = A[i] - t;
            if(set.contains(key)){
                return new int[]{A[i],key};
            }
        }

        return null;
    }
}
