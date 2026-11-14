package cousins_in_binary_tree_1035;

import java.util.*;
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
    public boolean isCousins(TreeNode root, int x, int y) {
      Queue<TreeNode> q = new LinkedList<TreeNode>();
        boolean xFound = false;
        boolean yFound = false;
        int xDepth = -1;
        int yDepth = -1;
        int depth = 0;
        TreeNode xParent = null;
        TreeNode yParent = null;
        q.add(root);
        while(!q.isEmpty())
        {
            int size = q.size();
            TreeNode temp = null;
            while(size-->0)
            {
                temp = q.poll();
                if(temp.left!=null)
                {
                    q.add(temp.left);
                    if(temp.left.val==x)
                    {
                        xFound = true;
                        xDepth = depth;
                        xParent = temp;
                    }
                    
                    if(temp.left.val == y)
                    {
                        yFound = true;
                        yDepth = depth;
                        yParent = temp;
                    }
                }
                if(temp.right!=null)
                {
                    q.add(temp.right);
                    if(temp.right.val==x)
                    {
                        xFound = true;
                        xDepth = depth;
                        xParent = temp;
                    }
                    if(temp.right.val==y)
                    {
                        yFound = true;
                        yDepth = depth;
                        yParent = temp;
                    }
                }
                
                if(xFound&&yFound)
                {
                    if(xDepth==yDepth&&xParent!=yParent)
                        return true;
                    else
                    {
                        return false;
                    }
                }
            }
            depth++;
        }
        return false;
    }
}