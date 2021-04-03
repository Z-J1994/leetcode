package easy;

public class Solution1046 {
    public int lastStoneWeight(int[] stones) {
        int length = stones.length - 1;
        if(length == 0){
            return stones[0];
        }

        buildHeap(stones,length);

        for(int i = 0,l = length;i < l;i++){
            int t = pop(stones,length--) - stones[0];
            if(t < 0){
                t = -t;
            }
            stones[0] = t;
            heapIFY(stones,0,length);
        }
        return stones[0];
    }

    private void buildHeap(int [] stones,int hi){
        for(int i = (hi - 1) / 2;i >= 0;i--){
            heapIFY(stones,i,hi);
        }
    }

    private void heapIFY(int [] stones,int index,int hi){
        int max = index;

        do{
            index = max;
            int left = index * 2 + 1;
            int right = index * 2 + 2;

            if(left <= hi && stones[left] > stones[max]){
                max = left;
            }
            if(right <= hi && stones[right] > stones[max]){
                max = right;
            }
            int t = stones[index];
            stones[index] = stones[max];
            stones[max] = t;

        }while(max != index);

    }

    private int pop(int [] stones,int hi){
        int max = stones[0];
        stones[0] = stones[hi];
        heapIFY(stones,0,hi - 1);
        return max;
    }

    public static void main(String[] args) {
        Solution1046 s = new Solution1046();

        int [] stones1 = {2,7,4,1,8,1};
        int [] stones2 = {9,3,2,10};
        int [] stones3 = {1};
        int [] stones4 = {4,8,3,8,3,10,7};

        System.out.println(s.lastStoneWeight(stones1));//1
        System.out.println(s.lastStoneWeight(stones2));//0
        System.out.println(s.lastStoneWeight(stones3));//1
        System.out.println(s.lastStoneWeight(stones4));//1
    }
}
