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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null || subRoot == null) return false;
        StringBuilder a = new StringBuilder();
        StringBuilder b = new StringBuilder();
        serialize(root, a);
        serialize(subRoot, b);
        if (a.toString().contains(b.toString())) return true;
        return false;
    }

    private void serialize(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append(",null");
            return;
        }
        sb.append(",").append(root.val);
        serialize(root.left, sb);
        serialize(root.right, sb);
    }
}
