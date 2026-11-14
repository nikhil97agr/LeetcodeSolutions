package closest_binary_search_tree_value_270;

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
    
    public int closestValue(TreeNode root, double target) {
        
        int currVal = root.val;
        double currDist = Math.abs(target - 1d*currVal);

        if(root.left != null){
            int left = closestValue(root.left, target);

            double dist = Math.abs(target - 1d*left);
            if(dist < currDist){
                currVal = left;
                currDist = dist;
            }else if(currDist == dist && left < currVal){
                currVal = left;
            }
        }

        if(root.right != null){
            int right = closestValue(root.right, target);

            double dist = Math.abs(target - 1d*right);
            if(dist < currDist){
                currVal = right;
                currDist = dist;
            }else if(currDist == dist && right < currVal){
                currVal = right;
            }
        }

        return currVal;


    }
}