package easy;

/**
 * @author zhangjun
 * @version 2020/09/20  19:35
 */
public class Solution5503 {
//枚举
//    public int sumOddLengthSubarrays(int[] arr) {
//        int sum = 0;
//        for(int i = 1;i <= arr.length;i+=2){
//            for(int j = 0;j < arr.length;j++){
//                if(j + i <= arr.length){
//                    for(int k = j;k < j+i;k++){
//                        sum += arr[k];
//                    }
//                }
//            }
//        }
//        return sum;
//    }
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
