package medium;

import java.util.TreeMap;
import java.util.TreeSet;

/**
 * @author zhangjun
 * @version 2022/9/28
 */
public class Interview19_07 {
    public int getKthMagicNumber(int k) {
        TreeSet<Integer> set = new TreeSet<>();
        set.add(1);
        while(--k > 0){
            int t = set.pollFirst();
            set.add(t * 3);
            set.add(t * 5);
            set.add(t * 7);
        }
        return set.first();
    }



    public static void main(String[] args) {
        Interview19_07 s = new Interview19_07();
        System.out.println(s.getKthMagicNumber(4));
    }
}
