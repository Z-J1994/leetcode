package medium;

/**
 * @author zhangjun
 * @version 2021/12/27
 */
public class Solution825 {

    public int numFriendRequests(int[] ages) {
        quickSort(ages, 0, ages.length - 1);
        int count = 0;
        int left = 0;
        int right = 0;
        for (int i = 0; i < ages.length; i++) {
            int toAge = ages[i];
            int fromAge = (toAge >>> 1) + 8;
            if (fromAge > toAge) {
                continue;
            }
            while (ages[left] < fromAge) {
                ++left;
            }
            while (right < ages.length && ages[right] <= toAge) {
                ++right;
            }
            int t = right - left - 1;
            if(t > 0){
                count += t;
            }
        }
        return count;
    }


    private void quickSort(int[] ages, int lo, int hi) {
        if (lo < hi) {
            int p = random(ages, lo, hi);
            quickSort(ages, lo, p - 1);
            quickSort(ages, p + 1, hi);
        }
    }

    private int random(int[] data, int lo, int hi) {
        int mid = (lo + hi) >>> 1;
        int minValue = data[lo];
        int midValue = data[mid];
        int maxValue = data[hi];
        if (minValue > maxValue) {
            int t = minValue;
            minValue = maxValue;
            maxValue = t;
        }
        if (midValue > maxValue) {
            int t = midValue;
            midValue = maxValue;
            maxValue = t;
        }
        if (minValue > midValue) {
            int t = midValue;
            midValue = minValue;
            minValue = t;
        }
        data[lo] = midValue;
        data[mid] = minValue;
        data[hi] = maxValue;
        return partition(data, lo, hi);
    }

    private int partition(int[] data, int lo, int hi) {
        int pivot = data[lo];
        int i = lo;
        int j = hi;
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

    public static void main(String[] args) {
        Solution825 s = new Solution825();
        System.out.println(s.numFriendRequests(new int[]{16, 16}) == 2);
        System.out.println(s.numFriendRequests(new int[]{16, 17, 18}) == 2);
        System.out.println(s.numFriendRequests(new int[]{20, 30, 100, 110, 120}) == 3);
        System.out.println(s.numFriendRequests(new int[]{73, 106, 39, 6, 26, 15, 30, 100, 71, 35, 46, 112, 6, 60, 110}) == 29);
    }
}
