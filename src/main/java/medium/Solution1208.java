package medium;

/**
 * @author zhangjun
 * @date 2021/2/5
 */
public class Solution1208 {
    public int equalSubstring(String s, String t, int maxCost) {
        int length = s.length();
        int maxLength = 0;
        char [] sa = s.toCharArray();
        char [] ta = t.toCharArray();
        int [] difference = new int[length];
        for(int i = 0,start = 0;i < length;i++){
            int d = Math.abs(sa[i] - ta[i]);
            difference[i] = d;
            maxCost -= d;
            if(maxCost >= 0){
                maxLength = Math.max(maxLength,i - start + 1);
            } else{
                maxCost += difference[start];
                start++;
            }
        }
        return maxLength;
    }

}
