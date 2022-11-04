package easy;

/**
 * @author zhangjun
 * @version 2022/11/3
 */
public class Solution1668 {
    public int maxRepeating(String sequence, String word) {
        char [] wc = word.toCharArray();
        int maxK = 0;
        for(int i = 0,k,l = sequence.length();i < l;i++){
            k = 0;
            for(int g = i,j = 0;g < l && wc[j] == sequence.charAt(g);g++,j %= wc.length){
                k  += ++j / wc.length;
            }
            maxK = Math.max(maxK,k);
        }
        return  maxK;
    }

    public static void main(String[] args) {
        Solution1668 s = new Solution1668();
        System.out.println(s.maxRepeating("ababc", "ab"));
    }
}
