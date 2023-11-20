package hard;

import utils.Parser;

import java.util.Arrays;

public class Solution689 {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int s1 = 0, s2 = 0, s3 = 0;
        int kk = k << 1;
        for (int i = 0; i < k; i++) {
            s1 += nums[i];
            s2 += nums[k + i];
            s3 += nums[kk + i];
        }
        int max1 = s1,max2 = max1 + s2,max3 = max2 + s3, a = 0, b = 0,c=k;
        int [] result = {0,k,kk};
        for (int i = k,j = i + k ,l = i + kk ; l < nums.length; i++,j++,l++) {
            s1 += nums[i] - nums[i - k];
            s2 += nums[j] - nums[i];
            s3 += nums[l] - nums[j];
            if(s1 > max1){
                a = i - k + 1;
                max1 = s1;
            }
            if(max1 + s2 > max2){
                b = a;
                c = j - k + 1;
                max2 = max1 + s2;
            }
            if(max2 + s3 > max3){
                result[0] = b;
                result[1] = c;
                result[2] = l - k + 1;
                max3 = max2 + s3;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution689 s = new Solution689();

//        System.out.println(Arrays.toString(s.maxSumOfThreeSubarrays(Parser.StringToIntArray("[1,2,1,2,6,7,5,1]"), 2)));
//        System.out.println(Arrays.toString(s.maxSumOfThreeSubarrays(Parser.StringToIntArray("[1, 2, 1, 2, 1, 2, 1, 2, 1]"), 2)));
//        System.out.println(Arrays.toString(s.maxSumOfThreeSubarrays(Parser.StringToIntArray("[1,2,1,2,2,2,2,2]"), 2)));
        System.out.println(Arrays.toString(s.maxSumOfThreeSubarrays(Parser.StringToIntArray("[1,2,1,2,2,2,2,2]"), 1)));
    }
}
