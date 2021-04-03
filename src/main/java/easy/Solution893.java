package easy;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @author zhangjun
 * @version 2020/09/28  14:07
 */

public class Solution893 {
    public int numSpecialEquivGroups(String[] A) {
        int count = A.length;
        for(int i = 0;i < A.length;i++){
            int length = A[i].length();
            if(length == 0){
                continue;
            }
            int [] odd = new int[52];
            int [] even = new int[52];

            for(int j = 1;j < length;j+=2){
                char c = A[i].charAt(j);
                mapping(odd,c);
            }
            for(int j = 0;j < length;j+=2){
                char c = A[i].charAt(j);
                mapping(even,c);
            }

            boolean marked;
            for(int k = i + 1;k < A.length;k++){
                int lengthK = A[k].length();
                if(lengthK == 0){
                    continue;
                }
                int [] oddK = new int[52];
                int [] evenK = new int[52];
                if(A[k].length() != length){
                    continue;
                }
                for(int j = 1;j < lengthK;j+=2){
                    char c = A[k].charAt(j);
                    mapping(oddK,c);
                }
                for(int j = 0;j < lengthK;j+=2){
                    char c = A[k].charAt(j);
                    mapping(evenK,c);
                }
                marked = match(odd,oddK,even,evenK);

                if(marked){
                    count--;
                    A[k] = "";
                }
            }
        }
        return count;
    }

    private void mapping(int [] arr,char c){
        if(c >= 'a'){
            arr[c - 97]++;
        }else{
            arr[c - 65]++;
        }
    }

    private boolean match(int [] odd,int [] oddK,int [] even,int [] evenK){
        for(int i = 0;i < odd.length;i++){
            if(odd[i] != oddK[i]){
                return false;
            }
        }
        for(int i = 0;i < even.length;i++){
            if(even[i] != evenK[i]){
                return false;
            }
        }
        return true;
    }

}
