package easy;

/**
 * @author zhangjun
 * @version 2020/09/26  14:31
 */
public class Offer15 {
    //    public int hammingWeight(int n) {
//        int count = 0;
//        while(n != 0){
//            if((n & 0x1) == 1){
//                count++;
//            }
//            n >>>= 1;
//        }
//        return count;
//    }
    public int hammingWeight(int n) {
        n = (n & 0x55555555) + ((n >>> 1) & 0x55555555);
        n = (n & 0x33333333) + ((n >>> 2) & 0x33333333);
        n = (n & 0x0f0f0f0f) + ((n >>> 4) & 0x0f0f0f0f);
        n = (n & 0x00ff00ff) + ((n >>> 8) & 0x00ff00ff);
        n = (n & 0x0000ffff) + ((n >>> 16) & 0x0000ffff);
        return n;
    }

}
