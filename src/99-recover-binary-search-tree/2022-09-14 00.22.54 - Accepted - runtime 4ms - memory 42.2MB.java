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
    public void recoverTree(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        inorder(root, list);
        if(list.size()==2){
            TreeNode node = find(root, list.get(0));
            TreeNode node2 = find(root, list.get(1));
            int temp = node.val;
            node.val = node2.val;
            node2.val = temp;
            return;
        }
        ArrayList<Integer> temp =(ArrayList<Integer>) list.clone();
        Collections.sort(temp);
         int first = -1;
        int second = -1;
        for(int i=0;i<temp.size();i++){
            if(temp.get(i)!=list.get(i)){
                if(first ==-1){
                    first = list.get(i);
                }
                else{
                    second = list.get(i);
                }
            }
        }
       
        TreeNode node1 = find(root, first);
        TreeNode node2 = find(root,second);
        

        node1.val = node2.val + node1.val - (node2.val=node1.val);

        
    }
    
    public TreeNode find(TreeNode root, int val){
        if(root==null){
            return null;
        }
        
        if(root.val == val){
            return root;
        }
        TreeNode left = find(root.left, val);
        if(left != null){
            return left;
        }
        TreeNode right = find(root.right, val);
        return right;
    }
    
    public void inorder(TreeNode root, ArrayList<Integer> list){
        if(root==null){
            return;
        }
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }
}