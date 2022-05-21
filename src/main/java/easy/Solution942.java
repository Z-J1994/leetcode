package easy;

import java.util.Arrays;

public class Solution942 {
    public int[] diStringMatch(String s) {
        int length = s.length();
        int [] result = new int [length + 1];
        int max = length;
        int min =  0;
        for(int i = 0;i < length;i++){
            if(s.charAt(i) == 'I'){
                result[i] = min++;
            }else{
                result[i] = max--;
            }
        }
        result[length] = min;
        return result;
    }

    public static void main(String[] args) {
        Solution942 s = new Solution942();
        System.out.println(Arrays.toString(s.diStringMatch("IDID")));
    }
}
