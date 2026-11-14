class Solution {
    public int minNumberOfSemesters(int n, int[][] relations, int k) {
        int preq[] = new int[n];
        for(int r[] : relations){
            int u = r[0] - 1;
            int v = r[1] - 1;

            preq[v] |= (1<<u);
        }
        Integer dp[] = new Integer[1<<n];
        return solve(preq, (1<<n)-1, n, k, dp);
        
    }

    private int solve(int preq[], int currMask,int n, int k, Integer dp[]){
        if(currMask ==0){
            return 0;
        }
        if(dp[currMask]!=null) return dp[currMask];
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<n;i++){
            if((currMask & (1<<i)) ==0) continue;

            if((preq[i] & currMask) ==0) list.add(i);
        }


        if(list.size() > k){
            List<Integer> masks = new ArrayList<>();
             generate(list, masks, currMask, k, 0);
            int ans = Integer.MAX_VALUE;
             for(int mask : masks){
                ans = Math.min(ans, 1 + solve(preq, mask, n, k, dp));
             }

             return dp[currMask] = ans;

        }else{
            int temp = currMask;
            for(int x : list){
                temp = (temp ^ (1<<x));
            }

            return dp[currMask] =  1 + solve(preq, temp, n, k, dp);
        }

        
    }

    private void generate(List<Integer> list, List<Integer> masks, int curr, int k, int ind){
        if(k==0){
            masks.add(curr);
            return ;
        }

        for(int i = ind;i<list.size();i++){
            int newMask = (curr ^ (1<<list.get(i)));
            generate(list, masks, newMask, k-1, i+1);
        }
    }
}