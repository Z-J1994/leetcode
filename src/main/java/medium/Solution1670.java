package medium;

import utils.Invoker;

import java.util.Arrays;

public class Solution1670 {

    class FrontMiddleBackQueue {

        private final Node head;

        private Node middle;

        private Node tail;

        private int size;

        public FrontMiddleBackQueue() {
            head = new Node();
            head.value = -1;
            middle = head;
        }

        public void pushFront(int val) {
            Node n = insertAfter(head, val);
            if (size == 1) {
                middle = head.next;
            } else if ((size & 1) == 0) {
                middle = middle.previous;
            }
             if (tail == null) {
                tail = n;
            }
        }

        public void pushMiddle(int val) {
            Node n;
            if(size == 0){
                pushFront(val);
                return;
            }
            if ((size & 1) == 1) {
                n = insertAfter(middle.previous, val);
                middle = middle.previous;
            } else {
                n = insertAfter(middle, val);
                middle = middle.next;

            }
            if (tail == null) {
                tail = n;
            }
        }

        public void pushBack(int val) {
            if (tail == null) {
                pushFront(val);
                return;
            }
            tail = insertAfter(tail, val);
            if ((size & 1) == 1) {
                middle = middle.next;
            }
        }

        public int popFront() {
            if (size == 0) {
                return -1;
            }
            Node n = remove(head.next);
            if ((size & 1) == 1) {
                middle = middle.next;
            }
            if (size == 0) {
                tail = null;
            }
            return n.value;
        }

        public int popMiddle() {
            if (size == 0) {
                return -1;
            }
            Node n = remove(middle);
            if (size == 0) {
                middle = head;
                tail = null;
            } else if ((size & 1) == 0) {
                middle = middle.previous;
            } else {
                middle = middle.next;
            }
            return n.value;
        }

        public int popBack() {
            if (size == 0) {
                return -1;
            }
            Node n = remove(tail);
            tail = tail.previous;
            if (size == 0) {
                middle = head;
                tail = null;
            } else if ((size & 1) == 0) {
                middle = middle.previous;
            }
            return n.value;
        }


        private Node insertAfter(Node x, int val) {
            Node n = new Node();
            n.value = val;
            n.previous = x;
            n.next = x.next;
            x.next = n;
            if (n.next != null) {
                n.next.previous = n;
            }
            ++size;
            return n;
        }

        private Node remove(Node n) {
            if (n.next != null) {
                n.next.previous = n.previous;
            }
            n.previous.next = n.next;
            --size;
            return n;
        }

        private static class Node {
            private Node previous;
            private Node next;
            private int value;
        }
    }

    public static void main(String[] args) {
        Integer [] parameters;
        Integer [] result;
//        System.out.println(Arrays.toString(Invoker.invoke(FrontMiddleBackQueue.class,new Integer[]{null,1,2,3,4,null,null,null,null,null},new Integer[10],new String[]{"FrontMiddleBackQueue","pushFront","pushBack","pushMiddle","pushMiddle","popFront","popMiddle","popMiddle","popBack","popFront"})));
//        System.out.println(Arrays.toString(Invoker.invoke(FrontMiddleBackQueue.class, new Integer[]{null, 1, 2, 3, 4, null, null, null, null,}, new Integer[9], new String[]{"FrontMiddleBackQueue", "pushFront", "pushFront", "pushFront", "pushFront", "popBack", "popBack", "popBack", "popBack"})));
        parameters = new Integer[]{null,null,45652,null,529290,137216,541778,579220,null,null,null,null,84471,null,null,null,890665,null,null,null,432059,null,672417,null,null,978882,null,null,386335,986878,92639,null,null,null,391909,592975,992188,null,null,645886,null,null,null,null};
        result = new Integer[parameters.length];
        System.out.println(Arrays.toString(Invoker.invoke(FrontMiddleBackQueue.class,parameters ,result, new String[]{"FrontMiddleBackQueue","popMiddle","pushMiddle","popBack","pushMiddle","pushMiddle","pushMiddle","pushMiddle","popMiddle","popBack","popMiddle","popFront","pushMiddle","popFront","popMiddle","popMiddle","pushMiddle","popMiddle","popMiddle","popMiddle","pushMiddle","popMiddle","pushMiddle","popMiddle","popMiddle","pushMiddle","popMiddle","popMiddle","pushMiddle","pushMiddle","pushMiddle","popMiddle","popMiddle","popMiddle","pushMiddle","pushMiddle","pushMiddle","popFront","popMiddle","pushMiddle","popBack","popBack","popMiddle","popMiddle"})));
    }
}
