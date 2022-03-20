package easy;

/**
 * @author zhangjun
 * @version 2022/3/17
 */
public class Solution720 {
    public String longestWord(String[] words) {
        Trie trie = new Trie();
        for (String s : words) {
            trie.add(s);
        }
        return trie.getMax();
    }

    private static class TrieNode {
        private final TrieNode[] children = new TrieNode[26];
        private String key;
        private boolean end;
    }

    private static class Trie {

        private final TrieNode root;
        private String max;

        public Trie() {
            root = new TrieNode();
            root.end = true;
            root.key = "";
        }

        private void add(String key) {
            TrieNode c = root;
            for (int i = 0; i < key.length(); i++) {
                if (c.children[key.charAt(i) - 97] == null) {
                    TrieNode n = new TrieNode();
                    c.children[key.charAt(i) - 97] = n;
                }
                c = c.children[key.charAt(i) - 97];
            }
            c.key = key;
            c.end = true;
        }

        private String getMax() {
            max = "";
            dfs(root);
            return max;
        }

        private void dfs(TrieNode root) {
            if (root == null) {
                return;
            }
            for (int i = 0; i < 26; i++) {
                if (root.end) {
                    if(root.key.length() > max.length()){
                        max = root.key;
                    }
                    dfs(root.children[i]);
                }
            }
        }
    }


    public static void main(String[] args) {
        Solution720 s = new Solution720();
        System.out.println(s.longestWord(new String[]{"w", "wo", "wor", "worl", "world"}));
    }
}
