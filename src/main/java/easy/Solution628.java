package easy;

/**
 * @author zhangjun
 * @date 2021/1/20
 */
public class Solution628 {
    public int maximumProduct(int[] nums) {
        int length = nums.length;
        int max1 = nums[0];
        int max2 = nums[1];
        int max3 = nums[2];

        if(max1 < max2){
            int t = max1;
            max1 = max2;
            max2 = t;
        }

        if(max1 < max3){
            int t = max1;
            max1 = max3;
            max3 = t;
        }

        if(max2 < max3){
            int t = max2;
            max2 = max3;
            max3 = t;
        }

        int min1 = max3;
        int min2 = max2;

        for(int i = 3;i < length;i++){
           int t = nums[i];
           if(t >= max1){
               max3 = max2;
               max2 = max1;
               max1 = t;
           }else if(t >= max2){
               max3 = max2;
               max2 = t;
           }else if(t > max3){
               max3 = t;
           }

           if(t <= min1){
               min2 = min1;
               min1 = t;
           }else if(t < min2){
               min2 = t;
           }
        }

        int t = max1 * max2 * max3;
        int t1 = max1 * min1 * min2;

        return t > t1 ? t : t1;
    }


    public static void main(String[] args) {
        Solution628 s = new Solution628();
        int[] values1 = {1,2,3};
        int[] values2 = {1,2,3,4};
        int[] values3 = {1,2,3,5,-1,-2,-3,-4,-5};
        int[] values4 = {-1,-2,-3,-4};



        System.out.println(s.maximumProduct(values1));
        System.out.println(s.maximumProduct(values2));
        System.out.println(s.maximumProduct(values3));
        System.out.println(s.maximumProduct(values4));
    }
}
