package medium;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution1305 {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> v1 = new ArrayList<>();
        List<Integer> v2 = new ArrayList<>();
        inOrder(v1, root1);
        inOrder(v2, root2);

        List<Integer> result = new ArrayList<>(v1.size() + v2.size());
        int i = 0,j = 0;
        int l1,l2;
        while(i < v1.size() && j < v2.size()){
            if((l1 = v1.get(i)) < (l2 = v2.get(j))){
                result.add(l1);
                i++;
            }else{
                result.add(l2);
                j++;
            }
        }
        while(i < v1.size()){
            result.add(v1.get(i++));
        }

        while(j < v2.size()){
            result.add(v2.get(j++));
        }
        return result;
    }

    private void inOrder(List<Integer> values, TreeNode root) {
        if (root != null) {
            inOrder(values, root.left);
            values.add(root.val);
            inOrder(values, root.right);
        }
    }

}
