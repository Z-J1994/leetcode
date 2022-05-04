package easy;

public class Offer62 {
    public int lastRemaining(int n, int k) {
        int index = 0;
        for(int i = 2;i <= n;i++){
            index = (index + k) % i;
        }
        return index;
    }
}
