package easy;

/**
 * @author zhangjun
 * @version 2021/8/1
 */
public class Solution1337 {
    public static class Pair{
        private int army;
        private int row;
        public Pair(int army,int row){
            this.army = army;
            this.row = row;
        }
    }

    public int[] kWeakestRows(int[][] mat, int k) {
        int length = mat.length;
        Pair [] rows = new Pair[length];
        int column = mat[0].length;
        for(int i = 0;i < length;i++){
            rows[i] = new Pair(getArmy(mat[i]),i);
        }
        quickPick(rows,0,length - 1,k - 1);
        quickSort(rows,0,k - 1);

        int [] result = new int[k];
        for(int i = 0;i < k;i++){
            result[i] = rows[i].row;
        }
        return result;
    }
    private int getArmy(int [] rows){
        int lo = 0;
        int hi = rows.length - 1;
        int mid;
        while(lo <= hi){
            mid = lo + (hi - lo) / 2;
            if(rows[mid] > 0){
                lo = mid + 1;
            }else{
                hi = mid - 1;
            }
        }

        return lo;
    }

    private void quickPick(Pair [] rows,int lo,int hi,int k){
        if(lo < hi){
            int p = partition(rows,lo,hi);
            if(p < k){
                quickPick(rows,p + 1,hi,k);
            }else if(p > k){
                quickPick(rows,lo,p - 1,k);
            }
        }
    }

    private void quickSort(Pair [] rows,int lo,int hi){
        if(lo < hi){
            int p = partition(rows,lo,hi);
            quickSort(rows,p + 1,hi);
            quickSort(rows,lo,p - 1);
        }
    }

    private int partition(Pair [] rows,int lo,int hi){
        Pair pivot = rows[lo];
        int i = lo;
        int j = hi + 1;
        while(i < j){
            while(++i < j && compare(pivot,rows[i]));
            while(compare(rows[--j],pivot));

            if(i < j){
                Pair t = rows[i];
                rows[i] = rows[j];
                rows[j] = t;
            }

        }
        rows[lo] = rows[j];
        rows[j] = pivot;
        return j;
    }
    private boolean compare(Pair p1,Pair p2){
        if(p1.army > p2.army){
            return true;
        }else if(p1.army < p2.army){
            return false;
        }
        return p1.row > p2.row;
    }
}
