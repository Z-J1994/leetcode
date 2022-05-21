package easy;

/**
 * @author zhangjun
 * @since 2022/5/17 12:26
 */
public class Solution1013 {
    public boolean canThreePartsEqualSum(int[] arr) {
        int sum = 0;
        for (int i : arr) {
            sum += i;
        }
        if (sum % 3 != 0) {
            return false;
        }
        sum /= 3;
        int i = 0;
        for (int j = 0, t; j < 2; j++) {
            if (i >= arr.length) {
                return false;
            }
            t = sum;
            while (i < arr.length && (t -= arr[i++]) != 0) ;
            if (t != 0) {
                return false;
            }
        }
        return i < arr.length;
    }

    public static void main(String[] args) {
        Solution1013 s = new Solution1013();
        System.out.println(s.canThreePartsEqualSum(new int[]{3, 3, 6, 5, -2, 2, 5, 1, -9, 4}));
        System.out.println(s.canThreePartsEqualSum(new int[]{12, -4, 16, -5, 9, -3, 3, 8, 0}));
        System.out.println(s.canThreePartsEqualSum(new int[]{1, -1, 1, -1}));
    }
}
