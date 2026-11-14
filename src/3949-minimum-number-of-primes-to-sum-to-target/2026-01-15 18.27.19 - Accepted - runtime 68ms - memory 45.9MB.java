class Solution {
    public int minNumberOfPrimes(int n, int m) {
        List<Integer> list = new ArrayList<>();
        for(int i=2;list.size() < m;i++){
            if(prime(i)) list.add(i);
        }
        if(n==1){
            return -1;

        }

        if(n==2) return 1;
        if(n==3){
            if(m == 1) return -1;
            return 1;
        }

        if(list.contains(n)) return 1;
        int dp[] = new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        if(!list.isEmpty()){
            dp[2] = 1;
        }
        if(list.size() > 1){
            dp[3] = 1;
        }
 
        for(int i=4;i<=n;i++){
            for(int x : list){
                if(x > i) break;

                int req = i - x;
                if(dp[req] < dp[i]){
                    dp[i] = dp[req] + 1;
                }
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[n] == Integer.MAX_VALUE ? -1 : dp[n];
    }
    private boolean prime(int x){
        if(x <=3) return true;
        if(x %2==0) return false;

        for(int i=3;i<=Math.sqrt(x);i++){
            if(x%i==0) return false;
        }

        return true;
    }
}