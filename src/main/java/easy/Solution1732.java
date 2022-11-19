package easy;

public class Solution1732 {
    public int largestAltitude(int[] gain) {
        int max = 0;
        int s = 0;
        for(int i : gain){
            s += i;
            if(s > max){
                max = s;
            }
        }
        return max;
    }
}
