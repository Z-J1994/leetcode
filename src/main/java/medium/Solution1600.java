package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhangjun
 * @version 2021/6/20
 */
public class Solution1600 {

    private static class ThroneInheritance {

        private Map<String, ArrayList<String>> map = new HashMap<>();
        private Map<String, Integer> deathMap = new HashMap<>();
        private String kingName;

        public ThroneInheritance(String kingName) {
            this.kingName = kingName;
            map.put(kingName, new ArrayList<>());
        }

        public void birth(String parentName, String childName) {
            ArrayList<String> children = map.get(parentName);
            if (children == null) {
                children = new ArrayList<>();
                map.put(parentName, children);
            }
            children.add(childName);
        }

        public void death(String name) {
            deathMap.put(name, 1);
        }

        public List<String> getInheritanceOrder() {
            List<String> result = new ArrayList<>();
            dfs(result, kingName);
            return result;
        }

        private void dfs(List<String> result, String key) {
            if (!deathMap.containsKey(key)) {
                result.add(key);
            }
            ArrayList<String> children = map.get(key);
            if (children == null) {
                return;
            }
            for (String name : children) {
                dfs(result, name);
            }
        }
    }
}
