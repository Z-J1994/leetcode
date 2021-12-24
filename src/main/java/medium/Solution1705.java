package medium;

/**
 * @author zhangjun
 * @version 2021/12/24
 */
public class Solution1705 {
    public int eatenApples(int[] apples, int[] days) {
        int count = 0;
        int n = apples.length;
        heap = new int[n][2];
        for(int i = 0;i < n;i++){
            if(days[i] != 0){
                add(apples[i],i + days[i]);
            }
            while(size > 0 && (peek()[1] <= i || peek()[0] <= 0)){
                pop();
            }
            if(size > 0){
                peek()[0]--;
                count++;
            }
        }
        while(size > 0){
            while(size > 0 && (peek()[1] <= n || peek()[0] <= 0)) {
                pop();
            }
            if(size > 0){
                peek()[0]--;
                count++;
            }
            ++n;
        }
        return count;
    }

    private int [][] heap;
    int size = 0;

    private void add(int apples,int days){
        heap[size][0] = apples;
        heap[size][1] = days;
        swim(size++);
    }

    private int[] peek(){
        return heap[0];
    }

    private void pop(){
        int [] t = peek();
        heap[0] = heap[--size];
        heap[size] = t;
        sink(0);
    }

    private void swim(int child){
        int [] childValue = heap[child];
        int parent;
        while(child != 0 && childValue[1] < heap[(parent = ((child - 1) >>> 1))][1]){
            heap[child] = heap[parent];
            child = parent;
        }
        heap[child] = childValue;
    }

    private void sink(int parent){
        int [] parentValue = heap[parent];
        int child;
        while((child = ((parent << 1) + 1)) < size){
            if((child + 1 < size) && (heap[child + 1][1] < heap[child][1])){
                child = child + 1;
            }
            if(heap[child][1] >= parentValue[1]){
                break;
            }
            heap[parent] = heap[child];
            parent = child;
        }
        heap[parent] = parentValue;
    }

    public static void main(String[] args) {
        Solution1705 s = new Solution1705();
//        System.out.println(s.eatenApples(new int[]{3, 0, 0, 0, 0, 2}, new int[]{3, 0, 0, 0, 0, 2}) == 5);
//        System.out.println(s.eatenApples(new int[]{3,1,1,0,0,2}, new int[]{3,1,1,0,0,2}) == 5);
//        System.out.println(s.eatenApples(new int[]{1,2,3,5,2}, new int[]{3,2,1,4,2}) == 7);
//        System.out.println(s.eatenApples(new int[]{2,1,1,4,5}, new int[]{10,10,6,4,2}) == 8);
        int [] a = new int[50];
        int [] b = new int[50];
        for(int i = 0;i < 50;i++){
            a[i] = 2;
            b[i] = 100 - (i << 1);
        }
        System.out.println(s.eatenApples(a, b));
    }
}
