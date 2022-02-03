package medium;

/**
 * @author zhangjun
 * @version 2022/2/3
 */
public class Solution1414 {
    public int findMinFibonacciNumbers(int k) {
        int[] array = new int[46];
        array[0] = 1;
        array[1] = 1;
        int i = 2;
        while (i < 46) {
            array[i] = array[i - 1] + array[i - 2];
            i++;
        }
        int count = 1;
        int index = binarySearch(array, k);
        k -= array[index--];
        while (k > 0) {
            if (array[index] <= k) {
                k -= array[index];
                count++;
            } else {
                index--;
            }
        }
        return count;
    }

    private int binarySearch(int[] data, int key) {
        int lo = 0;
        int hi = 45;
        while (lo <= hi) {
            int mid = (lo + hi) >>> 1;
            if (data[mid] == key) {
                return mid;
            } else if (data[mid] > key) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return hi;
    }

    public static void main(String[] args) {
        Solution1414 s = new Solution1414();
        System.out.println(s.findMinFibonacciNumbers(1) == 1);
        System.out.println(s.findMinFibonacciNumbers(2) == 1);
        System.out.println(s.findMinFibonacciNumbers(3) == 1);
        System.out.println(s.findMinFibonacciNumbers(4) == 2);
        System.out.println(s.findMinFibonacciNumbers(5) == 1);
        System.out.println(s.findMinFibonacciNumbers(6) == 2);
        System.out.println(s.findMinFibonacciNumbers(7) == 2);
        System.out.println(s.findMinFibonacciNumbers(8) == 1);
        System.out.println(s.findMinFibonacciNumbers(9) == 2);
        System.out.println(s.findMinFibonacciNumbers(10) == 2);
        System.out.println(s.findMinFibonacciNumbers(19) == 3);
    }
}
