package hard;

/**
 * @author zhangjun
 * @date 2021/1/31
 */
public class Solution839 {
    public int numSimilarGroups(String[] strs) {

        int count = strs.length;
        int [] id = new int[count];
        int [] size = new int[count];

        for(int i = 0;i < count;i++){
            id[i] = i;
            size[i] = 1;
        }

        for(int i = 0,l = count;i < l;i++){
            for(int j = i + 1;j < l;j++){

                if(find(id,i) == find(id,j)){
                    continue;
                }

                if(similar(strs[i],strs[j])){
                    count-= 1;
                    union(id,size,i,j);
                }
            }
        }
        return count;
    }

    private boolean similar(String s1,String s2){
        for(int i = 0,l = s1.length(),count = 0;i < l;i++){
            if(s1.charAt(i) != s2.charAt(i)){
                if(count == 2){
                    return false;
                }
                count++;
            }
        }
        return true;
    }

    private int find(int[] id,int p){
        int t = id[p];
        if(t != p){
            t = find(id,t);
            id[p] = t;
        }
        return t;
    }

    private void union(int [] id,int []size,int p,int q){
        p = find(id,p);
        q = find(id,q);
        if(size[p] > size[q]){
            size[p] += size[q];
            id[q] = p;
        }else {
            size[q] += size[p];
            id[p] = q;
        }
    }

    public static void main(String[] args) {
        Solution839 s = new Solution839();

        String [] str3 = {"kccomwcgcs","socgcmcwkc","sgckwcmcoc","coswcmcgkc","cowkccmsgc","cosgmccwkc","sgmkwcccoc","coswmccgkc","kowcccmsgc","kgcomwcccs"};
        System.out.println(s.numSimilarGroups(str3));
    }
}
