package easy;

/**
 * @author zhangjun
 * @version 2020/10/10  20:16
 */
public class Solution1122 {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        short [] bucket = new short[1001];
        for(int i = 0;i < arr1.length;i++){
            bucket[arr1[i]]++;
        }
        int index = 0;
        for(int i = 0;i < arr2.length;i++){
            int t = arr2[i];
            while(bucket[t] > 0){
                arr1[index++] = t;
                --bucket[t];
            }
        }
        for(int i = 0;i < 1001;i++){
            while(bucket[i] > 0){
                arr1[index++] = i;
                --bucket[i];
            }
        }
        return arr1;
    }
}
