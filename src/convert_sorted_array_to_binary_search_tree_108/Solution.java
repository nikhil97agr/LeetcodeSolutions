package convert_sorted_array_to_binary_search_tree_108;

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
    public TreeNode sortedArrayToBST(int[] nums) {
        int start = 0;
        int end = nums.length-1;

        return solve(nums, start, end);
    }

    private TreeNode solve(int nums[], int start, int end){
        if(start > end) return null;
        if(start == end) return new TreeNode(nums[start]);

        int mid = (start + end)/2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = solve(nums, start, mid-1);
        node.right = solve(nums, mid+1, end);
        return node;
    }
}