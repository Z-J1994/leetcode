package hard;

public class Solution768 {
    public int maxChunksToSorted(int[] arr) {
        int [] stack = new int [arr.length + 1];
        stack[0] = -1;
        int top = 0;
        int max = -1;
        for(int i : arr){
            while(stack[top] > i){
                --top;
            }
            max = Math.max(i,max);
            stack[++top] = max;
        }
        return top;
    }
}
