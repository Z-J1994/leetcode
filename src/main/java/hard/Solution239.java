package hard;

import java.util.Arrays;

public class Solution239 {

//    private int getLength(int length){
//        int n = length - 1;
//
//        n |= n >>> 1;
//        n |= n >>> 2;
//        n |= n >>> 4;
//        n |= n >>> 8;
//        n |= n >>> 16;
//
//        return n + 1;
//    }
//
//    public int[] maxSlidingWindow(int[] nums, int k) {
//        if(k == 1){
//            return nums;
//        }
//        int length = nums.length;
//        int qLength = getLength(k) - 1;
//        int [] queue = new int[qLength + 1];
//        int head = 0;
//        int tail = 0;
//
//        int []result = new int[length - k + 1];
//
//        for(int i = 1;i < k;i++){
//            int t = nums[i];
//            while(tail >= 0 && nums[queue[tail]] <= t){
//                tail--;
//            }
//            queue[++tail] = i;
//        }
//
//        int j = 0;
//        result[j++] = nums[queue[head]];
//        for(int i = k;i < length;i++){
//            int t = nums[i];
//            while(tail + 1 != head && nums[queue[tail]] <= t){
//                tail--;
//                if(head != 0){
//                    tail &= qLength;
//                }
//            }
//            tail++;
//            queue[tail &= qLength] = i;
//
//            if(queue[head] <= i - k){
//                head++;
//                head &= qLength;
//            }
//            result[j++] = nums[queue[head]];
//        }
//
//        return result;
//    }

    public int[] maxSlidingWindow(int[] nums, int k){
        if(k == 1){
            return nums;
        }
        int length = nums.length;
        int[] left = new int[length];
        int[] right = new int[length];

        for(int i = 0,max = nums[0];i < length;i++){
            if(i % k == 0){
                max = nums[i];
            }else{
                int t = nums[i];
                if(t > max){
                    max = t;
                }
            }
            right[i] = max;
        }

        left[length - 1] = nums[length - 1];
        for(int i = length - 2,max = nums[length - 1];i >= 0;i--){
            if((i + 1) % k == 0){
                max = nums[i];
            }else{
                int t = nums[i];
                if(t > max){
                    max = t;
                }
            }
            left[i] = max;
        }

        int l = length - k + 1;
        int [] result = new int[l];

        for(int i = 0,j = k - 1,a,b;i < l;i++,j++){
            a = left[i];
            b = right[j];
            result[i] = (a >= b) ? a : b;
        }

        return result;
    }


    public static void main(String[] args) {
        Solution239 s = new Solution239();

        int [] nums1 = {1,3,-1,-3,5,3,6,7};
        int k1 = 3;

        int [] nums2 = {1};
        int k2 = 1;

        int [] nums3 = {1,-1};
        int k3 = 1;

        int [] nums4 = {9,11};
        int k4 = 2;

        int [] nums5 = {4,-2};
        int k5 = 2;

        int [] nums6 = {-9361,-750,-8435,-5590,-5835,2958,-3942,-8209,-8241,-9307,7999,9777,-6045,1362,-4022,7045,-1351,9610,-4192,-267,-2120,6657,-9405,-7549,8074,3222,-5563,204,2999,3961,-6798,-53,2349,-6533,-223,1033,7369,-6896,-1756,-127,6161,-7878,9644,2595,-1269,8314,8815,-7448,9973,9797,1802,-6681,6742,-2199,795,6579,2676,9505,-3383,-4465,6993,1317,6608,-8496,-512,-100,5136,686,-2667,1892,-2416,4272,1011,-6260,5780,-2764,-7807,3267,833,-8811,-4751,7541,-2562,5043,-7245,-2427,-6331,147,-2974,759,-2200,-9467,6092,9013,-6563,3810,-4710,-9420,-9173,-7326,1120,-5794,3928,7327,3017,-8873,6524,-7972,-769,-1121,3126,-1586,-2184,-6868,6536,-3325,-9561,-7140,-9483,2271,-6239,-128,6595,-6159,3560,-6865,-8249,1165,5062,-7508,3492,-1801,9877,4857,6104,-7193,9776};
        int k6 = 3;

        System.out.println(Arrays.toString(s.maxSlidingWindow(nums1,k1)));//3,3,5,5,6,7
        System.out.println(Arrays.toString(s.maxSlidingWindow(nums2,k2)));//1
        System.out.println(Arrays.toString(s.maxSlidingWindow(nums3,k3)));//1,-1
        System.out.println(Arrays.toString(s.maxSlidingWindow(nums4,k4)));//11
        System.out.println(Arrays.toString(s.maxSlidingWindow(nums5,k5)));//4
        System.out.println(Arrays.toString(s.maxSlidingWindow(nums6,k6)));//
    }
}
