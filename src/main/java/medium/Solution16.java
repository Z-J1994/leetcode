package medium;

import java.util.Arrays;

public class Solution16 {
    public int threeSumClosest(int[] nums, int target) {
        int length = nums.length - 1;
        sort(nums,0,length);
        System.out.println(Arrays.toString(nums));

        int start = 0;
        int last = nums[length] + nums[length - 1];
        while(start < length - 1 && last + nums[start] < target){
            start++;
        }

        if(start == length - 1){
            return last + nums[start - 1];
        }
        if(start > 0){
            start--;
        }

        int close = Integer.MAX_VALUE;

        for(int i = start,iv,pi = nums[0] - 1;i < length;i++){
            iv = nums[i];
            if(pi == iv){
                continue;
            }
            pi = iv;
            int j = i + 1,jv = nums[j],pj = nums[j] - 1,l = length,lv = nums[l];

            while(j < l){
                if(jv == pj){
                    j++;
                    jv = nums[j];
                    continue;
                }
                int min = iv + jv + lv - target;
                if(Math.abs(min) < Math.abs(close)){
                    close = min;
                }
                if(min > 0){
                    l--;
                    lv = nums[l];
                }else if(min < 0){
                    j++;
                    pj = jv;
                    jv = nums[j];
                }else{
                    return min + target;
                }
            }
        }

        return close + target;
    }

    private void sort(int [] array,int lo,int hi){
        if(lo + 15 >= hi){
            insertion(array, lo, hi);
            return;
        }
        int p = randomPartition(array, lo, hi);
        sort(array,lo,p - 1);
        sort(array,p + 1,hi);
        assert isSorted(array, lo, hi);
    }

    private int randomPartition(int [] array,int lo,int hi){
        int m = (lo + hi) / 2;
        int left = array[lo];
        int right = array[hi];
        int middle = array[m];

        if(right < left){
            int t = right;
            right = left;
            left = t;
        }

        if(right < middle){
            int t = right;
            right = middle;
            middle = t;
        }

        if(left > middle){
            int t = left;
            left = middle;
            middle = t;
        }
        array[lo] = middle;
        array[hi] = right;
        array[m] = left;
        return partition(array, lo, hi);
    }

    private int partition(int [] array,int lo,int hi){
        int v = array[lo];
        int i = lo;
        int j = hi + 1;

        while(i < j){
            while(array[++i] < v);
            while(array[--j] > v);

            if(i < j){
                int t = array[i];
                array[i] = array[j];
                array[j] = t;
            }
        }

        array[lo] = array[j];
        array[j] = v;

        return j;
    }

    private void insertion(int [] array,int lo,int hi){
        for(int i = lo + 1,j;i <= hi;i++){
            int t = array[i];
            for(j = i;j > lo && array[j - 1] > t;j--){
                array[j] = array[j - 1];
            }
            array[j] = t;
        }
        assert isSorted(array, lo, hi);
    }

    private boolean isSorted(int [] array,int lo,int hi){
        for(int i = lo + 1,p = array[lo];i <= hi;i++){
            int c = array[i];
            if(p > c){
                return false;
            }
            p = c;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution16 s = new Solution16();

        int [] nums1 = {-1,2,1,-4};
        int t1 = 1;

        int [] nums2 = {0,2,1,-3};
        int t2 = 1;

        int [] nums3 = {10,0,-2,3,-8,1,-10,8,-8,6,-7,0,-7,2,2,-5,-8,1,-4,6};
        int t3 = 18;

        int [] nums4 = {-4,-7,-2,2,5,-2,1,9,3,9,4,9,-9,-3,7,4,1,0,8,5,-7,-7};
        int t4 = 29;

//        System.out.println(s.threeSumClosest(nums1,t1));//2
//        System.out.println(s.threeSumClosest(nums2,t2));//0
//        System.out.println(s.threeSumClosest(nums3,t3));//18
        System.out.println(s.threeSumClosest(nums4,t4));//27

    }
}
