package medium;

import java.util.Arrays;

/**
 * @author zhangjun
 * @version 2022/2/10
 */
public class Solution901 {
    private static class StockSpanner {
        private int[][] element;
        private int index;

        public StockSpanner() {
            element = new int[16][2];
            index = 0;
        }

        public int next(int price) {
            int count = 1;
            while (index >= 0 && element[index][0] <= price) {
                count += element[index][1];
                index--;
            }
            if(index == element.length - 1){
                element = Arrays.copyOf(element,element.length << 1);
            }
            element[++index] = new int[]{price,count};
            return count;
        }
    }

    public static void main(String[] args) {
        StockSpanner stockSpanner = new StockSpanner();
//        int [] e = {100,80,60,70,60,75,85};
        int[] e = {9, 10, 11, 12, 28, 40, 65, 86, 88, 89};
        for (int i : e) {
            System.out.println(stockSpanner.next(i));
        }
    }
}
