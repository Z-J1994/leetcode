package easy;

/**
 * @author zhangjun
 * @version 2022/3/24
 */
public class Solution744 {
    public char nextGreatestLetter(char[] letters, char target) {
        int lo = 0,hi = letters.length;
        int mid;
        while(lo < hi){
            mid = (lo + hi) >>> 1;
            if(letters[mid] > target){
                hi = mid;
            }else{
                lo = mid + 1;
            }
        }
        if(hi == letters.length){
            return letters[0];
        }
        return letters[hi];
    }
}
