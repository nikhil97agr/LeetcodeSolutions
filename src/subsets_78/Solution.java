package subsets_78;

import java.util.*;
import java.util.stream.*;
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        solve(new ArrayList<>(), nums, nums.length, result, 0);
        return result;
    }

    private void solve(List<Integer> list, int nums[], int n, List<List<Integer>> result, int i){
        if(i==n){
            result.add(list.stream().collect(Collectors.toList()));
            return;
        }

        list.add(nums[i]);
        solve(list, nums, n, result, i+1);
        list.remove(list.size()-1);
        solve(list, nums, n, result, i+1);
    }
}