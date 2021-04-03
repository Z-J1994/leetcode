package easy;

/**
 * @author zhangjun
 * @version 2020/09/26  15:27
 */
public class Offer09 {
    int [] queue;
    int head;
    int tail;
    int size;
    public void CQueue() {
        queue = new int[10];
    }

    public void appendTail(int value) {
        if(tail == queue.length){
            resize();
        }
        queue[tail++] = value;
        size++;
    }

    public int deleteHead() {
        if(size == 0){
            return -1;
        }
        size--;
        return queue[head++];
    }

    private void resize(){
        if(size < queue.length / 2){
            System.arraycopy(queue,head,queue,0,size);
            head = 0;
            tail = size;
        }else{
            resize(queue.length + (queue.length >> 2));
        }
    }

    private void resize(int newSize){
        int [] newArr = new int[newSize];
        System.arraycopy(queue,head,newArr,0,size);
        queue = newArr;
        head = 0;
        tail = size;
    }
}
