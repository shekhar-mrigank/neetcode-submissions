class Solution {
    public int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0) return -1;
        int rows = grid.length, cols = grid[0].length;
        int freshCount = 0;
        Queue<int[]> queue = new ArrayDeque<>();
        // Step 1: Find all initial rotten oranges and count fresh ones
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 2) {
                    queue.offer(new int[]{r, c});
                } else if (grid[r][c] == 1) {
                    freshCount++;
                }
            }
        }
        // If there are no fresh oranges to rot, 0 minutes are needed
        if (freshCount == 0) return 0;

        int minutes = 0;
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        // Step 2: Process rotten oranges minute-by-minute (level-by-level)
        while (!queue.isEmpty() && freshCount > 0) {
            int size = queue.size();
            minutes++; // One minute passes for this wave

            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                
                for (int[] dir : dirs) {
                    int nr = curr[0] + dir[0];
                    int nc = curr[1] + dir[1];

                    // If neighbor is within bounds and is a fresh orange
                    if (nr >= 0 && nr < rows && nc >= 0 && nc < cols && grid[nr][nc] == 1) {
                        grid[nr][nc] = 2; // Mark as rotten
                        freshCount--;     // Decrement fresh orange count
                        queue.offer(new int[]{nr, nc});
                    }
                }
            }
        }
        // Step 3: If any fresh orange couldn't be reached, return -1
        return freshCount == 0 ? minutes : -1;
    }
}
