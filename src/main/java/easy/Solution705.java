package easy;

/**
 * @author zhangjun
 * @date 2021/3/13
 */
public class Solution705 {
    class MyHashSet {

        private class Node{
            private final int key;
            private Node next;
            private Node(int key,Node next){
                this.key = key;
                this.next = next;
            }
        }

        private Node [] data;
        private int capacity = 16;
        private int size;
        private int threshold;
        private final double loadFactor = 0.75;
        /** Initialize your data structure here. */
        public MyHashSet() {
            data = new Node[capacity];
            size = 0;
            threshold = (int)(capacity * loadFactor);
        }

        public void add(int key) {
            if (contains(key)){
                return;
            }
            int index = getIndex(key);
            data[index]= new Node(key,data[index]);
            ++size;
            if(size > threshold){
                resize();
            }
        }

        public void remove(int key) {
            int index = getIndex(key);
            Node element = data[index];
            if(element == null){
                return;
            }
            if(element.key == key){
                data[index] = element.next;
                return;
            }
            while(element.next != null){
                if(element.next.key == key){
                    element.next = element.next.next;
                    break;
                }
                element = element.next;
            }
            --size;
        }

        /** Returns true if this set contains the specified element */
        public boolean contains(int key) {
            Node element = data[getIndex(key)];

            while(element != null){
                if(element.key == key){
                    return true;
                }
                element = element.next;
            }
            return false;
        }

        private int getIndex(int key){
            return key &(capacity - 1);
        }

        private void resize(){

            int oldCapacity = capacity;
            capacity *= 2;
            threshold = (int)(capacity * loadFactor);
            Node [] newDate = new Node[capacity];
            for(int i = 0;i < oldCapacity;++i){

                Node list = data[i];
                if(list != null){
                    Node loHead = null;
                    Node hiHead = null;
                    do{
                        Node element = list;
                        list = list.next;

                        if((element.key & oldCapacity) == 0){
                            element.next = loHead;
                            loHead = element;
                        }else{
                            element.next = hiHead;
                            hiHead = element;
                        }

                    }while(list != null);

                    if(loHead != null){
                        newDate[i] = loHead;
                    }
                    if(hiHead != null){
                        newDate[i + oldCapacity] = hiHead;
                    }
                }
            }

            this.data = newDate;
        }
    }
}
