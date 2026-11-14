/**
 * Definition for a rope tree node.
 * class RopeTreeNode {
 *     int len;
 *     String val;
 *     RopeTreeNode left;
 *     RopeTreeNode right;
 *     RopeTreeNode() {}
 *     RopeTreeNode(String val) {
 *         this.len = 0;
 *         this.val = val;
 *     }
 *     RopeTreeNode(int len) {
 *         this.len = len;
 *         this.val = "";
 *     }
 *     RopeTreeNode(int len, RopeTreeNode left, RopeTreeNode right) {
 *         this.len = len;
 *         this.val = "";
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public char getKthCharacter(RopeTreeNode root, int k) {
        String res = dfs(root);

        return res.charAt(k-1);
    }

    private String dfs(RopeTreeNode root){
        if(root ==null) return "";

        if(root.val.isEmpty()){
            return dfs(root.left) + dfs(root.right);
        }

        return root.val;
    }
}