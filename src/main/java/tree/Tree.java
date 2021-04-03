package tree;

/**
 * @author zhangjun
 * @version 2020/09/24  16:11
 */
public class Tree {

    int size;
    public TreeNode root;
    int index;
    public Tree(Integer [] nums){
        for(Integer i:nums){
            root = put(root,i);
        }
    }

    private TreeNode put(TreeNode root,int v){
        if(root == null){
            return new TreeNode(v);
        }

        if(root.val >= v){
            root.left = put(root.left,v);
        }else{
            root.right = put(root.right,v);
        }
        return root;
    }

    public void inOrder(){
        inOrder(root);
    }

    private void inOrder(TreeNode root){
        if (root != null){
            inOrder(root.left);
            System.out.print(root.val + " ");
            inOrder(root.right);
        }
    }
}
