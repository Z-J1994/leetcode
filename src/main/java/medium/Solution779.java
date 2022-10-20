package medium;

public class Solution779 {
    public int kthGrammar(int n, int k) {
        k -= 1;
        k = (k & 0x55555555) + ((k >> 1) & 0x55555555);
        k = (k & 0x33333333) + ((k >> 2) & 0x33333333);
        k = (k & 0x0F0F0F0F) + ((k >> 4) & 0x0F0F0F0F);
        k = (k & 0x00FF00FF) + ((k >> 8) & 0x00FF00FF);
        k = (k & 0x0000FFFF) + ((k >> 16) & 0x0000FFFF);
        return k & 1;
    }
}
