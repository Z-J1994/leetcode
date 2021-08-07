package medium;

/**
 * @author zhangjun
 * @version 2021/8/7
 */
public class Solution457 {
    public boolean circularArrayLoop(int[] nums) {
        int n = nums.length;
        int [] visited = new int [n];
        for(int i = 0;i < n;i++){
            if(visited[i] == 0){
                if(visit(nums,visited,i)){
                    return true;
                }
            }
        }
        return false;

    }
    private boolean visit(int [] nums,int [] visited,int k){
        int to = k;
        while(visited[to] == 0){
            visited[to] = k + 1;
            int t = nums[to];
            to = getNext(to,nums);
            if(t * nums[to] < 0){
                return false;
            }
        }
        return visited[to] == k + 1 && to != getNext(to, nums);
    }
    private int getNext(int index,int [] nums){
        index += nums[index];
        int n = nums.length;
        if(index < 0){
            index = n + (index % n);
        }
        if(index >= n){
            index %= n;
        }
        return index;
    }
}
