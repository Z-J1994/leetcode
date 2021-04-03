package easy;

/**
 * @author zhangjun
 * @date 2021/2/20
 */
public class Solution697 {
    public int findShortestSubArray(int[] nums) {
        int max = nums[0];
        int min = nums[0];
        for(int i = 0,l = nums.length;i < l;i++){
            int t = nums[i];
            max = max > t ? max : t;
            min = min < t ? min : t;
        }

        int [][] map = new int[max - min + 1][3];
        for(int i = 0,l = nums.length;i < l;i++){
            if(map[nums[i] - min][0] == 0){
                map[nums[i] - min][1] = i;
            }
            map[nums[i] - min][0]++;
            map[nums[i] - min][2] = i;
        }

        int maxCount = map[0][0];
        int minLengthOfMaxElement = map[0][2] - map[0][1];
        for(int i = 1,l = max - min + 1;i < l;i++){
            int count = map[i][0];
            if(count < maxCount){
                continue;
            }

            int length = map[i][2] - map[i][1];
            if (count == maxCount && length  >= minLengthOfMaxElement) {
                continue;
            }
            maxCount = count;
            minLengthOfMaxElement = length;
        }


        return minLengthOfMaxElement + 1;
    }

    public static void main(String[] args) {
        Solution697 s = new Solution697();
        int [] nums = {1,2,2,3,1,4,2};
        int [] nums1 = {1, 2, 2, 3, 1};

        System.out.println(s.findShortestSubArray(nums));//6
        System.out.println(s.findShortestSubArray(nums1));//2
    }
}
