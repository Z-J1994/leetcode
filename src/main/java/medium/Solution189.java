package medium;

import java.util.Arrays;

public class Solution189 {
    public void rotate(int[] nums, int k) {
        if(k == 0){
            return;
        }
        int length = nums.length;

        int gcd = length;
        int t = k;

        while(t != 0){
            int r = gcd % t;
            gcd = t;
            t = r;
        }

        for(int i = 0,j,from;i < gcd;i++){
            j = i;
            from = nums[j];
            do{
                j = (j + k) % length;
                int to = nums[j];
                nums[j] = from;
                from = to;
            }while(j != i);
        }
    }

    public static void main(String[] args) {
        Solution189 s = new Solution189();

        int [] nums1 = {1,2,3,4,5,6,7};
        int k1 = 3;

        int [] nums2 = {-1,-100,3,99};
        int k2 = 2;
        int [] nums3 = {1,2,3,4,5,6};
        int k3 = 4;

        s.rotate(nums1,k1);
        System.out.println(Arrays.toString(nums1));

        s.rotate(nums2,k2);
        System.out.println(Arrays.toString(nums2));

        s.rotate(nums3,k3);
        System.out.println(Arrays.toString(nums3));
    }
}
