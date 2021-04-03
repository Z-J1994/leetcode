package medium;

/**
 * @author zhangjun
 * @date 2021/3/3
 */
public class Solution338 {
    public int[] countBits(int num) {
        int length = num + 1;
        int [] answer = new int[length];

        for(int i = 0;i < length;i++){
            answer[i] = bitCount(i);
        }

        return answer;
    }

    private int bitCount(int x){
        x = (x & 0x55555555) + ((x >>> 1) & 0x55555555);
        x = (x & 0x33333333) + ((x >>> 2) & 0x33333333);
        x = (x & 0x0f0f0f0f) + ((x >>> 4) & 0x0f0f0f0f);
        x = (x & 0x00ff00ff) + ((x >>> 8) & 0x00ff00ff);
        x = (x & 0x0000ffff) + ((x >>> 16) & 0x0000ffff);
        return x;
    }
}
