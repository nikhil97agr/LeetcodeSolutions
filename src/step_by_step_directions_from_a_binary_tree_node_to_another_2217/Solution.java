package step_by_step_directions_from_a_binary_tree_node_to_another_2217;

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

    public String getDirections(TreeNode root, int startValue, int destValue) {
        StringBuilder leftPath = new StringBuilder();
        StringBuilder rightPath = new StringBuilder();
         getPath(root, startValue, leftPath);
         getPath(root, destValue, rightPath);
        StringBuilder result = new StringBuilder();
        int i=0;int j=0;
        while(i<leftPath.length() && j<rightPath.length() && leftPath.charAt(i)==rightPath.charAt(j)){
            i++;
            j++;
        }

        while(i<leftPath.length()){ result.append('U');
        i++;
        }
        while(j<rightPath.length()){
            result.append(rightPath.charAt(j));
            j++;
        }
        return result.toString();

    }

    public boolean getPath(TreeNode root, int val, StringBuilder path){
        if(root==null) return false;
        if(root.val == val) return true;
        
        path.append('L');
        boolean left = getPath(root.left, val, path);
        if(!left) path.deleteCharAt(path.length()-1);
        else return left;

        path.append('R');
        boolean right = getPath(root.right, val, path);
        if(!right) path.deleteCharAt(path.length()-1);
        return right;
    }

    
}