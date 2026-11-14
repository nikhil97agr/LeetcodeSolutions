class Solution {
    
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList();
        ArrayList<Integer> temp = new ArrayList<Integer>();
        solve(candidates, candidates.length, target, temp);
        return result;
    }
    
    public void solve(int[] candidates, int n, int target, ArrayList<Integer> temp)
    {
        if(target==0)
        {
            Collections.sort(temp);
            result.add((List)temp.clone());
            return;
        }
        
        if(target<0)
        {
            return;
        }
        if(n<=0 && target>0)
        {
            return ;
        }
        
        solve(candidates, n-1, target, (ArrayList)temp.clone());
        temp.add(candidates[n-1]);
        solve(candidates, n, target - candidates[n-1], (ArrayList)temp.clone());
    }
}