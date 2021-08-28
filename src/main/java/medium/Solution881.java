package medium;

import java.util.Arrays;

/**
 * @author zhangjun
 * @version 2021/8/26
 */
public class Solution881 {
    public int numRescueBoats(int[] people, int limit) {
        int count = 0;
        int i = 0, j = people.length - 1;
        sort(people, 0, j);
//        Arrays.sort(people);
        while (i <= j) {
            if (people[i] + people[j] <= limit) {
                i++;
            }
            count++;
            j--;
        }
        return count;
    }

    private void sort(int[] data, int lo, int hi) {
        if (lo + 15 >= hi) {
            insertion(data, lo, hi);
            return;
        }
        int p = mid(data, lo, hi);
        sort(data, lo, p - 1);
        sort(data, p + 1, hi);

    }

    private void insertion(int [] data,int lo,int hi){
        for(int i = lo + 1,j;i <= hi;i++){
            int m = data[i];
            for(j = i - 1;j >= lo && data[j] > m;j--){
                data[j + 1] = data[j];
            }
            data[j + 1] = m;
        }
    }

    private int mid(int[] data, int lo, int hi) {
        int mid = (lo + hi) >>> 1;
        int large = lo;
        if (data[large] < data[mid]) {
            large = mid;
        }
        if (data[large] > data[hi]) {
            int t = data[hi];
            data[hi] = data[large];
            data[large] = t;
        }
        if (data[mid] > data[lo]) {
            int t = data[lo];
            data[lo] = data[mid];
            data[mid] = t;
        }
        return partition(data, lo, hi);
    }

    private int partition(int[] data, int lo, int hi) {
        int pivot = data[lo];
        int i = lo;
        int j = hi + 1;
        while (true) {
            while (data[++i] < pivot) ;
            while (data[--j] > pivot) ;
            if (i >= j) {
                break;
            }
            int t = data[i];
            data[i] = data[j];
            data[j] = t;
        }
        data[lo] = data[j];
        data[j] = pivot;
        return j;
    }
}
