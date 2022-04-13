package easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangjun
 * @version 2020/10/01  20:38
 */
public class Solution811 {
    List<String> list = new ArrayList<>();
    private Node root;

    public List<String> subdomainVisits(String[] cpdomains) {

        for(int i = 0;i < cpdomains.length;i++){
            char [] chars = cpdomains[i].toCharArray();
            int value = 0;
            int j;

            for(j = 0;chars[j] != ' ';j++,value *= 10){
                value += chars[j] - '0';
            }
            value /= 10;
            j++;
            root = put(root,new String(chars,j,chars.length - j),value);

            for(int t = chars.length - 1;t >= j;t--){
                if(chars[t] == '.'){
                    root = put(root,new String(chars,t + 1,chars.length - (t + 1)),value);
                }

            }
        }

        keys(root);
        return list;
    }



    private static class Node{
        String key;
        int value;
        Node left;
        Node right;
        int height;
        public Node(String key,int value,int height){
            this.key  = key;
            this.value = value;
            this.height = height;
        }
    }



    private int height(Node x){
        if(x == null){
            return -1;
        }
        return x.height;
    }

    private int balanceFactory(Node x){
        return Math.abs(height(x.left) - height(x.right));
    }

    private Node rotateLeft(Node x){
        Node t = x.right;
        x.right = t.left;
        t.left = x;

        x.height = Math.max(height(x.left) , height(x.right)) + 1;
        t.height = Math.max(height(t.left) , height(t.right)) + 1;
        return t;
    }

    private Node rotateRight(Node x){
        Node t = x.left;
        x.left = t.right;
        t.right = x;

        x.height = Math.max(height(x.left) , height(x.right)) + 1;
        t.height = Math.max(height(t.left) , height(t.right)) + 1;
        return t;
    }

    private Node balance(Node x){
        if(balanceFactory(x) > 1){
            if(balanceFactory(x.left) < 0){
                x.left = rotateLeft(x.left);
            }
            x = rotateRight(x);
        }else if(balanceFactory(x) < -1){
            if(balanceFactory(x.right) > 0){
                x.right = rotateRight(x.right);
            }
            x = rotateLeft(x);
        }
        return x;
    }

    private Node put(Node x,String key,int value){
        if(x == null){
            return new Node(key, value, 0);
        }
        int cmp = key.compareTo(x.key);
        if(cmp < 0){
            x.left = put(x.left,key,value);
        }
        else if(cmp > 0){
            x.right = put(x.right,key,value);
        }else{
            x.value += value;
        }

        return balance(x);
    }

    private void keys(Node x){
        if(x != null){
            list.add(x.value + " " + x.key);
            keys(x.left);
            keys(x.right);
        }
    }
}
