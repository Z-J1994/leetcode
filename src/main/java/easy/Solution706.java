package easy;

/**
 * @author zhangjun
 * @date 2021/3/14
 */
public class Solution706 {
    class MyHashMap {

        private class Node{
            private final int key;
            private int value;
            private Node next;
            private Node(int key,int value,Node next){
                this.key = key;
                this.next = next;
                this.value = value;
            }
        }

        private Node [] data;
        private int capacity = 16;
        private int size;
        private int threshold;
        private final double loadFactor = 0.75;
        /** Initialize your data structure here. */
        public MyHashMap() {
            data = new Node[capacity];
            size = 0;
            threshold = (int)(capacity * loadFactor);
        }

        public void put(int key,int value) {
            int index = getIndex(key);
            Node element = data[index];

            while(element != null){
                if(element.key == key){
                    element.value = value;
                    return;
                }
                element = element.next;
            }
            data[index] = new Node(key,value,data[index]);
            ++size;
            if(size > threshold){
                resize();
            }
        }

        public int get(int key){
            int index = getIndex(key);
            Node element = data[index];

            while(element != null){
                if(element.key == key){
                    return element.value;
                }
                element = element.next;
            }
            return -1;
        }

        public void remove(int key) {
            int index = getIndex(key);
            Node element = data[index];
            if(element == null){
                return;
            }
            if(element.key == key){
                data[index] = element.next;
                --size;
                return;
            }
            while(element.next != null){
                if(element.next.key == key){
                    element.next = element.next.next;
                    --size;
                    return;
                }
                element = element.next;
            }
        }

        private int getIndex(int key){
            return key &(capacity - 1);
        }

        private void resize(){

            int oldCapacity = capacity;
            capacity *= 2;
            threshold = (int)(capacity * loadFactor);
            Node [] newData = new Node[capacity];
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
                        newData[i] = loHead;
                    }
                    if(hiHead != null){
                        newData[i + oldCapacity] = hiHead;
                    }
                }
            }
            this.data = newData;
        }
    }

    public static void main(String[] args) {

    }
}
