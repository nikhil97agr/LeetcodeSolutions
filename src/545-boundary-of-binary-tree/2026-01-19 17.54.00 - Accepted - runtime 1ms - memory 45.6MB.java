/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> left = new ArrayList<>();
        List<Integer> leaf = new ArrayList<>();
        List<Integer> right = new ArrayList<>();

        preorder(root, left, leaf, right, 0);

        left.addAll(leaf);
        left.addAll(right);
        return left;
    }

    private boolean isRight(int flag){
        return flag == 2;
    }

    private boolean isLeft(int flag){
        return flag == 1;
    }

    private boolean isLeaf(TreeNode root){
        return root.left == null && root.right == null;
    }

    private boolean isRoot(int flag){
        return flag == 0;
    }

    private int leftFlag(TreeNode root, int flag){
        if(isLeft(flag) || isRoot(flag)) return 1;
        if(isRight(flag) && root.right == null) return 2;
        return 3;
    }

    private int rightFlag(TreeNode root, int flag){
        if(isRoot(flag) || isRight(flag)) return 2;
        if(isLeft(flag) && root.left == null) return 1;
        return 3;
    }
    private void preorder(TreeNode root, List<Integer> left, List<Integer> leaf, List<Integer> right, int flag){
        if(root ==null) return;

        if(isRight(flag)){
            right.add(0, root.val);
        }else if(isLeft(flag) || isRoot(flag)){
            left.add(root.val);
        }else if(isLeaf(root)){
            leaf.add(root.val);
        }

        preorder(root.left, left, leaf, right, leftFlag(root, flag));
        preorder(root.right, left, leaf, right, rightFlag(root, flag));
    }
}