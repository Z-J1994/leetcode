package medium;

import list.ListNode;


public class Solution86 {

    public ListNode partition(ListNode head, int x) {
        if(head == null){
            return null;
        }
        ListNode newHead = new ListNode();
        ListNode tail = newHead;
        while(head != null && head.val < x){
            tail.next = head;
            head = head.next;

            tail = tail.next;
            tail.next = null;
        }

        if(head == null){
            return newHead.next;
        }

        ListNode t = head;

        while(t.next != null){
            if(t.next.val < x){
                tail.next = t.next;
                tail = tail.next;

                t.next = t.next.next;

                tail.next = null;
            }else{
                t = t.next;
            }
        }

        tail.next = head;

        return newHead.next;
    }

    public static void main(String[] args) {

    }

}
