package binary_tree_longest_consecutive_sequence_ii_549;

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
    public int longestConsecutive(TreeNode root) {
        int ans[] = new int[]{0};
        longPath(root, ans);

        return ans[0];
    }

    private int[] longPath(TreeNode root, int ans[]){
        if(root==null) return new int[]{0,0};

        int incr = 1;
        int dcr = 1;

        if(root.left!=null){
            int left[] = longPath(root.left, ans);

            if(root.val == root.left.val+1){
                dcr = Math.max(dcr, left[1]+1);
            }else if(root.val == root.left.val-1){
                incr = Math.max(incr, left[0]+1);
            }
        }

        if(root.right!=null){
            int right[] = longPath(root.right, ans);

            if(root.val == root.right.val+1){
                dcr = Math.max(dcr, right[1]+1);
            }

            else if(root.val == root.right.val-1){
                incr = Math.max(incr, right[0]+1);
            }
        }

        ans[0] = Math.max(ans[0], incr + dcr -1);

        return new int[]{incr, dcr};
    }
}