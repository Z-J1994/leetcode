package easy;

/**
 * @author zhangjun
 * @version 2020/09/18  20:37
 */
public class Solution1512 {
    private int count;
    public int numIdenticalPairs(int[] nums) {
        count = 0;
        sort(nums,0,nums.length - 1);
        return count;
    }

    private void sort(int []nums,int lo,int hi){
        if(hi > lo){
            int mid = (hi - lo) / 2 + lo;
            sort(nums,lo,mid);
            sort(nums,mid + 1,hi);
            merge(nums,lo,mid,hi);
        }
    }
    private void merge(int []nums,int lo,int mid,int hi){
        int [] left = new int[mid - lo + 1];
        int [] right = new int[hi - mid];
        for(int i = 0;i < left.length;i++){
            left[i] = nums[i + lo];
        }
        for(int i = 0;i < right.length;i++){
            right[i] = nums[mid + i + 1];
        }
        int i,j,k;
        for(i = 0,j = 0,k = lo;i < left.length && j < right.length;k++){
            if(left[i] < right[j]){
                nums[k] = left[i];
                i++;
            }else if(left[i] > right[j]){
                nums[k] = right[j];
                j++;
            }else{
                int h = j + 1;
                count++;
                while(h < right.length && left[i] == right[h]){
                    h++;
                    count++;
                }
                nums[k] = left[i];
                i++;
            }
        }
        while(i < left.length){
            nums[k++] = left[i++];
        }
        while(j < right.length){
            nums[k++] = right[j++];
        }
    }

}
