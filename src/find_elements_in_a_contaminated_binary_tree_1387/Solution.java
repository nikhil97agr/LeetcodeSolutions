package find_elements_in_a_contaminated_binary_tree_1387;

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
class FindElements {
    Set<Integer> set = new HashSet<>();
    public FindElements(TreeNode root) {
        root.val = 0;
        Queue<TreeNode> que = new LinkedList<>();

        que.offer(root);
        while(!que.isEmpty()){
            root= que.poll();
            set.add(root.val);
            if(root.left!=null){
                root.left.val = root.val*2 + 1;
                que.offer(root.left);
            }
            if(root.right!=null){
                root.right.val = root.val*2+2;
                que.offer(root.right);
            }
        }
    }
    
    public boolean find(int target) {
        return set.contains(target);
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */