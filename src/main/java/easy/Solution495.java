package easy;

public class Solution495 {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int sum = 0;
        for(int i = 1;i < timeSeries.length;i++){
            int t = timeSeries[i] - timeSeries[i - 1];
            if(t < duration){
                sum += duration - t;
            }
        }
        return timeSeries.length * duration - sum;
    }
}
