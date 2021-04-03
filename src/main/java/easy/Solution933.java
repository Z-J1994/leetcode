package easy;

import java.util.LinkedList;

/**
 * @author zhangjun
 * @version 2020/09/27  19:29
 */
public class Solution933 {

        LinkedList<Integer> list;
        int count;
        public void RecentCounter() {
            list = new LinkedList<>();
            count = 0;
        }

        public int ping(int t) {

            while(!list.isEmpty() && t - list.getFirst() > 3000){
                list.removeFirst();
                count--;
            }
            list.add(t);
            count++;
            return count;
        }

}
