package medium;

import java.util.Objects;

public class Solution1754 {
    public String largestMerge(String word1, String word2) {
        char[] w1 = word1.toCharArray();
        char[] w2 = word2.toCharArray();
        char[] chars = new char[w1.length + w2.length];
        int i, j, k;
        for (i = 0, j = 0, k = 0; i < w1.length && j < w2.length; k++) {
            if (w1[i] < w2[j]) {
                chars[k] = w2[j++];
            } else if (w1[i] > w2[j]) {
                chars[k] = w1[i++];
            } else {
                int f = i + 1, g = j + 1;
                while (f < w1.length && g < w2.length && w1[f] == w2[g]) {
                    f++;
                    g++;
                }
                if(f == w1.length){
                    chars[k] = w2[j++];
                }else if(g == w2.length){
                    chars[k] = w1[i++];
                }else if(w1[f] < w2[g]){
                    chars[k] = w2[j++];
                }else{
                    chars[k] = w1[i++];
                }
            }
        }
        while(i < w1.length){
            chars[k++] = w1[i++];
        }
        while(j < w2.length){
            chars[k++] = w2[j++];
        }
        return new String(chars);
    }

}
