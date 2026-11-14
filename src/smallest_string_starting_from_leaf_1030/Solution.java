package smallest_string_starting_from_leaf_1030;

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
    String ans= null;
    public String smallestFromLeaf(TreeNode root) {
        solve(root, new StringBuilder());
        return ans;
    }

    private void solve(TreeNode root, StringBuilder sb){
        if(root == null) return;
        sb.append((char)(root.val + 'a'));
        if(root.left == null && root.right == null){
            String s = sb.reverse().toString();
            sb.reverse();
            if(ans == null || ans.compareTo(s) > 0){
                ans = s;
            }
        }

        solve(root.left, sb);
        solve(root.right, sb);
        sb.deleteCharAt(sb.length() -1 );
    }
}