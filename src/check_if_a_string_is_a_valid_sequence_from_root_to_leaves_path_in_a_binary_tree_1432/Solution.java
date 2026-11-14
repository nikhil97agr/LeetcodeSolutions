package check_if_a_string_is_a_valid_sequence_from_root_to_leaves_path_in_a_binary_tree_1432;

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
    public boolean isValidSequence(TreeNode root, int[] arr) {
        return solve(root, arr, 0, arr.length);
    }

    private boolean solve(TreeNode root, int arr[], int i, int n){
        if(i==n) return root == null;
        if(root==null) return false;
        if(root.val != arr[i]) return false;

        if(root.left == null && root.right == null){
            if(i==n-1) return true;
            return false;
        }
        boolean ans = false;
        if(root.left !=null){
            ans= ans || solve(root.left, arr, i+1, n);
        }

        if(root.right !=null){
            ans = ans || solve(root.right, arr, i+1, n);
        }

        return ans;
    }
}