package easy;

/**
 * @author zhangjun
 * @version 2023/3/9
 */
public class Solution2379 {
    public int minimumRecolors(String blocks, int k) {
        int wc = 0;
        for(int i = 0;i < k;i++){
            if(blocks.charAt(i) == 'W'){
                wc++;
            }
        }
        int min = Math.min(wc,blocks.length());
        for(int i = 0,j = k,l = blocks.length();j < l;j++,i++){
            if(blocks.charAt(i) == 'W'){
                wc--;
            }
            if(blocks.charAt(j) == 'W'){
                wc++;
            }
            min = Math.min(wc,min);
        }
        return min;
    }
}
