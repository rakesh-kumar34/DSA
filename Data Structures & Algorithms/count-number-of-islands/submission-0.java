class Solution {

    /*
    1 0 0 1
    1 1 0 1
    1 1 0 1
    */
    private static final int[][] DIRS = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public int numIslands(char[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) return 0;

        int rows = grid.length;
        int cols = grid[0].length;

        boolean[][] visited = new boolean[rows][cols];
        int islandCount = 0;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (grid[row][col] == '1' && !visited[row][col]) {
                    islandCount++;
                    dfs(grid, visited, row, col);
                }
            }
        }
        return islandCount;
    }

    private void dfs(char[][] grid, boolean[][] visited, int row, int col) {
        int rows = visited.length;
        int cols = visited[0].length;
        visited[row][col] = true;

        for (int[] dir: DIRS) {
            int nextRow = row + dir[0];
            int nextCol = col + dir[1];

            // boundary, visited and '1' check
            if (nextRow < 0 || nextRow >= rows || nextCol < 0 || nextCol >= cols || visited[nextRow][nextCol] || grid[nextRow][nextCol] != '1') continue;
            dfs(grid, visited, nextRow, nextCol);
        }
    }
}
