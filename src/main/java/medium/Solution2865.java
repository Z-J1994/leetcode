package medium;

import java.util.List;

public class Solution2865 {
    public long maximumSumOfHeights(List<Integer> maxHeights) {
        int [] array = new int[maxHeights.size()];
        int index = 0;
        for(Integer i : maxHeights){
            array[index++] = i;
        }
        long max = 0;
        for(int i = 0;i < array.length;i++){
            long m = array[i];
            for(int j = i - 1,p = array[i];j >= 0;j--){
                m += Math.min(array[j],p);
                if(array[j] < p){
                    p = array[j];
                }
            }
            for(int j = i + 1,p = array[i];j < array.length;j++){
                m += Math.min(array[j],p);
                if(array[j] < p){
                    p = array[j];
                }
            }
            if(m > max){
                max = m;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Solution2865 s = new Solution2865();
        System.out.println(s.maximumSumOfHeights(List.of(6, 5, 3, 9, 2, 7)) == 22);
    }
}
