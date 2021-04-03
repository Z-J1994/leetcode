package easy;

import list.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author zhangjun
 * @version 2020/09/28  20:48
 */
public class Interview02_01 {

    public ListNode removeDuplicateNodes(ListNode head) {
        if(head == null){
            return null;
        }
        boolean [] map = new boolean[20001];
        ListNode temp = head;
        map[temp.val] = true;
        while(temp.next != null){
            if(map[temp.next.val]){
                temp.next = temp.next.next;
            }else{
                map[temp.next.val] = true;
                temp = temp.next;
            }
        }
        return head;
    }
}
