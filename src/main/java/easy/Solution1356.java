package easy;

/**
 * @author zhangjun
 * @version 2020/10/07  17:12
 */
public class Solution1356 {
    public int[] sortByBits(int[] arr) {
        int length = arr.length;
        int [] result = new int[length];
        for(int i = 0;i < length;i++){
            result[i] = bitCount(arr[i]);
        }
        quickSort(arr,result,0,length - 1);

        int s = 0;
        int i;
        for(i = 1;i < length;i++){
            if(result[i] != result[i - 1]){
                if(s < i - 1){
                    insertSort(result,arr,s,i - 1);
                }
                s = i;
            }
        }
        if(s < i - 1){
            insertSort(result,arr,s,i - 1);
        }
        return arr;
    }

    private final static int M = 15;

    private void quickSort(int [] arr,int [] result,int lo,int hi){
        if(lo < hi - M){
            int lessThan = lo;
            int greaterThan = hi;
            for(int i = lo + 1,v = result[lo];i <= greaterThan;){
                if(result[i] < v){
                    exchange(result,lessThan,i);
                    exchange(arr,lessThan++,i++);
                }else if(result[i] > v){
                    exchange(result,i,greaterThan);
                    exchange(arr,i,greaterThan--);
                }else{
                    i++;
                }
            }
            quickSort(arr,result,lo,lessThan - 1);
            quickSort(arr,result,greaterThan + 1,hi);
        }else{
            insertSort(arr, result, lo, hi);
        }
    }

    private void insertSort(int [] arr,int [] result,int lo,int hi){
        for(int i = lo + 1,j;i <= hi;i++){
            int t = result[i];
            int h = arr[i];
            for(j = i - 1;j >= lo && result[j] > t;j--){
                result[j + 1] = result[j];
                arr[j + 1] = arr[j];
            }
            result[j + 1] = t;
            arr[j + 1] = h;
        }
    }

    private int bitCount(int n){
        n -= (n >>> 1) & 0x55555555;
        n = (n & 0x33333333) + ((n >>> 2) & 0x33333333);
        n = (n + (n >>> 4)) & 0x0F0F0F0F;
        n += (n >>> 8);
        n += (n >>> 16);
        return n & 0x3F;
    }

    private void exchange(int [] result,int i,int j){
        int t = result[i];
        result[i] = result[j];
        result[j] = t;
    }
}
