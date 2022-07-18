package hard;

import utils.Parser;

import java.util.*;

public class Solution749 {

    private static final int[][] DIRECTIONS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    private int[][] isInfected;

    private Map<Integer, ConnectedComponent> components;

    public int containVirus(int[][] isInfected) {
        for (int i = 0; i < isInfected.length; i++) {
            for (int j = 0; j < isInfected[0].length; j++) {
                isInfected[i][j]--;
            }
        }
        this.isInfected = isInfected;
        this.components = getConnectedComponents();
        int firewalls = 0;
        while (components.size() > 0) {
            int maxInfection = -1;
            int firewall = 0;
            int count = -1;
            for (Map.Entry<Integer, ConnectedComponent> entrySet : components.entrySet()) {
                int[] infection = entrySet.getValue().getInfection();
                if (infection[0] > maxInfection) {
                    maxInfection = infection[0];
                    firewall = infection[1];
                    count = entrySet.getKey();
                }
            }
            firewalls += firewall;
            components.remove(count);
            for (Map.Entry<Integer, ConnectedComponent> entrySet : components.entrySet()) {
                entrySet.getValue().extend(entrySet.getKey());
            }
            union();
        }
        return firewalls;
    }

    private int find(int n) {
        int x = n / isInfected[0].length;
        int y = n % isInfected[0].length;
        if (isInfected[x][y] != n) {
            isInfected[x][y] = find(isInfected[x][y]);
        }
        return isInfected[x][y];
    }

    private void union() {
        int row = isInfected.length;
        int column = isInfected[0].length;
        Map<Integer, List<Integer>> relativeMap = new HashMap<>();
        for (Map.Entry<Integer, ConnectedComponent> entrySet : new HashSet<>(components.entrySet())) {
            List<Integer> relative = new ArrayList<>();
            for (int point : entrySet.getValue().points) {
                int ox = point / column;
                int oy = point % column;
                for (int[] direction : DIRECTIONS) {
                    int x = ox + direction[0];
                    int y = oy + direction[1];
                    if (x >= 0 && x < row && y >= 0 && y < column && isInfected[x][y] >= 0 && find(isInfected[ox][oy]) != find(isInfected[x][y]) && components.containsKey(isInfected[x][y])) {
                        relative.add(isInfected[x][y]);
                    }
                }
            }
            relativeMap.put(entrySet.getKey(), relative);
        }
        for (Map.Entry<Integer, List<Integer>> entrySet : relativeMap.entrySet()) {
            for (int point : entrySet.getValue()) {
                union(entrySet.getKey(), point);
            }
        }
    }

    private void union(int p, int q) {
        int i = find(p);
        int j = find(q);
        if (i == j) {
            return;
        }
        ConnectedComponent c1 = components.get(i);
        ConnectedComponent c2 = components.get(j);
        if (c1.points.size() > c2.points.size()) {
            int x = j / isInfected[0].length;
            int y = j % isInfected[0].length;
            isInfected[x][y] = i;
            c1.points.addAll(c2.points);
            components.remove(j);
        } else {
            int x = i / isInfected[0].length;
            int y = i % isInfected[0].length;
            isInfected[x][y] = j;
            c2.points.addAll(c1.points);
            components.remove(i);
        }
    }

    private static void dfs(int[][] isInfected, int ox, int oy, boolean[][] visited, ConnectedComponent component, int count) {
        for (int[] point : DIRECTIONS) {
            int x = ox + point[0];
            int y = oy + point[1];
            if (x >= 0 && x < isInfected.length && y >= 0 && y < isInfected[0].length && isInfected[x][y] >= 0 && !visited[x][y]) {
                visited[x][y] = true;
                isInfected[x][y] = count;
                component.points.add(x * isInfected[0].length + y);
                dfs(isInfected, x, y, visited, component, count);
            }
        }
    }

    private Map<Integer, ConnectedComponent> getConnectedComponents() {
        int count;
        Map<Integer, ConnectedComponent> components = new HashMap<>();
        int row = isInfected.length;
        int column = isInfected[0].length;
        boolean[][] visited = new boolean[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (!visited[i][j] && isInfected[i][j] >= 0) {
                    visited[i][j] = true;
                    ConnectedComponent connectedComponent = new ConnectedComponent();
                    count = i * column + j;
                    connectedComponent.points.add(count);
                    isInfected[i][j] = count;
                    components.put(count, connectedComponent);
                    dfs(isInfected, i, j, visited, connectedComponent, count);
                }
            }
        }
        return components;
    }

    private class ConnectedComponent {

        private final List<Integer> points = new ArrayList<>();

        private Set<Integer> extended;

        private int[] getInfection() {
            extended = new HashSet<>();
            int firewall = 0;
            int infection = 0;
            int row = isInfected.length;
            int column = isInfected[0].length;
            for (int point : points) {
                int ox = point / column;
                int oy = point % column;
                for (int[] direction : DIRECTIONS) {
                    int x = ox + direction[0];
                    int y = oy + direction[1];
                    if (x >= 0 && x < row && y >= 0 && y < column && isInfected[x][y] < 0) {
                        if (extended.add(x * column + y)) {
                            infection++;
                        }
                        firewall++;
                    }
                }
            }
            return new int[]{infection, firewall};
        }

        private void extend(int count) {
            for (int point : extended) {
                int x = point / isInfected[0].length;
                int y = point % isInfected[0].length;
                if (isInfected[x][y] < 0) {
                    isInfected[x][y] = count;
                    points.add(point);
                }
            }
            extended = null;
        }
    }

    public static void main(String[] args) {
        Solution749 s = new Solution749();
        System.out.println(s.containVirus(Parser.stringToIntMatrix("[[0,1,0,0,0,0,0,1],[0,1,0,0,0,0,0,1],[0,0,0,0,0,0,0,1],[0,0,0,0,0,0,0,0]]", 4, 8)) == 10);
        System.out.println(s.containVirus(Parser.stringToIntMatrix("[[1,1,1],[1,0,1],[1,1,1]]", 3, 3)) == 4);
        System.out.println(s.containVirus(Parser.stringToIntMatrix("[[1,1,1,0,0,0,0,0,0],[1,0,1,0,1,1,1,1,1],[1,1,1,0,0,0,0,0,0]]", 3, 9)) == 13);
        System.out.println(s.containVirus(Parser.stringToIntMatrix("[[1],[1]]", 1, 1)) == 0);
        System.out.println(s.containVirus(Parser.stringToIntMatrix("[[0,0,0,0,0,0,0,0,0,0],[0,0,0,0,0,0,0,1,0,0],[1,0,0,0,0,0,0,0,0,0],[0,0,1,0,0,0,1,0,0,0],[0,0,0,0,0,0,1,0,0,0],[0,0,0,0,0,0,0,0,0,0],[0,0,0,0,0,0,0,0,0,0],[0,0,0,0,0,0,0,0,1,0],[0,0,0,0,1,0,1,0,0,0],[0,0,0,0,0,0,0,0,0,0]]", 10, 10)) == 56);
    }
}
