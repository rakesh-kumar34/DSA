class Solution {

    private static final int UNVISITED = 0;
    private static final int IN_RECURSION_STACK = 1;
    private static final int VISITED = 2;

    private int[] result;
    private int idx;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (numCourses == 0) return new int[]{};

        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] p: prerequisites) {
            adj.get(p[1]).add(p[0]);
        }

        int[] states = new int[numCourses];
        this.idx = numCourses - 1;
        this.result = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            if (states[i] == UNVISITED && hasCycle(i, states, adj)) return new int[]{};
        }

        return this.result;
    }

    private boolean hasCycle(int c, int[] states, List<List<Integer>> adj) {
        states[c] = IN_RECURSION_STACK;

        for (int neighbor: adj.get(c)) {
            if (states[neighbor] == IN_RECURSION_STACK) return true; //back edge

            if (states[neighbor] == UNVISITED && hasCycle(neighbor, states, adj)) return true;
        }

        states[c] = VISITED;
        this.result[idx--] = c;
        return false;
    }
}
