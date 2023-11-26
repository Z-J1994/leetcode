package easy;

import utils.Parser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhangjun
 * @since 2023/11/24 13:30
 */
public class Solution2824 {
    public int countPairs(List<Integer> nums, int target) {
        int[] data = new int[nums.size()];
        int k = 0;
        for (int i : nums) {
            data[k++] = i;
        }
        quickSort(data, 0, k - 1);
        int sum = 0;
        for (int i = 0; i < k; i++) {
            int t = target - data[i];
            if (t > data[i]) {
                sum += lowerBound(data, t) - i - 1;
            }
        }
        return sum;
    }

    private int lowerBound(int[] data, int key) {
        int lo = 0, hi = data.length;
        while (lo < hi) {
            int mid = (lo + hi) >>> 1;
            if (data[mid] < key) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }


    private void quickSort(int[] data, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        int p = getMidemu(data, lo, hi);
        quickSort(data, lo, p - 1);
        quickSort(data, p + 1, hi);
    }

    private int getMidemu(int[] data, int lo, int hi) {
        int mid = (lo + hi) >> 1;
        int min = data[lo], max = data[hi], midValue = data[mid];
        if (min > max) {
            int t = min;
            min = max;
            max = t;
        }
        if (min > midValue) {
            int t = min;
            min = midValue;
            midValue = t;
        }
        if (midValue > max) {
            int t = midValue;
            midValue = max;
            max = t;
        }
        data[lo] = midValue;
        data[mid] = min;
        data[hi] = max;
        return paitition(data, lo, hi);
    }

    private int paitition(int[] data, int lo, int hi) {
        int i = lo;
        int v = data[lo];
        while (lo < hi) {
            while (data[++lo] < v) ;
            while (data[--hi] > v) ;
            if (lo >= hi) {
                break;
            }
            int t = data[lo];
            data[lo] = data[hi];
            data[hi] = t;
        }
        data[i] = data[hi];
        data[hi] = v;
        return hi;
    }

    public static void main(String[] args) {
        Solution2824 s = new Solution2824();
        System.out.println(s.countPairs(Arrays.stream(Parser.StringToIntArray("[-1,1,2,3,1]")).collect(ArrayList::new, ArrayList::add, ArrayList::addAll), 2) == 3);
        System.out.println(s.countPairs(Arrays.stream(Parser.StringToIntArray("[-6,2,5,-2,-7,-1,3]")).collect(ArrayList::new, ArrayList::add, ArrayList::addAll), -2) == 10);

    }
}
