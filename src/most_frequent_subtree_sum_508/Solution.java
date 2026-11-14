package most_frequent_subtree_sum_508;

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
    public int[] findFrequentTreeSum(TreeNode root) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        calcSum(root, map);
        int count = 0;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            count = Math.max(count, entry.getValue());
        }
        List<Integer> result = new ArrayList();
        int i=0;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            if(entry.getValue()==count){
                result.add(entry.getKey());
            }
        }
        int ans[]= new int[result.size()];
        for(int x : result){
            ans[i++] = x;
        }
        return ans;
    }

    public int calcSum(TreeNode root, HashMap<Integer, Integer> map){
        if(root==null){
            return 0;
        }
        int left =calcSum(root.left, map);
        int right = calcSum(root.right, map);
        int sum = root.val + left + right;
        map.put(sum , map.getOrDefault(sum, 0)+1);
        return sum;
    }
}