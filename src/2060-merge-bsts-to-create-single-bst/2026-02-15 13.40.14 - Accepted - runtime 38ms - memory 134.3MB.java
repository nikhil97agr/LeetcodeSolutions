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
    public TreeNode canMerge(List<TreeNode> trees) {
        Set<Integer> child = new HashSet<>();
        Map<Integer, TreeNode> map = new HashMap<>();
        for(TreeNode node : trees){
            map.put(node.val, node);
            if(node.left!=null){
                child.add(node.left.val);
            }
            if(node.right !=null){
                child.add(node.right.val);
            }
        }
        TreeNode root = null;
        for(int r : map.keySet()){
            if(!child.contains(r)){
                root = map.get(r);
                break;
            }
        }

        if(root == null) return null;
        map.remove(root.val);
        if(!dfs(root, Integer.MIN_VALUE, Integer.MAX_VALUE, map) || !map.isEmpty()) return null;
        return root;
        
        
    }

    private boolean dfs(TreeNode root, int min, int max, Map<Integer, TreeNode > map){
        if(root == null) return true;
        if(root.val <=min || root.val >= max) return false;
        if(root.left != null && map.containsKey(root.left.val)){
            root.left = map.get(root.left.val);
            map.remove(root.left.val);
        }

        if(root.right !=null && map.containsKey(root.right.val)){
            root.right = map.get(root.right.val);
            map.remove(root.right.val);
        }

        return dfs(root.left, min, root.val, map) && dfs(root.right, root.val, max, map);
    }
}