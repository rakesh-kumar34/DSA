class Solution {

    private static final int UNVISITED = 0;
    private static final int IN_RECURSION_STACK = 1;
    private static final int VISITED = 2;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses == 0) return false;
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] pre: prerequisites) {
            int course = pre[0];
            int prereq = pre[1];
            adj.get(prereq).add(course);
        }
        int[] states = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            if (states[i] == UNVISITED && hasCycle(adj, states, i)) return false;
        }
        return true;
    }

    private boolean hasCycle(List<List<Integer>> adj, int[] states, int c) {
        states[c] = IN_RECURSION_STACK;

        for (int neighbor: adj.get(c)) {
            if (states[neighbor] == IN_RECURSION_STACK) return true; //back edge

            if (states[neighbor] == UNVISITED && hasCycle(adj, states, neighbor)) return true;
        }

        states[c] = VISITED;
        return false;
    } 
}
