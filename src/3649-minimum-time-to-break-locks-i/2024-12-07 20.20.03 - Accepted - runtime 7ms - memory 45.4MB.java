class Solution {
    public int findMinimumTime(List<Integer> list, int k) {
        int n = list.size();
        int last = (1<<n) -1;
        Integer dp[][] = new Integer[last][201];
        return solve(list, list.size(), k, 1, 0, last, dp);
    }
    
    private int solve(List<Integer> list,  int n, int k, int x, int state, int finalState, Integer dp[][]){
        
        if(state == finalState) return 0;
        
        if(dp[state][x]!=null) return dp[state][x];
        int ans = Integer.MAX_VALUE;
        
        for(int i=0;i<n;i++){
            if((state&(1<<i)) ==0 ){
                ans = Math.min((list.get(i)+x-1)/x + solve(list, n, k, x+k, state|(1<<i), finalState, dp), ans);
            }
        }
        
        return dp[state][x] = ans;
        
    }
}