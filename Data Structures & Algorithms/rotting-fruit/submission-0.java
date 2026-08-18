class Solution {

    private static final int[][] DIRS = {
        {1, 0}, // down
        {0, 1}, // up
        {-1, 0},// left 
        {0, -1} // right
    };

    public int orangesRotting(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) return -1;

        int rows = grid.length;
        int cols = grid[0].length;
        int fresh = 0;
        int time = 0;
        Queue<int[]> q = new ArrayDeque<>();

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 1) fresh++;
                if (grid[r][c] == 2) {
                    q.offer(new int[]{r, c});
                }
            }
        }

        while (fresh > 0 && !q.isEmpty()) {
            int length = q.size();
            for (int i = 0; i < length; i++) {
                int[] curr = q.poll();

                for (int[] dir: DIRS) {
                    int nr = dir[0] + curr[0];
                    int nc = dir[1] + curr[1];

                    if (nr < 0 || nc < 0 || nr >= rows || nc >= cols || grid[nr][nc] != 1) continue;

                    grid[nr][nc] = 2;
                    fresh--;
                    q.offer(new int[]{nr, nc});
                }
            }
            time++;
        }
        return fresh == 0 ? time : -1;
    }
}
