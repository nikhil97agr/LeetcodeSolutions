package subsets_ii_90;

import java.util.*;
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Set<List<Integer>> res = new HashSet<>();
        Arrays.sort(nums);
        int n = nums.length;
        solve(new ArrayList<>(), 0, n, nums, res);
        return new ArrayList<>(res);
    }

    private void solve(List<Integer> list , int i, int n, int nums[], Set<List<Integer>> res){
        if(i==n){
            res.add(new ArrayList<>(list));
            return;
        }

        list.add(nums[i]);
        solve(list, i+1, n, nums, res);
        list.remove(list.size()-1);
        solve(list, i+1, n, nums, res);
        
    }
}