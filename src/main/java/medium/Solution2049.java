package medium;

import java.io.IOException;

/**
 * @author zhangjun
 * @version 2022/3/11
 */
public class Solution2049 {
    public int countHighestScoreNodes(int[] parents) {
        int[][] children = new int[parents.length][3];
        for (int i = 1; i < parents.length; i++) {
            if (children[parents[i]][1] == 0) {
                children[parents[i]][1] = i;
            } else {
                children[parents[i]][2] = i;
            }
        }
        dfs(children, 0);
        int root = children[0][0];
        //哨兵,消除子节点为空的判断 children[i][1] == 0 ? 1 : children[children[i][1]][0]) -> children[children[i][1]][0]
        children[0][0] = 1;
        long max = ((long) (children[children[0][1]][0])) * (children[children[0][2]][0]), t;
        int count = 1;
        for (int i = 1; i < parents.length; i++) {
            t = ((long) children[children[i][1]][0]) * (children[children[i][2]][0]) * (root - children[i][0]);
            if (t > max) {
                max = t;
                count = 1;
            } else if (t == max) {
                count++;
            }
        }
        return count;
    }

    private int dfs(int[][] children, int index) {
        if (children[index][1] != 0) {
            children[index][0] += dfs(children, children[index][1]);
        }
        if (children[index][2] != 0) {
            children[index][0] += dfs(children, children[index][2]);
        }
        return children[index][0] += 1;
    }

    public static void main(String[] args) throws IOException {
        Solution2049 s = new Solution2049();
        System.out.println(s.countHighestScoreNodes(new int[]{-1, 2, 0, 2, 0}) == 3);
        System.out.println(s.countHighestScoreNodes(new int[]{-1, 2, 0}) == 2);
    }
}
