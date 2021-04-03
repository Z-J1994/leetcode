package easy;

/**
 * @author zhangjun
 * @version 2020/09/22  20:30
 */

//arr = [3,0,1,1,9,7], a = 7, b = 2, c = 3
public class Solution1534 {
    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        int count = 0;
        for(int i = 0;i < arr.length;i++){
            int ai = arr[i];
            for(int j = i + 1;j < arr.length;j++){
                int aj = arr[j];
                if(ai - aj > a || aj - ai >a){
                    continue;
                }
                for(int k = j + 1;k < arr.length;k++){
                    int ak = arr[k];
                    if(aj - ak > b || ak - aj > b){
                        continue;
                    }
                    else if(ai - ak > c || ak - ai > c){
                        continue;
                    }
                    count++;
                }
            }
        }
        return count;
    }
}
