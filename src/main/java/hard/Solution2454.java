package hard;

import utils.Parser;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.ListIterator;

/**
 * @author zhangjun
 * @since 2023/12/12 13:10
 */
public class Solution2454 {
    public int[] secondGreaterElement(int[] nums) {
        int[] answer = new int[nums.length];
        LinkedList<int[]> list = new LinkedList<>();
        list.add(new int[]{-1 >>> 1, -1, -1});
        for (int i = 0, n; i < nums.length; i++) {
            int[] q = new int[]{(n = nums[i]), 2, i};
            int[] temp;
            ListIterator<int[]> listIterator = list.listIterator();
            while ((temp = listIterator.next())[0] < n) {
                if (--temp[1] <= 0) {
                    listIterator.remove();
                    answer[temp[2]] = n;
                }
            }
            listIterator.previous();
            listIterator.add(q);
        }
        for (int i = 0; i < answer.length; i++) {
            if (answer[i] == 0) {
                answer[i] = -1;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution2454 s = new Solution2454();
        System.out.println(Arrays.toString(s.secondGreaterElement(Parser.StringToIntArray("[2,4,0,9,6]"))));
    }
}
