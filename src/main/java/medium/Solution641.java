package medium;

/**
 * @author zhangjun
 * @since 2022/8/15 13:10
 */
public class Solution641 {

    private static class MyCircularDeque {

        private final int [] element;
        private int head;
        private int tail;


        public MyCircularDeque(int k) {
            element = new int[k + 1];
            head = 0;
            tail = 0;
        }

        public boolean insertFront(int value) {
            if(isFull()){
                return false;
            }
            head = getMinusIndex(head - 1);
            element[head] = value;
            return true;
        }

        public boolean insertLast(int value) {
            int h = getMinusIndex(tail + 1);
            if(h == head){
                return false;
            }
            element[tail] = value;
            tail = h;
            return true;
        }

        public boolean deleteFront() {
            if(isEmpty()){
                return false;
            }
            head = getMinusIndex(head + 1);
            return true;
        }

        public boolean deleteLast() {
            if(isEmpty()){
                return false;
            }
            tail = getMinusIndex(tail - 1);
            return true;
        }

        public int getFront() {
            if(isEmpty()){
                return -1;
            }
            return element[head];
        }

        public int getRear() {
            if(isEmpty()){
                return -1;
            }
            return element[getMinusIndex(tail - 1)];
        }

        public boolean isEmpty() {
            return head == tail;
        }

        public boolean isFull() {
            return getMinusIndex(tail + 1) == head;
        }

        private int getMinusIndex(int i){
            return (i + element.length) % element.length;
        }

        private int getPlusIndex(int i){
            return i % element.length;
        }
    }
}
