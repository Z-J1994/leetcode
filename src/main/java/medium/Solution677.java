package medium;

public class Solution677 {
    static class MapSum {
        private final Node root;
        public MapSum() {
            root = new Node();
        }

        public void insert(String key, int val) {
            put(root,key,0,val);
        }

        public int sum(String prefix) {
            return get(root,prefix,0);
        }

        private int get(Node node,String prefix,int cursor){
            if(node == null){
                return 0;
            }
            if(cursor == prefix.length()){
                return node.sum;
            }
            if(node.children == null){
                return 0;
            }
            int index = prefix.charAt(cursor) - 97;
            return get(node.children[index],prefix,cursor + 1);
        }

        public int put(Node node,String key,int cursor,int value){
            if(cursor == key.length()){
                int difference = value - node.value;
                node.value = value;
                node.sum += difference;
                return difference;
            }
            if(node.children == null){
                node.children = new Node[26];
            }
            int index = key.charAt(cursor) - 97;
            if(node.children[index] == null){
                node.children[index] = new Node();
            }
            int difference = put(node.children[index],key,cursor + 1,value);
            node.sum += difference;
            return difference;
        }

        private static class Node{
            private int sum;
            private int value;
            private Node [] children;
        }
    }
}
