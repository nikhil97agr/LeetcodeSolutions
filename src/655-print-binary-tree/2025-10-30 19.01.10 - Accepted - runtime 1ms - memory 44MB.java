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
    public List<List<String>> printTree(TreeNode root) {
        int height = height(root);
        int size = (1<<height) - 1;
        List<List<String>> result = new ArrayList<>();
        for(int i=0;i<height;i++){
            List<String> list = new ArrayList<>();
            for(int j=0;j<size;j++){
                list.add("");
            }
            result.add(list);
        }
        generate(root, height, 0, 0, size - 1, result);
        return result;
    }

    private void generate(TreeNode root, int height, int level, int start, int end, List<List<String>> result){
        if(root ==null || level == height || start > end) return;

        int mid = (start + end)/2;

        result.get(level).set(mid, String.valueOf(root.val));

        generate(root.left, height, level + 1, start, mid - 1, result);
        generate(root.right, height, level + 1, mid + 1, end, result);
    }

    private int height(TreeNode root){
        if(root ==null) return 0;

        return Math.max(height(root.left), height(root.right)) + 1;
    }
}