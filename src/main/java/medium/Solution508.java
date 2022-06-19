package medium;

import tree.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Solution508 {
    int max = 0;
    int n = 0;
    Map<Integer,Integer> map;
    public int[] findFrequentTreeSum(TreeNode root) {
        map = new HashMap<>();
        postOrder(root);
        int [] result = new int[n];
        for(Map.Entry<Integer,Integer> entry: map.entrySet()){
            if(entry.getValue() == max){
                result[--n] = entry.getKey();
            }
        }
        return result;
    }

    private int postOrder(TreeNode root){
        int t = root.val;
        if(root.left != null){
            t += postOrder(root.left);
        }
        if(root.right != null){
            t += postOrder(root.right);
        }

        int c = map.getOrDefault(t,0) + 1;
        if(c > max){
            max = c;
            n = 1;
        }else if(c == max){
            n++;
        }
        map.put(t,c);
        return t;
    }
}
