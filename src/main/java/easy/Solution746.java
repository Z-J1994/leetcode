package easy;

public class Solution746 {
    public int minCostClimbingStairs(int[] cost) {
        int length = cost.length - 1;
        for(int i = 2;i <= length;i++){
            cost[i] += Math.min(cost[i - 1],cost[i - 2]);
        }
        return Math.min(cost[length - 1],cost[length]);
    }

    public static void main(String[] args) {
        Solution746 s = new Solution746();
        int [] cost = {10, 15, 20};
        int [] cost1 = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};

        System.out.println(s.minCostClimbingStairs(cost));
        System.out.println(s.minCostClimbingStairs(cost1));
    }
}
