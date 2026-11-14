package maximum_binary_tree_654;

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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return solve(nums, 0, nums.length - 1);
    }

    private TreeNode solve(int nums[], int start, int end){
        if(start > end) return null;

        if(start == end){
            return new TreeNode(nums[start]);
        }

        int ind = -1;
         int max = -1;
         for(int i=start;i<=end;i++){
            if(nums[i] > max){
                max= nums[i];
                ind = i;
            }
         }

         TreeNode node = new TreeNode(max);

         node.left = solve(nums, start, ind - 1);
         node.right = solve(nums, ind+1, end);

         return node;
    }
}