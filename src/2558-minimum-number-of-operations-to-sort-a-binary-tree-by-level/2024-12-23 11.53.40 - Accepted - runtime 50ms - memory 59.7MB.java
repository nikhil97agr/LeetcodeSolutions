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
    public int minimumOperations(TreeNode root) {
        int ans = 0;
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);


        while(!que.isEmpty()){
            int size = que.size();
            int arr[] = new int[size];
            int ind = 0;
            while(size-- > 0){
                TreeNode node = que.poll();
                arr[ind++] = node.val;

                if(node.left != null) que.offer(node.left);
                if(node.right != null) que.offer(node.right);
            }
            ans += getCnt(arr);
        }
        return ans;
    }

    private int getCnt(int arr[]){
        Map<Integer, Integer> map =new HashMap<>();

        int sort[] = arr.clone();
        Arrays.sort(sort);
        int n = arr.length;

        for(int i=0;i<n;i++){
            map.put(arr[i], i);
        }

        int cnt = 0;
        for(int i=0;i<n;i++){
            if(arr[i] != sort[i]){
                cnt++;
                int ind = map.get(sort[i]);
                map.put(arr[i], ind);
                arr[ind] = arr[i];
            }
        }
        return cnt;
    }
}