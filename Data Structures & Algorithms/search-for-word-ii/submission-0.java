class Solution {

    private static final int[][] DIRS = {
        {1, 0},
        {0, 1},
        {-1, 0},
        {0, -1}
    };

    public List<String> findWords(char[][] board, String[] words) {
        int rows = board.length;
        int cols = board[0].length;
        List<String> result = new ArrayList<>();

        TrieNode root = buildTrie(words);

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                dfs(board, root, r, c, result);
            }
        }
        return result;
    }

    private void dfs(char[][] board, TrieNode root, int r, int c, List<String> result) {
        char ch = board[r][c];

        TrieNode next = root.children.get(ch);
        if (next == null) return;
        
        if (next.word != null) {
            result.add(next.word);
            next.word = null;
        }

        board[r][c] = '#';
        for (int[] dir: DIRS) {
            int rn = r + dir[0];
            int cn = c + dir[1];
            if (rn < 0 || rn >= board.length || cn < 0 || cn >= board[0].length) continue;
            dfs(board, next, rn, cn, result);
        }
        board[r][c] = ch;
    }

    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (int i = 0; i < words.length; i++) {
            TrieNode node = root;
            String word = words[i];
            for (char c : word.toCharArray()) {
                node = node.children.computeIfAbsent(c, k -> new TrieNode());
            }
            node.word = word;
        }
        return root;
    }

    private class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        String word;
    }
}
