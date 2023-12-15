package medium;

import hard.Solution2454;
import tree.TreeNode;
import utils.Parser;
import utils.TreeUtil;

/**
 * @author zhangjun
 * @since 2023/12/15 13:35
 */
public class Solution2415 {
    public TreeNode reverseOddLevels(TreeNode root) {
        int height = getHeight(root);
        TreeNode [] queue = new TreeNode[1 << height];
        int length = queue.length - 1;
        queue[0] = root;
        for(int i = 0,j = 0,l = length >> 1;i < l;i++){
            queue[++j] = queue[i].left;
            queue[++j] = queue[i].right;
        }
        for(int i = 1;i < height;i += 2){
            for(int start = (1 << i) - 1,end = (1 << (i + 1)) - 2;start < end;start++,end--){
                int t = queue[start].val;
                queue[start].val = queue[end].val;
                queue[end].val = t;
            }
        }
        return root;
    }

    private int getHeight(TreeNode root){
        if(root == null){
            return 0;
        }
        return getHeight(root.left) + 1;
    }

    public static void main(String[] args) {
        Solution2415 s = new Solution2415();
        s.reverseOddLevels(TreeUtil.from(Parser.StringToIntegerArray("[2,3,5,8,13,21,34]")));
        s.reverseOddLevels(TreeUtil.from(Parser.StringToIntegerArray("[7,13,11]")));
        s.reverseOddLevels(TreeUtil.from(Parser.StringToIntegerArray("[0,1,2,0,0,0,0,1,1,1,1,2,2,2,2]")));
    }
}
