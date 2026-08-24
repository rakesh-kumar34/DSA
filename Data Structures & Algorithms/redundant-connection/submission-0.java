class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int nodes = edges.length;
        DisjointSet dsu = new DisjointSet(nodes + 1);
        for (int[] edge: edges) {
            if (!dsu.unionBySize(edge[0], edge[1])) return new int[]{edge[0], edge[1]};
        }
        return new int[]{};
    }

    class DisjointSet {
        private int[] parent;
        private int[] size;
        private int components;

        public DisjointSet(int nodes) {
            this.parent = new int[nodes];
            this.size = new int[nodes];
            this.components = nodes;

            for (int i = 0; i < nodes; i++) {
                size[i] = 1;
                parent[i] = i;
            }
        }

        public int findRootParent(int n) {
            while (parent[n] != n) {
                parent[n] = parent[parent[n]];
                n = parent[n];
            }
            return n;
        }

        public boolean unionBySize(int n1, int n2) {
            int p1 = findRootParent(n1);
            int p2 = findRootParent(n2);

            // nodes in same component
            if (p1 == p2) return false;

            int s1 = size[p1];
            int s2 = size[p2];

            if (s1 > s2) {
                parent[p2] = p1;
                size[p1] += size[p2];
            }
            else {
                parent[p1] = p2;
                size[p2] += size[p1];
            }
            components--;
            return true;
        }

        public int getComponents() {
            return this.components;
        }
    }
}

