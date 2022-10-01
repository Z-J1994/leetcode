package hard;

import utils.Parser;

import java.util.Arrays;

/**
 * @author zhangjun
 * @version 2022/9/26
 */
public class Interview17_19 {
    public int[] missingTwo(int[] nums) {
        int n1 = nums.length + 1;
        int n2 = nums.length + 2;
        for(int i = 0,index;i < nums.length;i++){
            while(nums[i] > 0 && nums[i] != i + 1){
                index = nums[i] - 1;
                if(index == nums.length){
                    nums[i] = -1;
                    n1 = -1;
                    break;
                }else if(index > nums.length){
                    nums[i] = -1;
                    n2 = -1;
                    break;
                }
                int t = nums[index];
                nums[index] = nums[i];
                nums[i] = t;
            }
        }
        int j = 0;
        int [] result = new int[2];
        if(n1 != -1){
            result[j++] = n1;
        }
        if(n2 != -1){
            result[j++] = n2;
        }
        if(j < 2){
            for(int i = 0;i < nums.length;i++){
                if(nums[i] == -1){
                    result[j++] = i + 1;
                }
            }
        }
        return result;
    }


    public static void main(String[] args) {
        Interview17_19 i = new Interview17_19();
        System.out.println(Arrays.toString(i.missingTwo(Parser.StringToIntArray("[1]"))));
        System.out.println(Arrays.toString(i.missingTwo(Parser.StringToIntArray("[2,3]"))));
    }
}
