package combination_sum_ii_40;

import java.util.*;
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
     Arrays.sort(candidates);
    List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> temp = new ArrayList();
        solve(result, temp, candidates, target, 0);
        return result;
    }
    
    public void solve(List<List<Integer>> result, List<Integer> temp, int[] candidates, int target, int index)
    {
        if(target==0)
        {
            result.add(List.copyOf(temp));
            return;
        }
        if(target<0)
        {
            return;
        }
        if(candidates.length==index)
            return;
        temp.add(candidates[index]);
        solve(result, temp, candidates, target-candidates[index], index+1);
        temp.remove(temp.size()-1);
        while(index+1<candidates.length&&candidates[index]==candidates[index+1])
            index+=1;
        solve(result, temp, candidates, target, index+1);
    }
}