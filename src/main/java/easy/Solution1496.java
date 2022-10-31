package easy;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Solution1496 {
    public boolean isPathCrossing(String path) {
        Set<Pair> set = new HashSet<>();
        set.add(new Pair(0,0));
        for(int i = 0,x = 0,y = 0,length = path.length();i < length;i++){
            switch(path.charAt(i)){
                case 'E': x++;break;
                case 'S': y--;break;
                case 'W': x--;break;
                case 'N': y++;break;
            }
            if(!set.add(new Pair(x,y))){
                return true;
            }
        }
        return false;
    }

    private static class Pair{
        int x;
        int y;
        private Pair(int x,int y){
            this.x = x;
            this.y = y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

        @Override
        public boolean equals(Object o){
            if(o == this){
                return true;
            }else if(o == null || o.getClass() != this.getClass()){
                return false;
            }
            Pair other = (Pair)o;
            return x == other.x && y == other.y;
        }
    }

    public static void main(String[] args) {
        Solution1496 s = new Solution1496();
        System.out.println(s.isPathCrossing("NESWW"));
    }
}
