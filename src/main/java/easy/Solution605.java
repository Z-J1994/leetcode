package easy;

public class Solution605 {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if(n == 0){
            return true;
        }
        int length = flowerbed.length;
        if(n > (length + 1) / 2){
            return false;
        }
        if(length == 1){
            return flowerbed[0] == 0;
        }

        int start = 0;
        while(start < length && flowerbed[start] == 0){
            start++;
        }
        if(start == length){
            return true;
        }
        n -= start / 2;
        if(n <= 0){
            return true;
        }

        int end = length - 1;
        while(end > start && flowerbed[end] == 0){
            end--;
        }
        n -= (length - end - 1) / 2;
        if(n <= 0){
            return true;
        }

        for(int i = start,j = start - 1;i <= end;i++){
            if(flowerbed[i] == 1){
                int t = i - j - 2;
                n-= t / 2;
                if(n <= 0){
                    return true;
                }
                j = i;
                i++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution605 s = new Solution605();

        int [] flowerbed1 = {1,0,0,0,1};
        int n1 = 1;

        int [] flowerbed2 = {1,0,0,0,1};
        int n2 = 2;

        System.out.println(s.canPlaceFlowers(flowerbed1,n1));
        System.out.println(s.canPlaceFlowers(flowerbed2,n2));


    }
}
