package medium;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangjun
 * @since 2022/8/22 13:27
 */
public class Solution655 {
    public List<List<String>> printTree(TreeNode root) {
        int height = getHeight(root);
        List<List<String>> matrix = new ArrayList<>(height);
        int size = 1 << height;
        dfs(matrix,0,(size - 1) >> 1,root,size);
        return matrix;
    }
    private int getHeight(TreeNode root){
        if(root == null){
            return 0;
        }
        return Math.max(getHeight(root.left),getHeight(root.right)) + 1;
    }

    private void dfs(List<List<String>> matrix, int row, int column, TreeNode root, int size){
        if(root == null){
            return;
        }
        List<String> line;
        if(matrix.size() <= row){
            line = new ArrayList<>(size);
            for(int i = 1;i < size;i++){
                line.add("");
            }
            matrix.add(line);
        }else{
            line = matrix.get(row);
        }
        line.set(column,String.valueOf(root.val));
        int t = size / (1 << (row + 2));
        ++row;
        dfs(matrix,row,column - t,root.left,size);
        dfs(matrix,row,column + t,root.right,size);
    }
}
