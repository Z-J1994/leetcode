package medium;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author zhangjun
 * @date 2021/2/21
 */
public class Solution1438 {
    public int longestSubarray(int[] nums, int limit) {
        Deque<Integer> maxQueue = new ArrayDeque<>();
        Deque<Integer> minQueue = new ArrayDeque<>();

        int left = 0;
        int right = 0;
        int maxLength = 0;
        int length = nums.length;
        maxQueue.offer(0);
        minQueue.offer(0);
        while(right < length){
            int maxIndex = maxQueue.peekFirst();
            int minIndex = minQueue.peekFirst();
            if(Math.abs(nums[maxIndex] - nums[minIndex]) > limit){
                left = (maxIndex > minIndex) ? minIndex + 1: maxIndex + 1;
                while(!maxQueue.isEmpty() && maxQueue.peekFirst() < left){
                    maxQueue.pollFirst();
                }
                while(!minQueue.isEmpty() && minQueue.peekFirst() < left){
                    minQueue.pollFirst();
                }
            }else{
                int step = right - left + 1;
                maxLength = maxLength > step ? maxLength : step;
                right++;
                if(right == length){
                    return maxLength;
                }
                int e = nums[right];
                while(!maxQueue.isEmpty() && nums[maxQueue.peekLast()] <= e){
                    maxQueue.pollLast();
                }
                maxQueue.offer(right);

                while(!minQueue.isEmpty() && nums[minQueue.peekLast()] >= e){
                    minQueue.pollLast();
                }
                minQueue.offer(right);
            }
        }

        return maxLength;
    }
}
