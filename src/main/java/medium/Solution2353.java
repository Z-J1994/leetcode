package medium;

import utils.Invoker;

import java.util.*;

/**
 * @author zhangjun
 * @since 2025/2/28 12:38
 */
public class Solution2353 {

    class FoodRatings {

        private final Map<String, Object[]> foodMap = new HashMap<>();

        private final TreeMap<String, TreeMap<Integer,PriorityQueue<String>>> ratingMap = new TreeMap<>();

        public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
            for(int i = 0;i < foods.length;i++){
                foodMap.put(foods[i], new Object[]{cuisines[i], ratings[i]});
                TreeMap<Integer, PriorityQueue<String>> treeMap = ratingMap.computeIfAbsent(cuisines[i], k -> new TreeMap<>());
                treeMap.computeIfAbsent(ratings[i], k -> new PriorityQueue<>()).add(foods[i]);
            }
        }

        public void changeRating(String food, int newRating) {
            Object[] objects = foodMap.get(food);
            int originalRating = (int) objects[1];
            if(originalRating == newRating){
                return;
            }
            TreeMap<Integer, PriorityQueue<String>> map = ratingMap.get((String) objects[0]);
            PriorityQueue<String> set = map.get(originalRating);
            set.remove(food);
            if(set.isEmpty()){
                map.remove(originalRating);
            }
            map.computeIfAbsent(newRating,k -> new PriorityQueue<>()).add(food);
            objects[1] = newRating;
            foodMap.put(food, objects);
        }

        public String highestRated(String cuisine) {
            return ratingMap.get(cuisine).lastEntry().getValue().peek();
        }
    }


    public static void main(String[] args) {


        Object [] constructorParameters = new Object[]{new String[]{"emgqdbo","jmvfxjohq","qnvseohnoe","yhptazyko","ocqmvmwjq"},new String[]{"snaxol","snaxol","snaxol","fajbervsj","fajbervsj"},new int[]{2,6,18,6,5}};
        Object [] parameters = new Object[]{null,new Object[]{"qnvseohnoe",11},new Object[]{"fajbervsj"},new Object[]{"emgqdbo",3},new Object[]{"jmvfxjohq",9},new Object[]{"emgqdbo",14},new Object[]{"fajbervsj"},new Object[]{"snaxol"}};

        Invoker.invoke(Solution2353.FoodRatings.class,constructorParameters,parameters,new String[parameters.length],new String[]{"FoodRatings","changeRating","highestRated","changeRating","changeRating","changeRating","highestRated","highestRated"});
    }
}
