package medium;

import list.ListNode;

/**
 * @author zhangjun
 * @version 2022/10/12
 */
public class Solution817 {
    public int numComponents(ListNode head, int[] nums) {
        int [] map = new int[10000];
        for(int i : nums){
            map[i]++;
        }
        int result = 0;
        int c = 0;
        while(head != null){
            if(map[head.val] != 0){
                if(c++ == 0){
                    result++;
                }
            }else{
                c = 0;
            }
            head = head.next;
        }
        return result;
    }
}
