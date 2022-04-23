package easy;

public class Solution1672 {
    public int maximumWealth(int[][] accounts) {
        int max = 0;
        for(int[] i : accounts){
            int t = 0;
            for(int j : i){
                t += j;
            }
            if(t > max){
                max = t;
            }
        }
        return max;
    }
}
