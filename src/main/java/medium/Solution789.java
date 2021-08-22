package medium;

/**
 * @author zhangjun
 * @version 2021/8/22
 */
public class Solution789 {
    public boolean escapeGhosts(int[][] ghosts, int[] target) {
        int distance = Math.abs(target[0]) + Math.abs(target[1]);
        for(int [] ghost :ghosts){
            if(Math.abs(ghost[0] - target [0]) + Math.abs(ghost[1] - target[1]) <= distance){
                return false;
            }
        }
        return true;
    }
}
