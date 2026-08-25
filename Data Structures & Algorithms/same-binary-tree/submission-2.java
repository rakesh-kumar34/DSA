/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {        
        Queue<List<TreeNode>> queue = new ArrayDeque<>();
        queue.offer(Arrays.asList(p, q));

        while (!queue.isEmpty()) {
            List<TreeNode> nodes = queue.poll();
            TreeNode pc = nodes.get(0);
            TreeNode qc = nodes.get(1);

            if (pc == null && qc == null) continue;
            if (pc == null || qc == null) return false;
            if (pc.val != qc.val) return false;

            queue.offer(Arrays.asList(pc.left, qc.left));
            queue.offer(Arrays.asList(pc.right, qc.right));
        }
        return true;
    }
}
