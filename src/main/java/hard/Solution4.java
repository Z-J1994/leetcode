package hard;

public class Solution4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;
        if(length1 == 0 && length2 == 0){
            return 0;
        }
        if(length1 == 0){
            int t = length2 / 2;
            if((length2 & 1) == 1){
                return nums2[t];
            }
            return (nums2[t - 1] + nums2[t]) / 2.0;
        }
        if(length2 == 0){
            int t = length1 / 2;
            if((length1 & 1) == 1){
                return nums1[t];
            }
            return (nums1[t - 1] + nums1[t]) / 2.0;
        }
        int length = length1 + length2;
        int [] array = new int[length];

        int i = 0,j = 0,k = 0;
        while(i < length1 && j < length2){
            if(nums1[i] < nums2[j]){
                array[k++] = nums1[i++];
            }else {
                array[k++] = nums2[j++];
            }
        }

        while(i < length1){
            array[k++] = nums1[i++];
        }

        while(j < length2){
            array[k++] = nums2[j++];
        }
        int t = length / 2;


        return ((length & 1) == 1) ? array[t] : (array[t - 1] + array[t]) / 2.0;
    }


    public static void main(String[] args) {
        Solution4 s = new Solution4();

        int [] n1 = {1,3};
        int [] p1 = {2};

        int [] n2 = {1,2};
        int [] p2 = {3,4};

        int [] n3 = {0,0};
        int [] p3 = {0,0};

        int [] n4 = {};
        int [] p4 = {1};

        int [] n5 = {2};
        int [] p5 = {};

        System.out.println(s.findMedianSortedArrays(n1,p1));//2.0
        System.out.println(s.findMedianSortedArrays(n2,p2));//2.5
        System.out.println(s.findMedianSortedArrays(n3,p3));//0.0
        System.out.println(s.findMedianSortedArrays(n4,p4));//1.0
        System.out.println(s.findMedianSortedArrays(n5,p5));//2.0
    }



}
