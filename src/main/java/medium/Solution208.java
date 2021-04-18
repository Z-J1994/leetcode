package medium;

/**
 * @author zhangjun
 * @version 2021/4/14
 */
public class Solution208 {
    class Trie {

        /** Initialize your data structure here. */
        public Trie() {

        }

        /** Inserts a word into the trie. */
        public void insert(String word) {
            root = insert(root,word,0);
        }

        /** Returns if the word is in the trie. */
        public boolean search(String word) {
            Node x = search(root,word,0);
            if(x == null){
                return false;
            }
            return x.end;
        }

        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            Node x = search(root,prefix,0);
            return x != null;
        }
        private Node root;

        private Node insert(Node x,String key,int index){
            if(x == null){
                x = new Node();
            }
            if(index == key.length()){
                x.end = true;
                return x;
            }
            int c = key.charAt(index) - 97;
            x.next[c] = insert(x.next[c],key,index + 1);
            return x;
        }

        private Node search(Node x,String key,int index){
            if(x == null){
                return null;
            }
            if(index == key.length()){
                return x;
            }
            return search(x.next[key.charAt(index) - 97],key,index + 1);
        }

    }

    private static class Node{
        private Node [] next = new Node [26];
        private boolean end;
    }
}
