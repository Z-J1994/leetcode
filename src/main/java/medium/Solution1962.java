package medium;

/**
 * @author zhangjun
 * @since 2023/12/23 13:00
 */
public class Solution1962 {
    private int [] heap;

    public int minStoneSum(int[] piles, int k) {
        heap = piles;
        for(int i = piles.length / 2;i >= 0;i--){
            heapIFY(i);
        }
        while(k-- > 0){
            reduce();
        }
        int sum = 0;
        for(int i = 0;i < piles.length;i++){
            sum += piles[i];
        }
        return sum;
    }

    private void heapIFY(int root){
        int child = (root << 1) + 1;
        int max = root;
        if(child < heap.length && heap[child] > heap[max]){
            max = child;
        }
        if(++child < heap.length && heap[child] > heap[max]){
            max = child;
        }
        if(max != root){
            int t = heap[root];
            heap[root] = heap[max];
            heap[max] = t;
            heapIFY(max);
        }
    }

    private void sink(int root){
        int rootValue = heap[root];
        int child;
        while((child = (root << 1) + 1) < heap.length){
            if(child + 1 < heap.length && heap[child] < heap[child + 1]){
                ++child;
            }
            if(heap[child] <= rootValue){
                break;
            }
            heap[root] = heap[child];
            root = child;
        }
        heap[root] = rootValue;
    }

    private void reduce(){
        heap[0] = (heap[0] + 1) / 2;
        sink(0);
    }
}
