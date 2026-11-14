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
    public int amountOfTime(TreeNode root, int start) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        System.out.println(root.val);
        if(root==null || (root.left == null && root.right==null)) return 0;
        traverse(root, map);
        Queue<Integer> que = new LinkedList<>();
        que.offer(start);
        int ans = 0;
        Set<Integer> vis = new HashSet<>();
        System.out.println(map);
        while(!que.isEmpty()){
            ans++;
            int size = que.size();
            for(int i=0;i<size;i++){
                int x = que.poll();
                vis.add(x);
                for(int y : map.get(x)){
                    if(!vis.contains(y)){
                        que.offer(y);
                    }
                }
            }
        }

        return ans-1;
    }

    private void traverse(TreeNode root, Map<Integer, List<Integer>> map){
        if(root==null) return ;

        if(root.left!=null){
            map.computeIfAbsent(root.left.val, val-> new ArrayList<>()).add(root.val);
            map.computeIfAbsent(root.val , val -> new ArrayList<>()).add(root.left.val);
        }

        if(root.right!=null){
            map.computeIfAbsent(root.right.val, val-> new ArrayList<>()).add(root.val);
            map.computeIfAbsent(root.val , val -> new ArrayList<>()).add(root.right.val);
        }

        traverse(root.left, map);
        traverse(root.right, map);
    }



}