package hard;

import tree.TreeNode;

import java.util.*;

/**
 * @author zhangjun
 * @version 2021/7/31
 */
public class Solution987 {
    private static class Node{
        private TreeNode treeNode;
        private int row;
        private int column;

        public Node(TreeNode treeNode, int row, int column) {
            this.treeNode = treeNode;
            this.row = row;
            this.column = column;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Deque<Node> queue = new LinkedList<>();
        Map<Integer,List<Node>> map = new HashMap<>();
        queue.offer(new Node(root,0,0));
        int min = 0;
        int max = 0;
        while(!queue.isEmpty()){
            Node n = queue.removeFirst();
            List<Node> list = map.get(n.column);
            if(list == null){
                list = new ArrayList<>();
                map.put(n.column,list);
            }
            if(n.column < min){
                min = n.column;
            } else if(n.column > max){
                max = n.column;
            }
            int index = list.size();
            for(int i = list.size() - 1;i >= 0;i--){
                Node t = list.get(i);
                if(n.row <= t.row && n.treeNode.val < t.treeNode.val){
                    index = i;
                }else{
                    break;
                }
            }
            list.add(index,n);
            if(n.treeNode.left != null) {
                queue.offer(new Node(n.treeNode.left,n.row + 1,n.column - 1));
            }
            if(n.treeNode.right != null) {
                queue.offer(new Node(n.treeNode.right,n.row + 1,n.column + 1));
            }
        }
        List<List<Integer>> result = new ArrayList<>(map.size());
        for(int i = min;i <= max;i++){
            List<Node> nodes = map.get(i);
            List<Integer> t = new ArrayList<>(nodes.size());
            for(Node node : nodes){
                t.add(node.treeNode.val);
            }
            result.add(t);
        }
        return result;
    }
}
