package medium;

/**
 * @author zhangjun
 * @since 2022/7/11 12:37
 */
public class Solution676 {
    private static class MagicDictionary {
        private String [] dictionary;
        public MagicDictionary() {

        }

        public void buildDict(String[] dictionary) {
            this.dictionary = dictionary;
        }

        public boolean search(String searchWord) {
            for (String s : dictionary) {
                if (equals(s, searchWord)) {
                    return true;
                }
            }
            return false;
        }

        private boolean equals(String a,String b){
            if(a.length() == b.length()){
                int difference = 0;
                for (int i = 0,l = a.length(); i < l; i++) {
                    if(a.charAt(i) != b.charAt(i)){
                        if(++difference > 1){
                            return false;
                        }
                    }
                }
                return difference == 1;
            }
            return false;
        }
    }
}
