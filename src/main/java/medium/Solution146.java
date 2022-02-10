package medium;

/**
 * @author zhangjun
 * @version 2022/2/10
 */
public class Solution146 {
    class LRUCache {

        private final Node [] nodes = new Node[10001];
        private int size = 0;
        private final int maxSize;

        public LRUCache(int capacity) {
            maxSize = capacity;
        }

        public int get(int key) {
            if(nodes[key] == null){
                return -1;
            }
            update(nodes[key]);
            return first.value;
        }

        public void put(int key, int value) {
            if(nodes[key] != null){
                nodes[key].value = value;
                update(nodes[key]);
            }else {
                if(size++ >= maxSize){
                    nodes[last.key] = null;
                    removeLast();
                    --size;
                }
                addFirst(key,value);
                nodes[key] = first;
            }
        }

        private class Node{
            private int key;
            private int value;
            private Node previous;
            private Node next;
            public Node(Node previous,int key,int value,Node next){
                this.previous = previous;
                this.key = key;
                this.value = value;
                this.next = next;
            }
        }

        private Node first;
        private Node last;

        private void addFirst(int key,int value){
            Node t = new Node(null,key,value,null);
            addFirst(t);
        }

        private void addFirst(Node x){
            x.next = first;
            if(first != null){
                first.previous = x;
            }
            first = x;
            if(last == null){
                last = x;
            }
        }

        private void removeLast(){
            //假设last不为null
            if(last.previous != null){
                last.previous.next = null;
            }
            if(last == first){
                last = null;
                first = null;
            }else{
                last = last.previous;
            }
        }

        private void update(Node x){
            if(x == first){
                return;
            }
            if(x.next == null){
                removeLast();
            }else{
                x.next.previous = x.previous;
            }
            if(x.previous == null){
                first = x.next;
            }else{
                x.previous.next = x.next;
            }
            x.next = null;
            x.previous = null;
            addFirst(x);
        }
    }
}
