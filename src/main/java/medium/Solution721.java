package medium;

import java.util.*;

/**
 * @author zhangjun
 * @date 2021/1/18
 */
public class Solution721 {
    private int []id;
    private int [] size;

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int count = 0;
        Map<String,Integer> map = new HashMap<>();

        for(List<String> as:accounts){
            Iterator<String> it = as.listIterator();
            it.next();
            while(it.hasNext()){
                String email = it.next();
                if(!map.containsKey(email)){
                    map.put(email,count++);
                }
            }
        }

        map = new HashMap<>();

        id = new int[count];
        size = new int[count];
        String [] names = new String[count];
        String [] values = new String[count];
        for(int i = 0;i < count;i++){
            id[i] = i;
            size[i] = 1;
        }

        count = 0;
        for(List<String> as:accounts){
            Iterator<String> it = as.listIterator();
            String name = it.next();

            int t = count;
            if(it.hasNext()){
                String email = it.next();
                Integer g = map.get(email);
                if(g == null){
                    map.put(email,count);
                    names[count] = name;
                    values[count] = email;
                    g = count;
                    ++count;
                }
                t = g;
            }

            while(it.hasNext()){
                String email = it.next();
                Integer index = map.get(email);
                if(index == null){
                    map.put(email,count);
                    names[count] = name;
                    values[count] = email;
                    index = count;
                    count++;
                }
                union(index,t);
            }
        }

        LinkedList<String> [] result = new LinkedList[id.length];

        int previous = -1;
        for(int i = 0,l = id.length;i < l;i++){
            int t = find(i);
            if(t != previous){
                if(result[t] == null){
                    result[t] = new LinkedList<>();
                    result[t].add(names[t]);
                }
                result[t].add(values[i]);
            }
        }

        List<List<String>> list = new ArrayList<>();
        for(int i = 0,l = result.length;i < l;i++){
            List<String> t = result[i];
            if(t != null){
                t.sort(String::compareTo);
                list.add(t);
            }
        }
        return list;
    }

    private int find(int p){
        int t = id[p];
        if(t != p){
            t = find(t);
            id[p] = t;
        }
        return t;
    }

    private void union(int p,int q){
        int i = find(p);
        int j = find(q);

        if(i == j){
            return;
        }
        if(size[i] > size[j]){
            size[i] += size[j];
            id[j] = i;
        }else{
            size[j] += size[i];
            id[i] = j;
        }
    }

    public static void main(String[] args) {
        Solution721 s = new Solution721();

        List<List<String>> list1 = new ArrayList<>();
        list1.add(Arrays.asList("John","johnsmith@mail.com","john_newyork@mail.com"));
        list1.add(Arrays.asList("John","johnsmith@mail.com","john00@mail.com"));
        list1.add(Arrays.asList("John","johnnybravo@mail.com"));
        list1.add(Arrays.asList("Mary","mary@mail.com"));

        List<List<String>> result1 = s.accountsMerge(list1);
        for(List<String> l1 : result1){
            System.out.println(l1.toString());
        }
    }
}