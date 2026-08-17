class Solution {

    private static final int[][] DIRS = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public void islandsAndTreasure(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) return;

        int rows = grid.length;
        int cols = grid[0].length;

        Queue<int[]> q = new ArrayDeque<>();

        // add all treasures to the queue
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 0) {
                    q.offer(new int[]{r, c});
                }
            }
        }

        // multi source bfs
        while (!q.isEmpty()) {
            int[] curr = q.poll();

            for (int[] dir: DIRS) {
                int nr = curr[0] + dir[0];
                int nc = curr[1] + dir[1];

                if (nr < 0 || nc < 0 || nr >= rows || nc >= cols || grid[nr][nc] != Integer.MAX_VALUE) continue;

                grid[nr][nc] = 1 + grid[curr[0]][curr[1]];
                q.offer(new int[]{nr, nc});
            }
        }
    }

}
