package easy;

import java.util.Arrays;

public class Solution1652 {
    public int[] decrypt(int[] code, int k) {
        if(k == 0){
            Arrays.fill(code,0);
            return code;
        }
        int left;
        int right;
        int s = 0;
        if(k > 0){
            left = 1;
            right = k % code.length;
        }else{
            left = code.length + k;
            right = code.length - 1;
        }
        for(int i = left;i < right;i = (i + 1) % code.length){
            s += code[i];
        }
        int [] result = new int[code.length];
        for(int i = 0;i < code.length;i++,left = (left + 1) % code.length,right = (right + 1) % code.length){
            s += code[right];
            result[i] = s;
            s -= code[left];
        }
        return result;
    }
}
