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
    public TreeNode replaceValueInTree(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();
        Queue<TreeNode> que= new LinkedList<>();
        int dep = 0;
        que.offer(root);
        while(!que.isEmpty()){
            int size = que.size();
            int sum = 0;
            while(size-->0){
                TreeNode node = que.poll();
                sum += node.val;
                if(node.right != null){
                    que.offer(node.right);
                }
                if(node.left != null){
                    que.offer(node.left);
                }
            }
            map.put(dep, sum);
            dep++;
        }
        return dfs(root, null, 0, map);

    }

    private TreeNode dfs(TreeNode root, TreeNode par, int dep, Map<Integer, Integer> map){
        if(root == null) return null;

        TreeNode node= new TreeNode(map.get(dep));
        if(par == null){
            node.val -= root.val;
        }else{
            if(par.left!=null) node.val -= par.left.val;
            if(par.right!=null) node.val -= par.right.val;

        }
        node.left = dfs(root.left, root, dep+1, map);
        node.right = dfs(root.right, root, dep+1, map);

        return node;
    }
}