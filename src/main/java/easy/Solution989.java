package easy;

import java.util.*;

/**
 * @author zhangjun
 * @date 2021/1/22
 */
public class Solution989 {
    public List<Integer> addToArrayForm(int[] A, int K) {
        int index = A.length - 1;
        LinkedList<Integer> result = new LinkedList<>();
        int carry = 0;
        while(index >= 0 && K > 0){
            int t = A[index--] + K % 10 + carry;
            carry = t / 10;
            t = t - carry * 10;
            K /= 10;
            result.addFirst(t);
        }
        while(index >= 0){
            int t = A[index--] + carry;
            carry = t / 10;
            t = t - carry * 10;
            result.addFirst(t);
        }

        while(K > 0){
            int t = K % 10 + carry;
            carry = t / 10;
            t = t - carry * 10;
            K /= 10;
            result.addFirst(t);
        }
        if(carry > 0){
            result.addFirst(carry);
        }
        return result;
    }

    public static void main(String[] args) {
        Solution989 s = new Solution989();
        int [] A1 = {9,9,9,9,9,9,9,9,9,9};
        int K1 = 1;

        for(int t : s.addToArrayForm(A1,K1)){
            System.out.println(t);
        }

    }
}
