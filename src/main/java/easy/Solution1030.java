package easy;

import java.util.Arrays;

/**
 * @author zhangjun
 * @version 2020/10/10  20:45
 */
public class Solution1030 {
    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        int size = R * C;
        int [][] result = new int[size][2];

        int index = 0;
        for(int i = 0;i < R;i++){
            for (int j = 0;j < C;j++){
                result[index][0] = i;
                result[index][1] = j;
                ++index;
            }
        }
        Arrays.sort(result, (arr1, arr2) -> {
            int d1 = Math.abs(arr1[0] - r0) + Math.abs(arr1[1] - c0);
            int d2 = Math.abs(arr2[0] - r0) + Math.abs(arr2[1] - c0);
            return Integer.compare(d1, d2);
        });

        return result;
    }
//    quickSort(result,temp,0,size - 1);
    private static final int M = 15;
    private void quickSort(int[][] result,int [] shadow,int lo,int hi){
        if(lo < hi - 15){
            int lessThan = lo;
            int greaterThan = hi;
            int i = lo;
            int v = shadow[lo];
            while(i <= greaterThan){
                int t = shadow[i];
                if(t < v){
                    exchange(result,shadow,lessThan++,i++);
                }else if(t > v){
                    exchange(result,shadow,i,greaterThan--);
                }else{
                    ++i;
                }
            }

            quickSort(result,shadow,lo,lessThan - 1);
            quickSort(result,shadow,greaterThan + 1,hi);
        }else{
            insetSort(result,shadow,lo,hi);
        }
    }

    private void insetSort(int[][] result,int [] shadow,int lo,int hi){
        for(int i = lo + 1,j;i <= hi;i++){
            int t = shadow[i];
            int [] r = result[i];
            for(j = i - 1;j >= lo && shadow[j] > t;j--){
                shadow[j + 1] = shadow[j];
                result[j + 1] = result[j];
            }
            shadow[j + 1] = t;
            result[j + 1] = r;
        }
    }

    private void exchange(int[][] result,int [] shadow,int i,int j){
        int [] t = result[i];
        result[i] = result[j];
        result[j] = t;

        int h = shadow[i];
        shadow[i] = shadow[j];
        shadow[j] = h;
    }

}
