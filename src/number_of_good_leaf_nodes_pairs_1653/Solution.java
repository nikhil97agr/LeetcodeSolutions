package number_of_good_leaf_nodes_pairs_1653;

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
    public int countPairs(TreeNode root, int distance) {
        return solve(root, distance)[distance + 1];
    }

    private int[] solve(TreeNode root, int maxDist) {
        if (root == null) {
            int temp[] = new int[maxDist + 2];

            return temp;
        }

        if (root.left == null && root.right == null) {
            int temp[] = new int[maxDist + 2];
            temp[0] = 1;
            return temp;
        }

        int left[] = solve(root.left, maxDist);
        int right[] = solve(root.right, maxDist);

        int merge[] = new int[maxDist + 2];

        for (int i = 1; i <= maxDist; i++) {
            merge[i] = left[i - 1] + right[i - 1];
        }
        merge[maxDist+1] = left[maxDist+1] + right[maxDist+1];

        for (int i = 0; i <= maxDist; i++) {
            for (int j = 0; j <= maxDist; j++) {
                if (i + j + 2 <= maxDist)
                    merge[maxDist + 1] += left[i] * right[j];
            }
        }

        return merge;
    }
}