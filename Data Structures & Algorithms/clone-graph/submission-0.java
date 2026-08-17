/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) return null;

        Queue<Node> q = new ArrayDeque<>();
        q.offer(node);

        Map<Node, Node> clones = new HashMap<>();
        Node copy = new Node(node.val);
        clones.put(node, copy);

        while (!q.isEmpty()) {
            Node curr = q.poll();
            Node currClone = clones.get(curr);

            for (Node neighbor: curr.neighbors) {
                if (!clones.containsKey(neighbor)) {
                    clones.put(neighbor, new Node(neighbor.val));
                    q.add(neighbor);
                }
                currClone.neighbors.add(clones.get(neighbor));
            }
        }

        return clones.get(node);
    }
}