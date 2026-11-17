package binary_search_tree_iterator_ii_1729;

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
class BSTIterator {
    Stack<Integer> next = new Stack<>();
    Stack<Integer> prev= new Stack<>();
    public BSTIterator(TreeNode root) {
        inorder(root);
    }

    private void inorder(TreeNode root){
        if(root ==null) return;
        inorder(root.right);
        next.push(root.val);
        inorder(root.left);
    }
    
    public boolean hasNext() {
        return next.size() > 0;
    }
    
    public int next() {
        prev.push(next.peek());
        return next.pop();
    }
    
    public boolean hasPrev() {
        return prev.size() > 1;
    }
    
    public int prev() {
        next.push(prev.pop());

        return prev.peek();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * boolean param_1 = obj.hasNext();
 * int param_2 = obj.next();
 * boolean param_3 = obj.hasPrev();
 * int param_4 = obj.prev();
 */