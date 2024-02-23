package medium;

import tree.TreeNode;
import utils.Parser;
import utils.TreeUtil;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author zhangjun
 * @since 2024/2/23 19:41
 */
public class Solution2583 {
    public long kthLargestLevelSum(TreeNode root, int k) {
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.add(root);
        int size = 1;
        List<Long> list = new ArrayList<>();
        long sum = 0;
        while (!deque.isEmpty()) {
            TreeNode treeNode = deque.poll();
            sum += treeNode.val;
            if (treeNode.left != null) {
                deque.add(treeNode.left);
            }
            if (treeNode.right != null) {
                deque.add(treeNode.right);
            }
            if (--size == 0) {
                list.add(sum);
                sum = 0;
                size = deque.size();
            }
        }
        if(k > list.size()){
            return -1;
        }
        long [] data = new long[list.size()];
        for (int i = 0; i < list.size(); i++) {
            data[i] = list.get(i);
        }
        quickSelect(data, data.length - k, 0, data.length - 1);
        return data[data.length - k];
    }

    private void quickSelect(long [] data, int k, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        int p = mixed(data, lo, hi);
        if(p == k){
            return;
        }
        quickSelect(data, k, lo, p - 1);
        quickSelect(data, k, p + 1, hi);
    }


    private int mixed(long [] data, int lo, int hi) {
        long min = data[lo], mid = data[(lo + hi) >>> 1], max = data[hi];

        if (min > mid) {
            long temp = min;
            min = mid;
            mid = temp;
        }
        if (min > max) {
            long temp = min;
            min = max;
            max = temp;
        }
        if (mid > max) {
            long temp = mid;
            mid = max;
            max = temp;
        }
        data[lo] = mid;
        data[hi] = max;
        data[(lo + hi) >>> 1] = min;
        return partition(data, lo, hi);
    }

    private int partition(long [] data, int lo, int hi) {
        long v = data[lo];
        int i = lo;
        hi += 1;
        while (true) {
            while (v > data[++i]) ;
            while (--hi > i && v < data[hi]);
            if(i >= hi){
                break;
            }
            long temp = data[i];
            data[i] = data[hi];
            data[hi] = temp;
        }
        data[lo] = data[--i];
        data[i] = v;
        return i;
    }


    public static void main(String[] args) {
        Solution2583 s = new Solution2583();
//        System.out.println(s.kthLargestLevelSum(TreeUtil.from(Parser.StringToIntegerArray("[5,8,9,2,1,3,7,4,6]")), 2) == 13);
        System.out.println(s.kthLargestLevelSum(TreeUtil.from(Parser.StringToIntegerArray("[5,8,9,2,1,3,7]")), 4) == -1);
    }
}
