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
    TreeNode prev = null;

    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;

        // Left subtree
        if (!isValidBST(root.left)) return false;

        // Current node
        if (prev != null && root.val <= prev.val) {
            return false;
        }
        prev = root;

        // Right subtree
        return isValidBST(root.right);
    }
}