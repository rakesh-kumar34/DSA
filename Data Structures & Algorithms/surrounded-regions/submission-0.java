class Solution {

    private static final int[][] DIRS = {
        {1, 0},
        {0, 1},
        {-1, 0},
        {0, -1}
    };

    public void solve(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if ((r == 0 || r == rows - 1 || c == 0 || c == cols - 1) && board[r][c] == 'O') {
                    dfs(board, r, c);
                }
            }
        }

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (board[r][c] == 'O') board[r][c] = 'X';
                if (board[r][c] == '#') board[r][c] = 'O';
            }
        }

    }

    private void dfs(char[][] board, int r, int c) {
        board[r][c] = '#';

        for (int[] dir: DIRS) {
            int nr = dir[0] + r;
            int nc = dir[1] + c;

            if (nr < 0 || nr >= board.length || nc < 0 || nc >= board[0].length || board[nr][nc] != 'O') continue;
            dfs(board, nr, nc);
        }
    }
}
