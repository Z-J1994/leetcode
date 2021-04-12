package medium;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author zhangjun
 * @version 2021/4/12
 */
public class Solution179 {
    public String largestNumber(int[] nums) {
        Comparator<String> comparator = (String s1, String s2) ->{
            int l1 = s1.length();
            int l2 = s2.length();
            for(int i = 0;i <= l1 *2 && i <= l2 * 2;i++){
                int index1 = i;
                if(index1 >= l1){
                    index1 = index1 % l1;
                }
                int index2 = i;
                if(index2 >= l2){
                    index2 = index2 % l2;
                }
                if(s2.charAt(index2) > s1.charAt(index1)){
                    return 1;
                }else if(s2.charAt(index2) < s1.charAt(index1)){
                    return -1;
                }
            }
            return 0;
        };
        int length = nums.length;
        String [] strNums = new String[length];
        int count = 0;
        for(int i = 0;i < length;i++){
            int t = nums[i];
            if(t == 0){
                ++count;
            }
            strNums[i] = t + "";
        }
        if (count == length){
            return "0";
        }
        Arrays.sort(strNums,comparator);
        StringBuilder sb = new StringBuilder();
        for(String s:strNums){
            sb.append(s);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution179 s = new Solution179();
        int [] nums1 = {10,2};
        int [] nums2 = {3,30,34,5,9};
        int [] nums3 = {34323,3432};

        System.out.println(s.largestNumber(nums1));
        System.out.println(s.largestNumber(nums2));
        System.out.println(s.largestNumber(nums3));
    }
}
