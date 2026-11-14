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
    int count = 0;
    public int pseudoPalindromicPaths (TreeNode root) {
        HashMap<Integer, Integer> map = new HashMap();
        solve(root, map);
        return count;
    }
    
    public void solve(TreeNode root, HashMap<Integer, Integer> map){
        if(root==null){
            int oddCount = 0;
            for(Map.Entry<Integer, Integer> entry : map.entrySet()){
                if(entry.getValue()%2==1){
                    oddCount++;
                }
            }
            if(oddCount<2){
                count++;
            }
            return;
        }
        if(map.containsKey(root.val)){
            map.put(root.val, map.get(root.val)+1);
        }
        else{
            map.put(root.val, 1);
        }
        if(root.left==null && root.right==null){
                    solve(root.left, map);
        }
        else{
            if(root.left!=null){
                solve(root.left, map);
            }
            if(root.right!=null){
                solve(root.right, map);
            }
        }
        if(map.get(root.val)>1){
            map.put(root.val, map.get(root.val)-1);
        }
        else{
            map.remove(root.val);
        }
    }
}