package medium;

import utils.Parser;

public class Solution904 {
    public int totalFruit(int[] fruits) {
        int i = 0;
        int [] a = {fruits[i++],1};
        while(i < fruits.length && a[0] == fruits[i]){
            a[1]++;
            i++;
        }
        if(i == fruits.length){
            return fruits.length;
        }
        int [] b = {fruits[i++],1};
        int max = 0;
        for(int l = 0;i < fruits.length;i++){
            if(fruits[i] == a[0]){
                a[1]++;
            }else if(fruits[i] == b[0]){
                b[1]++;
            }else{
                max = Math.max(max,b[1] + a[1]);
                while(b[1] > 0 && a[1] > 0){
                    if(fruits[l++] == a[0]){
                        a[1]--;
                    }else{
                        b[1]--;
                    }
                }
                if(b[1] == 0){
                    b[0] = fruits[i];
                    b[1] = 1;
                }else{
                    a[0] = fruits[i];
                    a[1] = 1;
                }
            }
        }
        max = Math.max(max,b[1] + a[1]);
        return max;
    }

    public static void main(String[] args) {
        Solution904 s = new Solution904();
        System.out.println(s.totalFruit(Parser.StringToIntArray("[6,2,1,1,3,6,6]")));
    }
}
