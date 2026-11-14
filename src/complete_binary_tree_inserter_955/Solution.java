package complete_binary_tree_inserter_955;

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
class CBTInserter {
    TreeNode root;
    Deque<TreeNode> que;

    public CBTInserter(TreeNode root) {
        que = new ArrayDeque<>();
        this.root = root;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int size = q.size();

            while(size-->0){
                TreeNode node = q.poll();

                que.offerLast(node);
                if(node.left!=null){
                    q.offer(node.left);
                }

                if(node.right!=null){
                    q.offer(node.right);
                }
            }
        }
        while(!que.isEmpty()){
            if(que.peekFirst().left!=null && que.peekFirst().right!=null){
                que.pollFirst();
            }else{
                break;
            }
        }
    }
    
    public int insert(int val) {
        TreeNode node = new TreeNode(val);
        if(que.peekFirst().left == null){
            que.peekFirst().left = node;
            que.offerLast(node);

            return que.peekFirst().val;
        }else{
            que.peekFirst().right = node;
            que.offerLast(node);
            return que.pollFirst().val;
        }
    }
    
    public TreeNode get_root() {
        return root;
    }
}

/**
 * Your CBTInserter object will be instantiated and called as such:
 * CBTInserter obj = new CBTInserter(root);
 * int param_1 = obj.insert(val);
 * TreeNode param_2 = obj.get_root();
 */