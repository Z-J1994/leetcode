package easy;

/**
 * @author zhangjun
 * @version 2020/10/09  22:12
 */
public class Interview05_01 {
    public int insertBits(int N, int M, int i, int j) {
        int mask;
        if(j == 31){
           mask = 0;
        }else{
            mask = -1 << (j + 1);
        }
        if(i != 0){
            mask += -1 >>> (32 - i);
        }
        N &= mask;
        N += M << i;
        return N;
    }
}
