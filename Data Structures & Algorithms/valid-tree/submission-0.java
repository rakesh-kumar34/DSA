class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (edges.length + 1 != n) return false;

        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());

        for (int[] edge: edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        Queue<Integer> q = new ArrayDeque<>();
        boolean[] visited = new boolean[n];
        q.offer(0);
        visited[0] = true;

        while (!q.isEmpty()) {
            int curr = q.poll();
            for (int neighbor: adj.get(curr)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    q.offer(neighbor);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (visited[i] == false) return false;
        }
        
        return true;
    }
}
