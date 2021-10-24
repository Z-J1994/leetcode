package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution638 {
    private int min = 0x7fffffff;
    private List<Integer> price;
    private List<List<Integer>> special;
    private List<Integer> needs;
    private int n;
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        this.price = price;
        this.special = special;
        this.needs = needs;
        n = price.size();
        dfs(new int [n] ,0,0);

        return min;
    }

    private void dfs(int [] selected,int index,int sum){
        if(index == special.size()){
            //补齐缺少的物品数量
            for(int i = 0;i < n;i++){
                sum += (needs.get(i) - selected[i]) * price.get(i);
            }
            if(sum < min){
                min = sum;
            }
            return;
        }

        //本轮不选择套餐
        dfs(selected,index + 1,sum);

        //选择当前套餐
        int c = add(selected,special.get(index));
        sum += special.get(index).get(n);
        //物品数量小于需要购买的数量
        if(c == -1){
            //继续选择当前套餐
            dfs(selected,index,sum);
            //选择下一个套餐
            dfs(selected,index + 1,sum);

        }
        //物品数量等于需要购买的数量
        else if(c == -2 && sum < min){
            min = sum;
        }
        //退回本轮选择的套餐
        remove(selected,special.get(index),c);
    }

    private int add(int [] selected,List<Integer> special){
        int i = 0;
        int flag = -2;
        for(;i < selected.length;i++){
            selected[i] += special.get(i);
            if(selected[i] > needs.get(i)){
                return i;
            }else if(selected[i] < needs.get(i)){
                flag = -1;
            }
        }
        return flag;
    }

    private void remove(int [] selected,List<Integer> special,int index){
        if(index < 0){
            index = n - 1;
        }
        for(int i = 0;i <= index;i++){
            selected[i] -= special.get(i);
        }
    }


    public static void main(String[] args) {
        Solution638 s = new Solution638();


        List<List<Integer>> special = new ArrayList<>();
        List<Integer> special1 = new ArrayList<>(Arrays.asList(1,1,0,4));
        List<Integer> special2 = new ArrayList<>(Arrays.asList(2,2,1,9));

        special.add(special1);
        special.add(special2);

        System.out.println(s.shoppingOffers(Arrays.asList(2, 3, 4), special, Arrays.asList(1, 2, 1)));
    }
}
