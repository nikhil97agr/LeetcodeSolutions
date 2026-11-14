package closest_leaf_in_a_binary_tree_743;

import java.util.*;
// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
class Solution {
    public int findClosestLeaf(TreeNode root, int k) {
        // Map child -> parent
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        TreeNode start = buildParent(root, null, k, parent);

        Queue<TreeNode> q = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();

        q.offer(start);
        visited.add(start);

        while (!q.isEmpty()) {
            TreeNode node = q.poll();

            // leaf found
            if (node.left == null && node.right == null) {
                return node.val;
            }

            if (node.left != null && visited.add(node.left)) {
                q.offer(node.left);
            }
            if (node.right != null && visited.add(node.right)) {
                q.offer(node.right);
            }
            if (parent.get(node) != null && visited.add(parent.get(node))) {
                q.offer(parent.get(node));
            }
        }
        return -1;
    }

    private TreeNode buildParent(
            TreeNode node,
            TreeNode par,
            int k,
            Map<TreeNode, TreeNode> parent
    ) {
        if (node == null) return null;

        parent.put(node, par);

        if (node.val == k) return node;

        TreeNode left = buildParent(node.left, node, k, parent);
        if (left != null) return left;

        return buildParent(node.right, node, k, parent);
    }
}
