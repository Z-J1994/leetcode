package easy;

import java.util.LinkedList;
import java.util.List;

/**
 * @author zhangjun
 * @version 2020/09/30  15:19
 */
public class Offer57 {
    public int[][] findContinuousSequence(int target) {
        LinkedList<int []> list = new LinkedList<>();
        int a1 = 1;
        int sum = 1;
        for(int an = 1;an <= target/2 + 1;){
            if(sum < target){
                an++;
                sum += an;
            }else if(sum > target){
                sum -= a1;
                a1++;
            }else{
                int [] temp = new int[an - a1 + 1];
                for(int i = 0;i < temp.length;i++){
                    temp[i] = a1 + i;
                }
                list.add(temp);
                an++;
                sum += an;
            }
        }
        int [][] result = new int[list.size()][];

        for(int i = 0;!list.isEmpty();i++){
            result[i] = list.removeFirst();
        }
        return result;
    }

}
