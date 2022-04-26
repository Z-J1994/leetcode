package easy;

public class Solution941 {
    public boolean validMountainArray(int[] arr) {
        if(arr.length < 3){
            return false;
        }
        int i  = 0;
        while(++i < arr.length && arr[i] > arr[i - 1]);
        if(i >= arr.length || arr[i] == arr[i - 1] || i == 1){
            return false;
        }
        while(++i < arr.length && arr[i] < arr[i - 1]);
        return i >= arr.length;
    }
}
