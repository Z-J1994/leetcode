package medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * @author zhangjun
 * @version 2021/6/25
 */
public class Solution752 {
    private static class Pair{
        private final char [] key;
        private final int distance;
        private Pair(char [] key,int distance){
            this.key = Arrays.copyOf(key,key.length);
            this.distance = distance;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return Arrays.equals(key, pair.key);
        }

        @Override
        public int hashCode() {
            return Arrays.hashCode(key);
        }
    }

    public int openLock(String[] deadends, String target) {
        Set<Pair> visited = new HashSet<>();
        for(String s : deadends){
            if("0000".equals(s)){
                return -1;
            }
            visited.add(new Pair(s.toCharArray(),-1));
        }
        LinkedList<Pair> queue = new LinkedList<>();
        queue.offer(new Pair("0000".toCharArray(),0));
        Pair t = new Pair(target.toCharArray(),-1);
        Pair p;
        while(!queue.isEmpty()){
            p = queue.poll();
            if(t.equals(p)){
                return p.distance;
            }
            findLinked(p,queue,visited);
        }
        return -1;
    }

    private void findLinked(Pair pair,LinkedList<Pair> queue,Set<Pair> visited){
        char [] chars = pair.key;
        int distance = pair.distance;
        Pair p;
        for(int i = 0;i < 4;i++){
            char t = chars[i];
            chars[i] = (char)(t + 1);
            if(chars[i] > '9'){
                chars[i] = '0';
            }
            p = new Pair(chars,distance + 1);
            if(!visited.contains(p)){
                queue.offer(p);
                visited.add(p);
            }
            chars[i] = (char)(t - 1);
            if(chars[i] < '0'){
                chars[i] = '9';
            }
            p = new Pair(chars,distance + 1);
            if(!visited.contains(p)){
                queue.offer(p);
                visited.add(p);
            }
            chars[i] = t;
        }
    }
}
