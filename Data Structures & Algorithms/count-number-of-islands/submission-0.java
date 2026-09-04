class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null) return 0; 
        int row = grid.length;
        int column = grid[0].length;
        int islandCount = 0;

        for (int i=0; i< row; i++){
            for(int j=0; j< column; j++){
                if (grid[i][j] == '1'){
                    islandCount++;
                    dfs(grid, i, j);
                }
            }
        }
        return islandCount;
    }

    private void dfs(char[][]grid, int row, int column) {
        if(row<0 || row >= grid.length|| column <0||column >= grid[0].length || grid[row][column] != '1'){
            return;
        }
        grid[row][column] = '0';
        dfs(grid, row, column+1);
        dfs(grid, row, column-1);
        dfs(grid, row+1, column);
        dfs(grid, row-1, column);
    }
}
