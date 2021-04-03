package medium;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution15 {

    public List<List<Integer>> threeSum(int[] nums) {
        int length = nums.length - 1;
        List<List<Integer>> result = new ArrayList<>();
        sort(nums,0,length);

        //pi设置为不与nums[0]想等的数字，可以是任意正数，排序之后nums[0]若是正数则无解
        for(int i = 0,iv,pi = 1;i < length - 1;i++){
            iv = nums[i];
            if(iv > 0){
                return result;
            }
            if(iv == pi){
                continue;
            }
            pi = iv;
            for(int j = i + 1,jv,pj = iv - 1,key,lj = length;j < lj;j++){
                jv = nums[j];
                if(jv == pj){
                    continue;
                }
                key = -iv - jv;
                if(key < 0){
                    break;
                }
                pj = jv;
                while(lj > j && nums[lj] > key){
                    lj--;
                }
                if(lj == j){
                    break;
                }
                if(nums[lj] == key){
                    result.add(new ArrayList<>(Arrays.asList(iv,jv,nums[lj])));
                }

            }
        }
        return result;
    }

    private void sort(int [] array,int lo,int hi){
        if(lo + 15 >= hi){
            insertion(array, lo, hi);
            return;
        }
        int lt = lo;
        int v = array[lt];

        int gt = hi;
        int i = lo + 1;

        while(i <= gt){
            int t = array[i];
            if(t < v){
                array[lt++] = t;
                array[i++] = v;

            }else if(t > v){
                int x = array[gt];
                array[gt--] = t;
                array[i] = x;
            }else{
                i++;
            }
        }
        sort(array, lo, lt - 1);
        sort(array, gt + 1, hi);
    }

    private void insertion(int [] array,int lo,int hi){
        for(int i = lo + 1,j;i <= hi;i++){
            int m = array[i];
            for(j = i; j > lo && array[j - 1] > m;j--){
                array[j] = array[j - 1];
            }
            array[j] = m;
        }
    }



    public static void main(String[] args) {
        Solution15 s = new Solution15();

        int [] nums1 = {-1, 0, 1, 2, -1, -4};
        int [] nums2 = {34,55,79,28,46,33,2,48,31,-3,84,71,52,-3,93,15,21,-43,57,-6,86,56,94,74,83,-14,28,-66,46,-49,62,-11,43,65,77,12,47,61,26,1,13,29,55,-82,76,26,15,-29,36,-29,10,-70,69,17,49};
        int [] nums3 = {0,1,-1};
        int [] nums4 = {-1,0,1,2,-1,-4,-2,-3,3,0,4};
        int [] nums5 = {1,-1,-1,0};
        int [] nums6 = {};
//        System.out.println(s.threeSum(nums1).toString());
//        System.out.println(s.threeSum(nums2).toString());
//        System.out.println(s.threeSum(nums3).toString());
//        System.out.println(s.threeSum(nums4).toString());
//        System.out.println(s.threeSum(nums5).toString());
        System.out.println(s.threeSum(nums6).toString());
    }
}
