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
    public int widthOfBinaryTree(TreeNode root) {
        Queue<TreeNode> que = new LinkedList<>();
        Map<TreeNode, Integer> map =new HashMap<>();
        int start  = 0;
        int end = 0;
        int curr = 0;
        que.add(root);
        map.put(root, 1);
        
        while(!que.isEmpty()){
            int size = que.size();
            for(int i=0;i<size;i++){
                TreeNode node = que.poll();
                if(i==0) start = map.get(node);
                if(i==size-1) end = map.get(node);
                
                if(node.left!=null){
                    que.add(node.left);
                    map.put(node.left, map.get(node)*2);
                }
                
                if(node.right != null){
                    que.add(node.right);
                    map.put(node.right, map.get(node)*2+1);
                }
            }
            
            curr = Math.max(curr, end-start+1);
        }
        
        return curr;
    }
}