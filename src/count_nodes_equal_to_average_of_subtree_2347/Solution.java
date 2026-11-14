package count_nodes_equal_to_average_of_subtree_2347;

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
    public int averageOfSubtree(TreeNode root) {
            if(root==null) return 0;

            return calculateNodes(root)[0];
    }

    private int[] calculateNodes(TreeNode root){
        if(root==null) return new int[]{0, 0};

        int left[] = calculateNodes(root.left);
        int right[] = calculateNodes(root.right);

        int totalNodes = left[1] + right[1] + 1;
        int sum = root.val;
        int count = left[0] + right[0];
        if(root.left!=null) sum += root.left.val;
        if(root.right!=null) sum += root.right.val;
        
        if(sum/totalNodes == root.val){
            count++;
        }

        root.val = sum;

        return new int[]{count, totalNodes};


    }


}