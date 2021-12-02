package easy;

public class Solution506 {
    public String[] findRelativeRanks(int[] score) {
        int[][] data = new int[score.length][2];
        int length = score.length;
        for(int i = 0;i < length;i++){
            data[i][0] = score[i];
            data[i][1] = i;
        }
        quickSort(data,0,length - 1);

        String [] result = new String[length];
        result[data[length - 1][1]] = "Gold Medal";
        if(length > 1){
            result[data[length - 2][1]] = "Silver Medal";
        }
        if(length > 2){
            result[data[length - 3][1]] = "Bronze Medal";
        }
        for(int i = 4;i <= length;i++){
            result[data[length - i][1]] = String.valueOf(i);
        }
        return result;
    }

    private void quickSort(int [][] data,int lo,int hi){
        if(lo >= hi){
            return;
        }
        int pivot = random(data,lo,hi);
        quickSort(data,lo,pivot - 1);
        quickSort(data,pivot + 1,hi);
    }

    private int random(int [][] data,int lo,int hi){
        int mid = (lo + hi) >>> 1;
        int [] maxValue = data[hi];
        int [] minValue = data[lo];
        int [] midValue = data[mid];
        if(maxValue[0]  < minValue[0]){
            int [] t = minValue;
            minValue = maxValue;
            maxValue = t;
        }
        if(maxValue[0]  < midValue[0]){
            int [] t = midValue;
            midValue = maxValue;
            maxValue = t;
        }
        if(midValue[0] < minValue[0]){
            int [] t = midValue;
            midValue = minValue;
            minValue = t;
        }
        data[lo] = midValue;
        data[hi] = maxValue;
        data[mid] = minValue;
        return partition(data,lo,hi);
    }

    private int partition(int [][] data,int lo,int hi){
        int [] v = data[lo];
        int i = lo;
        int j = hi;
        while(true){
            while(data[++i][0] < v[0]);
            while(data[--j][0] > v[0]);
            if(i >= j){
                break;
            }
            int [] t = data[i];
            data[i] = data[j];
            data[j] = t;
        }

        data[lo] = data[j];
        data[j] = v;
        return j;
    }
}
