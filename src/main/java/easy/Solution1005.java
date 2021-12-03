package easy;

public class Solution1005 {
    public int largestSumAfterKNegations(int[] nums, int k) {
        int length = nums.length - 1;
        quickSort(nums,0,length);
        int sum = 0;
        int i = 0;
        for(;i <= length && nums[i] < 0 && k > 0;i++,k--){
            sum -= nums[i];
        }
        if(i > length){
            if(k % 2 == 1){
                sum += nums[length] * 2;
            }
        }else if(k > 0){
            if(k % 2 == 1){
                if(i > 0 && -nums[i - 1] < nums[i]){
                    sum += nums[i - 1] * 2;
                }else{
                    sum -= nums[i++];
                }
            }
        }
        for(;i <= length;i++){
            sum += nums[i];
        }
        return sum;
    }

    private void quickSort(int [] data,int lo,int hi){
        if(lo >= hi){
            return;
        }
        int pivot = random(data,lo,hi);
        quickSort(data,lo,pivot - 1);
        quickSort(data,pivot + 1,hi);
    }

    private int random(int []data,int lo,int hi){
        int mid = (lo + hi) >>> 1;
        int maxValue = data[hi];
        int minValue = data[lo];
        int midValue = data[mid];

        if(maxValue < minValue){
            int t = maxValue;
            maxValue = minValue;
            minValue = t;
        }

        if(maxValue < midValue){
            int t = maxValue;
            maxValue = midValue;
            midValue = t;
        }

        if(minValue > midValue){
            int t = minValue;
            minValue = midValue;
            midValue = t;
        }

        data[lo] = midValue;
        data[mid] = minValue;
        data[hi] = maxValue;
        return partition(data,lo,hi);
    }

    private int partition(int []data,int lo,int hi){
        int v = data[lo];
        int i = lo;
        int j = hi;
        while(true){
            while(data[++i] < v);
            while(data[--j] > v);
            if(i >= j){
                break;
            }
            int t = data[i];
            data[i] = data[j];
            data[j] = t;
        }
        data[lo] = data[j];
        data[j] = v;
        return j;
    }
}
