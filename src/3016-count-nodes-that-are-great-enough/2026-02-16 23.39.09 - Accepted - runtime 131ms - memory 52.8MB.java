import java.util.Collections;
import java.util.PriorityQueue;

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
    int ans = 0;
    public int countGreatEnoughNodes(TreeNode root, int k) {
        dfs(root, k);
        return ans;
    }

    private PriorityQueue<Integer> dfs(TreeNode root, int k){
        if(root == null){
            return new PriorityQueue<>(Collections.reverseOrder());
        }
        PriorityQueue<Integer> res = new PriorityQueue<>(Collections.reverseOrder());
        if(root.left !=null){
            PriorityQueue<Integer>left = dfs(root.left, k);
            while(!left.isEmpty()){
                res.offer(left.poll());
                if(res.size() > k) res.poll();
            }
        }

        if(root.right !=null){
            if(res.size() > k) res.poll();
            PriorityQueue<Integer> right =dfs(root.right, k);
            while(!right.isEmpty()){
                res.offer(right.poll());
                if(res.size() > k) res.poll();
            }
        }

        if(res.size() == k && root.val > res.peek()){
            ans++;

        }
        res.offer(root.val);
        if(res.size() > k) res.poll();
        return res;
    }
}