package medium;

import list.ListNode;
import tree.TreeNode;

/**
 * @author zhangjun
 * @version 2020/10/19  20:25
 */
public class Solution109 {
    private ListNode globalHead;
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null){
            return null;
        }
        globalHead = head;
        int length = getLength(head);
        return buildTree(0,length);
    }

    private int getLength(ListNode head){
        int length = -1;
        while(head != null){
            head = head.next;
            ++length;
        }
        return length;
    }

    private TreeNode buildTree(int lo,int hi){
        if(lo > hi){
            return null;
        }
        int mid = (lo + hi) / 2;
        TreeNode t = new TreeNode();

        t.left = buildTree(lo,mid - 1);

        t.val = globalHead.val;
        globalHead = globalHead.next;

        t.right = buildTree(mid + 1,hi);
        return t;
    }

}
