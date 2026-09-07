class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        if (grid ==null || grid.length ==0) return 0;

        int row = grid.length, column = grid[0].length;
        int maxArea = 0;
        for(int i =0; i<row; i++) {
            for(int j=0; j<column; j++){
                if (grid[i][j] == 1){
                    int area = dfs (grid, i, j);
                    maxArea = Math.max(maxArea, area);
                }
            }
        }
        return maxArea;
    }

    private int dfs(int[][]grid, int row, int column){
        if(row < 0 || row >= grid.length || column < 0 || column >= grid[0].length || grid[row][column] == 0) {
            return 0;
        }
        int area = 1;
        grid[row][column] = 0;
        area += dfs(grid, row-1, column);
        area += dfs(grid, row+1, column);
        area += dfs(grid, row, column-1);
        area += dfs(grid, row, column+1);

        return area;
    }
}
