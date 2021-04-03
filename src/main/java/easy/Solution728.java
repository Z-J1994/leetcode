package easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangjun
 * @version 2020/09/23  16:28
 */
public class Solution728 {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> list = new ArrayList<>();
        for(int i = left;i <= right;i++){
            if(findNumber(i)){
                list.add(i);
            }
        }
        return list;
    }

    private boolean findNumber(int n){
        int t = n;
        while(t > 0){
            int b = t % 10;
            t /= 10;
            if(b == 0 || n % b != 0){
                return false;
            }
        }
        return true;
    }
}
