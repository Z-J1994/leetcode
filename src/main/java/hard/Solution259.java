package hard;

import java.util.PriorityQueue;

/**
 * description
 *
 * @author zhangjun
 * data 2021/08/27 13:43
 */
public class Solution259{
    class MedianFinder {

        // private Heap max;
        // private Heap min;

        // /** initialize your data structure here. */
        // public MedianFinder() {
        //      max = new Heap(true);
        //      min = new Heap(false);
        // }
        PriorityQueue<Integer> min;
        PriorityQueue<Integer> max;

        public MedianFinder() {
            max = new PriorityQueue<Integer>((a, b) -> (b - a));
            min = new PriorityQueue<Integer>((a, b) -> (a - b));
        }
        int count;
        public void addNum(int num) {
            if(count == 0){
                max.offer(num);
            }else if(num >= max.peek()){
                min.offer(num);
            }else{
                max.offer(num);
            }
            count++;
            if(min.size() > max.size()){
                max.offer(min.poll());
            }else if(max.size() - min.size() > 1){
                min.offer(max.poll());
            }
        }

        public double findMedian() {
            if((count & 0x1) == 0){
                return (max.peek() * 1.0 + min.peek()) / 2;
            }
            return max.peek();
        }

        private static class Heap{
            int [] heap;
            int size;
            int factory = -1;
            public Heap(boolean max){
                if(max){
                    factory = 1;
                }
                heap = new int[16];
            }

            private boolean compare(int a,int b){
                return (a - b) * factory > 0;
            }

            private void sink(int parent){
                int child = parent * 2 + 1;
                int parentValue = heap[parent];
                while(child < size){
                    if(child + 1 < size && compare(heap[child + 1],heap[child])){
                        child++;
                    }
                    if(compare(parentValue,heap[child])){
                        break;
                    }
                    heap[parent] = heap[child];
                    parent = child;
                    child = parent * 2 + 1;
                }
                heap[parent] = parentValue;
            }

            private void swim(int child){
                int childValue = heap[child];
                int parent = (child - 1) >>> 1;
                while(child > 0 && compare(childValue,heap[parent])){
                    heap[child] = heap[parent];
                    child = parent;
                    parent = (child - 1) >>> 1;
                }
                heap[child] = childValue;
            }

            public void offer(int element){
                if(size == heap.length){
                    grow(size << 1);
                }
                heap[size++] = element;
                swim(size - 1);
            }

            public int poll(){
                int result = heap[0];
                heap[0] = heap[--size];
                sink(0);
                return result;
            }

            public int peek(){
                return heap[0];
            }

            public void setTop(int element){
                heap[0] = element;
                sink(0);
            }

            public int size(){
                return size;
            }

            private void grow(int newCapacity){
                int [] newHeap = new int[newCapacity];
                for(int i = 0,l = heap.length;i < l;i++){
                    newHeap[i] = heap[i];
                }
                heap = newHeap;
            }
        }
    }

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */

}