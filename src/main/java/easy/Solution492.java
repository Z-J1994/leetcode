package easy;

public class Solution492 {
    public int[] constructRectangle(int area) {
        int x = (int)Math.sqrt(area);
        while(area % x != 0){
            --x;
        }

        return new int[]{area / x , x};
    }
}
