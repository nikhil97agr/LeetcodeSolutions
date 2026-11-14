import java.util.*;

class Solution {
    public int maxScore(List<List<Integer>> grid) {
        int n = grid.size();
        Map<Integer, List<Integer>> map = new HashMap<>();

        for(int i=0;i<n;i++){
            for(int x : grid.get(i)){
                map.computeIfAbsent(x, y-> new ArrayList<>()).add(i);
            }
        }
        List<Map.Entry<Integer, List<Integer>>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, (a,b)-> b.getKey() - a.getKey());
        Integer dp[][] = new Integer[list.size()][1<<n];

        return solve(list, dp, 0, 0, list.size(), (1<<n)-1);
    }

    private int solve(List<Map.Entry<Integer, List<Integer>>> list, Integer dp[][], int i, int mask, int n, int maxMask){
        
        if(mask == maxMask || i >= n) return 0;
        if(dp[i][mask]!=null) return dp[i][mask];
        int ans = 0;
        Map.Entry<Integer, List<Integer>> entry = list.get(i);
        
        for(int x : entry.getValue()){
            if((mask & (1<<x)) == 0){
                   ans = Math.max(ans, entry.getKey() + solve(list, dp, i+1, mask | (1<<x), n, maxMask));
            }
        }

        ans = Math.max(ans, solve(list, dp, i+1, mask, n, maxMask));
        
        
        return dp[i][mask] = ans;
        
    }
}