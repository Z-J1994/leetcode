package medium;

public class Solution211 {

    private static class WordDictionary {

        private Node dictionary;

        public WordDictionary() {
            this.dictionary = new Node();
        }

        public void addWord(String word) {
            dictionary.add(word);
        }

        public boolean search(String word) {
            return dictionary.contains(word,0);
        }


        private static class Node{
            private Node[] children = new Node[26];
            private boolean last;

            private Node(){

            }

            private Node(boolean last){
                this.last = last;
            }

            private void add(String s){
                Node current = this;
                for(int i = 0;i < s.length();i++){
                    char c = s.charAt(i);
                    if(current.children[c - 97] == null){
                        current.children[c - 97] = new Node();
                    }
                    current = current.children[c - 97];
                }
                current.last = true;
            }

            private boolean contains(String s,int index){
                if(index == s.length()){
                    return last;
                }
                char c = s.charAt(index);
                if(c == '.'){
                    for(int i = 0;i < 26;i++){
                        if(children[i] != null && children[i].contains(s,index + 1)){
                            return true;
                        }
                    }
                }else if(children[c - 97] != null){
                    return children[c - 97].contains(s,index + 1);
                }
                return false;
            }
        }
    }

}
