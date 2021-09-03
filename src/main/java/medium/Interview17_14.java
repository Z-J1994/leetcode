package medium;

/**
 * @author zhangjun
 * @version 2021/9/3
 */
public class Interview17_14 {
    public int[] smallestK(int[] arr, int k) {
        int [] result = new int[k];
        quickSelect(arr,0,arr.length - 1,k - 1);
        for(int i = 0;i < k;i++){
            result[i] = arr[i];
        }
        return result;
    }

    private void quickSelect(int [] data,int lo,int hi,int k){
        if(hi > lo){
            int t = mid(data,lo,hi);
            if(t < k){
                quickSelect(data,t + 1,hi,k);
            }else if(t > k){
                quickSelect(data,lo,t - 1,k);
            }
        }
    }
    //三分取中
    private int mid(int [] data,int lo,int hi){
        int mid = (lo + hi) >>> 1;
        int large = lo;
        if(data[large] < data[mid]){
            large = mid;
        }
        if(data[large] > data[hi]){
            int t = data[hi];
            data[hi] = data[large];
            data[large] = t;
        }
        if(data[lo] < data[mid]){
            int t = data[lo];
            data[lo] = data[mid];
            data[mid] = t;
        }
        return partition(data,lo,hi);
    }
    //快速排序子方法
    private int partition(int [] data,int lo,int hi){
        int v = data[lo];
        int i = lo;
        int j = hi + 1;
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
