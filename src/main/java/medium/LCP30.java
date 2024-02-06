package medium;

import utils.Parser;

public class LCP30 {

    private int[] heap;
    private int size;

    public int magicTower(int[] nums) {
        heap = new int[16];
        size = -1;

        long negativeSum = 0;
        long sum = 0;
        int operations = 0;
        for (int n : nums) {
            sum += n;
            if (n < 0) {
                add(n);
            }
            if (sum < 0) {
                int t = pop();
                sum -= t;
                negativeSum += t;
                ++operations;
            }
        }
        return sum + negativeSum < 0 ? -1 : operations;
    }

    private void swim(int x) {
        int xValue = heap[x];
        int parent;
        while ((parent = (x - 1) >> 1) >= 0 && heap[parent] > xValue) {
            heap[x] = heap[parent];
            x = parent;
        }
        heap[x] = xValue;
    }

    private void sink() {
        int x = 0, xValue = heap[x], child;
        while ((child = (x << 1) + 1) <= size) {
            if (child + 1 <= size && heap[child + 1] < heap[child]) {
                ++child;
            }
            if (heap[child] >= xValue) {
                break;
            }
            heap[x] = heap[child];
            x = child;
        }
        heap[x] = xValue;
    }

    private void add(int value){
        if(++size == heap.length){
            int[] ints = new int[size << 1];
            System.arraycopy(heap,0,ints,0,size);
            heap = ints;
        }
        heap[size] = value;
        swim(size);
    }

    private int pop(){
        int t = heap[0];
        heap[0] = heap[size--];
        sink();
        return t;
    }

    public static void main(String[] args) {
        LCP30 l = new LCP30();
        System.out.println(l.magicTower(Parser.StringToIntArray("[-1,-1,10]")) == 2);
        System.out.println(l.magicTower(Parser.StringToIntArray("[-200,-300,400,0]")) == -1);
        System.out.println(l.magicTower(Parser.StringToIntArray("[100,100,100,-250,-60,-140,-50,-50,100,150]")) == 1);
    }
}
