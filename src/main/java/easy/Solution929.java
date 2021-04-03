package easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author zhangjun
 * @version 2020/10/03  19:47
 */
public class Solution929 {
//    int [] index;
//    public int numUniqueEmails(String[] emails) {
//
//        char [] [] chars = new char[emails.length][];
//        index = new int[emails.length];
//        for(int i = 0;i < chars.length;i++){
//            chars[i] = emails[i].toCharArray();
//            int j = 0;
//            int k = 0;
//            while(chars[i][j] != '@'){
//                if(chars[i][j] == '.'){
//                    j++;
//                }else if(chars[i][j] == '+'){
//                    while(chars[i][++j] != '@');
//                }else{
//                    chars[i][k++] = chars[i][j++];
//                }
//            }
//
//            System.arraycopy(chars[i],j,chars[i],k,chars[i].length - j);
//            if(j > k){
//                int length = chars[i].length - (j - k);
//                index[i] = length;
//            }else{
//                index[i] = chars[i].length;
//            }
//        }
//        quickString(chars,0,chars.length - 1,0);
//        int count = 1;
//        for(int i = 1;i < chars.length;i++){
//            if(index[i] != index[i - 1]){
//                count++;
//            }else{
//                for(int j = 0;j < index[i];j++){
//                    if(chars[i][j] != chars[i - 1][j]){
//                        count++;
//                        break;
//                    }
//                }
//            }
//        }
//        return  count;
//    }
//
//    private int charAt(char[][] chars,int column,int row){
//        return (column < index[row]) ? chars[row][column] : -1;
//    }
//
//    private void quickString(char[][] chars,int lo,int hi,int d){
//        if(lo < hi){
//            int lt = lo;
//            int gt = hi;
//            int v = charAt(chars,d,lo);
//            int i = lo + 1;
//
//            while(i <= gt){
//                int t = charAt(chars,d,i);
//                if(t < v){
//                    exchange(chars,lt++,i++);
//                }else if(t > v){
//                    exchange(chars,i,gt--);
//                }else{
//                    i++;
//                }
//            }
//            quickString(chars,lo,lt - 1,d);
//            if(v >= 0){
//                quickString(chars,lt,gt,d + 1);
//            }
//            quickString(chars,gt + 1,hi,d);
//        }
//    }
//    private void exchange(char[][] chars,int i,int j){
//        char [] c = chars[j];
//        chars[j] = chars[i];
//        chars[i] = c;
//
//        int t = index[i];
//        index[i] = index[j];
//        index[j] = t;
//    }

    public int numUniqueEmails(String[] emails) {

        char[][] chars = new char[emails.length][];
        for (int i = 0; i < chars.length; i++) {
            chars[i] = emails[i].toCharArray();
            int j = 0;
            int k = 0;
            while (chars[i][j] != '@') {
                if (chars[i][j] == '.') {
                    j++;
                } else if (chars[i][j] == '+') {
                    while (chars[i][++j] != '@') ;
                } else {
                    chars[i][k++] = chars[i][j++];
                }
            }

            System.arraycopy(chars[i], j, chars[i], k, chars[i].length - j);
            if (j > k) {
                int length = chars[i].length - (j - k);
                root = put(root,new String(chars[i],0,length));
            } else {
                root = put(root,new String(chars[i],0,chars[i].length));
            }
        }

        return size(root);
    }

    private final static boolean RED = true;
    private final static boolean BLACK = false;


    private Node root;

    private class Node{
        String key;
        Node left;
        Node right;
        int size;
        boolean color;

        public Node(String key,int size,boolean color){
            this.key = key;
            this.size = size;
            this.color = color;
        }
    }

    private int size(Node x){
        if(x == null){
            return 0;
        }
        return x.size;
    }

    private boolean isRed(Node x){
        if(x == null){
            return BLACK;
        }
        return x.color == RED;
    }

    private void flipColors(Node x){
        x.color = !x.color;
        x.left.color = !x.left.color;
        x.right.color = !x.right.color;
    }

    private Node rotateLeft(Node x){
        Node t = x.right;
        x.right = t.left;
        t.left = x;

        t.color = x.color;
        x.color = RED;

        t.size = x.size;
        x.size = size(x.left) + size(x.right) + 1;

        return t;
    }

    private Node rotateRight(Node x){
        Node t = x.left;
        x.left = t.right;
        t.right = x;

        t.color = x.color;
        x.color = RED;

        t.size = x.size;
        x.size = size(x.left) + size(x.right) + 1;

        return t;
    }

    private Node put(Node x,String key){
        if(x == null){
            return new Node(key,1,RED);
        }
        int cmp = key.compareTo(x.key);

        if(cmp < 0){
            x.left = put(x.left,key);
        }else if(cmp > 0){
            x.right = put(x.right,key);
        }

        if(isRed(x.right) && !isRed(x.left)){
            x = rotateLeft(x);
        }
        if(isRed(x.left) && isRed(x.left.left)){
            x = rotateRight(x);
        }
        if(isRed(x.right) && isRed(x.left)){
            flipColors(x);
        }
        x.size = size(x.left) + size(x.right) + 1;
        return x;
    }

}
