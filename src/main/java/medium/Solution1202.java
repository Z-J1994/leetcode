package medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution1202 {
    private int [] id;
    private int []sz;

    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        int length = s.length();

        initialUnionFind(length);

        for(List<Integer> l: pairs){
            union(l.get(0),l.get(1));
        }

        Map<Integer,MyList> map = new HashMap<>();
        char [] value = new char[length];

        for(int i = 0;i < length;i++){
            int t = find(i);
            MyList list = map.get(t);
            if(list == null){
                list = new MyList();
                map.put(t,list);
            }
            list.add(s.charAt(i));
        }

        for(MyList list : map.values()){
            list.sort();
        }

        for(int i = 0;i < length;i++){
            value[i] = map.get(id[i]).get();
        }
        return new String(value);
    }

    private static class MyList{
        char [] values;
        int capacity;
        int size;
        int start;
        public MyList(){
            capacity = 4;
            size = -1;
            start = -1;
            values = new char[capacity];
        }
        private void add(char element){
            if(size + 1 == capacity){
                resize();
            }
            values[++size] = element;
        }
        private char get(){
            return values[++start];
        }
        private void resize(){
            int newCapacity = capacity << 1;
            char []newValues = new char[newCapacity];
            for(int i = 0;i < capacity;i++){
                newValues[i] = values[i];
            }
            capacity = newCapacity;
            values = newValues;
        }

        private void sort(){
            sort(0,size);
        }
        private void sort(int lo,int hi){
            if(hi - lo <= 15){
                insertion(lo,hi);
                return;
            }
            int p = getPartition(lo, hi);
            sort(lo,p - 1);
            sort(p + 1,hi);
        }

        private int getPartition(int lo,int hi){
            int mid = (hi - lo) / 2 + lo;
            char minV = values[lo];
            char midV = values[mid];
            char maxV = values[hi];

            if(minV > midV){
                char t = minV;
                minV = midV;
                midV = t;
            }
            if(minV > maxV){
                char t = minV;
                minV = maxV;
                maxV = t;
            }
            if(midV > maxV){
                char t = midV;
                midV = maxV;
                maxV = t;
            }

            values[lo] = midV;
            values[mid] = minV;
            values[hi] = maxV;

            return partition(lo,hi);
        }

        private int partition(int lo,int hi){
            int i = lo;
            int j = hi;
            char pivot = values[lo];
            while(i < j){
                while(values[++i] < pivot);
                while(values[--j] > pivot);
                if(i < j){
                    char t = values[i];
                    values[i] = values[j];
                    values[j] = t;
                }
            }
            values[lo] = values[j];
            values[j] = pivot;

            return j;
        }

        private void insertion(int lo,int hi){
            for(int i = lo + 1,j;i <= hi;i++){
                char m = values[i];
                for(j = i;j > lo && values[j - 1] > m;j--){
                    values[j] = values[j - 1];
                }
                values[j] = m;
            }
        }
    }

    private void initialUnionFind(int length){
        id = new int[length];
        sz = new int[length];

        for(int i = 0;i < length;i++){
            id[i] = i;
            sz[i] = 1;
        }
    }

    private int find(int p){
        int t = id[p];
        if(p != t){
            t = find(t);
            id[p] = t;
        }
        return t;
    }

    private void union(int p,int q){
        int i = find(p);
        int j = find(q);

        if(sz[i] > sz[j]){
            id[j] = i;
            sz[i] += sz[j];
        }else{
            id[i] = j;
            sz[j] += sz[i];
        }

    }


    public static void main(String[] args) {
        Solution1202 s = new Solution1202();

        String s1 = "dcab";
        List<List<Integer>> pairs1 = Arrays.asList(Arrays.asList(0,3),Arrays.asList(1,2));

        String s2 = "dcab";
        List<List<Integer>> pairs2 = Arrays.asList(Arrays.asList(0,3),Arrays.asList(1,2),Arrays.asList(0,2));

        String s3 = "cba";
        List<List<Integer>> pairs3 = Arrays.asList(Arrays.asList(0,1),Arrays.asList(1,2));


        System.out.println(s.smallestStringWithSwaps(s1,pairs1));
        System.out.println(s.smallestStringWithSwaps(s2,pairs2));
        System.out.println(s.smallestStringWithSwaps(s3,pairs3));

    }
}
