package easy;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhangjun
 * @version 2020/09/24  14:57
 */
public class Solution501 {
    int previous;
    int current;
    int n;
    int max;
    List<Integer> list = new ArrayList<>();
    public int[] findMode(TreeNode root) {
        findMin(root);
        previous--;
        inOrder(root);
        int [] result = new int[list.size()];
        int index = 0;
        for(int i : list){
            result[index++] = i;
        }
        return result;
    }

    private void findMin(TreeNode root){
        if(root != null){
            if(root.val < previous){
                previous = root.val;
            }
            findMin(root.left);
        }
    }

    private void inOrder(TreeNode root){
        if(root != null){
            inOrder(root.left);
            current = root.val;
            if (previous == current){
                n++;
            }else{
                previous = current;
                n = 0;
            }
            if(n == max){
                list.add(previous);
            }else if(n > max){
                list.clear();
                list.add(previous);
                max = n;
            }
            inOrder(root.right);
        }
    }
}

