package easy;

public class Solution453 {
    public int minMoves(int[] nums) {
        int min = 0x7fffffff;
        for (int i : nums){
            if(i < min){
                min = i;
            }
        }

        int result = 0;

        for(int i : nums){
            result += i - min;
        }

        return result;
    }
}
