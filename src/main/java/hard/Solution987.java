package hard;

import tree.TreeNode;
import utils.Parser;
import utils.TreeUtil;

import java.util.*;

/**
 * @author zhangjun
 * @version 2021/7/31
 */
public class Solution987 {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Queue<Holder> queue = new ArrayDeque<>();
        Holder p  = new Holder(0,0,root);

        Map<Integer,List<Holder>> map = new TreeMap<>();
        queue.offer(p);
        while(!queue.isEmpty()){
            Holder h = queue.poll();
            List<Holder> list = map.get(h.column);
            if(list == null){
                map.put(h.column,list = new ArrayList<>());
            }
            int i = list.size();
            while(i > 0 && (p = list.get(i - 1)).level == h.level && p.node.val > h.node.val){
                i--;
            }
            list.add(i,h);
            if(h.node.left != null){
                queue.offer(new Holder(h.column - 1,h.level + 1,h.node.left));
            }
            if(h.node.right != null){
                queue.offer(new Holder(h.column + 1,h.level + 1,h.node.right));
            }
        }
        List<List<Integer>> result = new ArrayList<>(map.size());
        for(Map.Entry<Integer,List<Holder>> entry : map.entrySet()){
            List<Integer> l = new ArrayList<>();
            for(Holder h : entry.getValue()){
                l.add(h.node.val);
            }
            result.add(l);
        }
        return result;
    }


    private static class Holder{

        private int column;

        private int level;

        private TreeNode node;

        public Holder(int column,int level,TreeNode node){
            this.column = column;
            this.node = node;
            this.level = level;
        }
    }

    public static void main(String[] args) {
        Solution987 s = new Solution987();
        System.out.println(s.verticalTraversal(TreeUtil.from(Parser.StringToIntegerArray("[3,9,20,null,null,15,7]"))));
        System.out.println(s.verticalTraversal(TreeUtil.from(Parser.StringToIntegerArray("[0,1,2,4,5,9,3,11,null,null,10,15,null,6,18,14,null,null,21,null,null,7,12,null,null,22,null,null,24,13,8,null,17,null,null,null,null,null,null,16,19,null,null,null,null,23,20]"))));
        System.out.println(s.verticalTraversal(TreeUtil.from(Parser.StringToIntegerArray("[0,2,1,3,null,5,22,9,4,12,25,null,null,13,14,8,6,null,null,null,null,null,27,24,26,null,17,7,null,28,null,null,null,null,null,19,null,11,10,null,null,null,23,16,15,20,18,null,null,null,null,null,21,null,null,29]"))));
    }
}
