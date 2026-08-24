class Solution {
    public int countComponents(int n, int[][] edges) {

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());

        for (int[] edge: edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        int count = 0;
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!visited[i] && dfs(i, adj, visited)) count++;
        }
        return count;
    }

    private boolean dfs(int i, List<List<Integer>> adj, boolean[] visited) {
        visited[i] = true;

        for (int neighbor: adj.get(i)) {
            if (!visited[neighbor])
                dfs(neighbor, adj, visited);
        }

        return true;
    }
}
