package binary_tree_cameras_1008;

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
    enum Camera { NOT_COVERED, COVERED, CAMERA_PLACED }
    public int minCameraCover(TreeNode root) {
        int ans[] = new int[]{0};

        Camera camera = solve(root, ans);

        return camera.equals(Camera.NOT_COVERED) ? ans[0]+1 : ans[0];
    }

    public Camera solve(TreeNode root, int ans[]){
        if(root==null) return Camera.COVERED;

        Camera left = solve(root.left, ans);
        Camera right = solve(root.right, ans);

        if(left.equals(Camera.NOT_COVERED) || right.equals(Camera.NOT_COVERED)){
            ans[0]++;
            return Camera.CAMERA_PLACED;
        }

        if(left.equals(Camera.CAMERA_PLACED) || right.equals(Camera.CAMERA_PLACED)) return Camera.COVERED;

        return Camera.NOT_COVERED;
    }
}