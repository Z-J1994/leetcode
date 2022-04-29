package medium;

import tree.Node;

public class Solution427 {
    public Node construct(int[][] grid) {
        return dfs(grid, 0, 0, grid.length);
    }

    private Node dfs(int[][] grid, int row, int column, int n) {
        if (n == 1) {
            return new Node(grid[row][column] == 1, true);
        }
        n /= 2;
        Node topLeft = dfs(grid, row, column, n);
        Node topRight = dfs(grid, row, column + n, n);
        Node bottomLeft = dfs(grid, row + n, column, n);
        Node bottomRight = dfs(grid, row + n, column + n, n);

        if (topLeft.isLeaf && topLeft.val == topRight.val && topRight.isLeaf && topRight.val == bottomLeft.val && bottomLeft.isLeaf && bottomLeft.val == bottomRight.val && bottomRight.isLeaf) {
            return new Node(topLeft.val, true);
        }
        return new Node(true, false, topLeft, topRight, bottomLeft, bottomRight);
    }


    public static void main(String[] args) {
        Solution427 s = new Solution427();
        s.construct(new int[][]{{1, 1, 1, 1, 0, 0, 0, 0}, {1, 1, 1, 1, 0, 0, 0, 0}, {1, 1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 0, 0, 0, 0}, {1, 1, 1, 1, 0, 0, 0, 0}, {1, 1, 1, 1, 0, 0, 0, 0}, {1, 1, 1, 1, 0, 0, 0, 0}});
        s.construct(new int[][]{{1, 1, 0, 0}, {1, 1, 0, 0}, {0, 0, 1, 1}, {0, 0, 1, 1}});
    }
}

// 1 1 0 0
// 1 1 0 0
// 0 0 1 1
// 0 0 1 1