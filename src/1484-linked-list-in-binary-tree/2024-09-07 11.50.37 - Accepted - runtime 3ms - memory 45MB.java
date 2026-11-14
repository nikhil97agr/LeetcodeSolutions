/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
    public boolean isSubPath(ListNode head, TreeNode root) {
        Queue<TreeNode> que = new LinkedList<>();

        que.offer(root);
        while(!que.isEmpty()){
            root = que.poll();

            if(check(root, head)) return true;

            if(root.left!=null) que.offer(root.left);
            if(root.right!=null) que.offer(root.right);
        }
        return false;
    }

    private boolean check(TreeNode root, ListNode head){
        if(head == null) return true;

        if(root == null ) return false;

        if(root.val == head.val) return check(root.left, head.next) || check(root.right, head.next);
        return false;
    }

   
}