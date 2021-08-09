package medium;

import java.util.TreeSet;

/**
 * @author zhangjun
 * @version 2021/8/9
 */
public class Solution313 {
    public int nthSuperUglyNumber(int n, int[] primes) {
        TreeSet<Integer> set = new TreeSet<>();
        set.add(1);
        int count = 0;
        int t = 1;
        while(count < n){
            t = set.pollFirst();
            for(int p : primes){
                if(p * t / p == t){
                    set.add(p * t);
                }
            }
            count++;
        }
        return t;
    }
}
