package easy;

/**
 * @author zhangjun
 * @version 2021/8/29
 */
public class Solution1588 {
    public int sumOddLengthSubarrays(int[] arr) {
        int sum = 0;
        int length = arr.length;
        for(int i = 0;i < length;i++) {
            int left = i + 1;
            int right = length - i;

            int leftEven = (left + 1) / 2;
            int leftOdd = left / 2;

            int rightEven = (right + 1) / 2;
            int rightOdd = right / 2;
            sum += (leftEven * rightEven + leftOdd * rightOdd) * arr[i];
        }
        return sum;
    }
}
