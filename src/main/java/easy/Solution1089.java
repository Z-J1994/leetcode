package easy;

/**
 * @author zhangjun
 * @since 2022/6/7 13:08
 */
public class Solution1089 {
    public void duplicateZeros(int[] arr) {
        int j = 0;
        //找到第一个0的位置
        while (j < arr.length && arr[j++] != 0) ;
        if (j == arr.length) {
            return;
        }
        int offset = j - 1;
        int i = j + 1;

        //找到最后一个有效数字
        while (i < arr.length) {
            if (arr[j++] == 0) {
                i += 2;
            } else {
                i++;
            }
        }
        if (i > arr.length) {
            //如果if成立说明最后一个有效数字是0,并且如果覆写这个零会超出数组的长度
            i = arr.length;
            arr[--i] = arr[--j];
        }

        while (i > offset) {
            if (arr[--j] == 0) {
                arr[--i] = 0;
            }
            arr[--i] = arr[j];
        }
    }

    public static void main(String[] args) {
        Solution1089 s = new Solution1089();
        s.duplicateZeros(new int[]{8, 4, 5, 0, 0, 0, 0, 7});
        s.duplicateZeros(new int[]{9, 9, 9, 4, 8, 0, 0, 3, 7, 2, 0, 0, 0, 0, 9, 1, 0, 0, 1, 1, 0, 5, 6, 3, 1, 6, 0, 0, 2, 3, 4, 7, 0, 3, 9, 3, 6, 5, 8, 9, 1, 1, 3, 2, 0, 0, 7, 3, 3, 0, 5, 7, 0, 8, 1, 9, 6, 3, 0, 8, 8, 8, 8, 0, 0, 5, 0, 0, 0, 3, 7, 7, 7, 7, 5, 1, 0, 0, 8, 0, 0});
    }
}
