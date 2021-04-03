package medium;

/**
 * @author zhangjun
 * @date 2021/1/25
 */
public class Solution959 {
    public int regionsBySlashes(String[] grid) {
        int wide = grid.length;
        int newWide = 3 * wide;
        boolean [][] map = new boolean[newWide][newWide];

        for(int i = 0; i < wide; i++){
            for(int j = 0; j < wide; j++){
                switch(grid[i].charAt(j)){
                    case '/':map[i * 3 + 2][j * 3] = true;map[i * 3 + 1][j * 3 + 1] = true;map[i * 3][j * 3 + 2] = true;break;
                    case '\\':map[i * 3][j * 3] = true;map[i * 3 + 1][j * 3 + 1] = true;map[i * 3 + 2][j * 3 + 2] = true;break;
                }
            }
        }

        int count = 0;
        for(int row = 0;row < newWide;row++){
            for(int column = 0;column < newWide;column++){
               if(!map[row][column]) {
                   dfs(map,row,column,newWide);
                   count++;
               }
            }
        }

        return count;
    }

    private void dfs(boolean [][] map,int row,int column,int newWide){
        if(row >= newWide || column >= newWide || row < 0 || column < 0 || map[row][column]){
            return;
        }
        map[row][column] = true;

        dfs(map,row + 1,column,newWide);
        dfs(map,row - 1,column,newWide);
        dfs(map,row,column - 1,newWide);
        dfs(map,row,column + 1,newWide);

    }

    public static void main(String[] args) {
        Solution959 s = new Solution959();
        String [] grid1 = {" /", "/ "};
        String [] grid2 = {"//", "/ "};
        String [] grid3 = { " /", "  "};

        System.out.println(s.regionsBySlashes(grid1));//2;
        System.out.println(s.regionsBySlashes(grid2));//3;
        System.out.println(s.regionsBySlashes(grid3));//1;
    }
}
