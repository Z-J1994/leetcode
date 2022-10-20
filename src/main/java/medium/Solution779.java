package medium;

public class Solution779 {
    public int kthGrammar(int n, int k) {
        int c = 0;
        while(k != 1){
            c++;
            k -= get(k);
        }
        return c & 1;
    }

    private int get(int n){
        n -= 1;
        n |= n >> 1;
        n |= n >> 2;
        n |= n >> 4;
        n |= n >> 8;
        n |= n >> 16;
        return (n + 1) >> 1;
    }
}
