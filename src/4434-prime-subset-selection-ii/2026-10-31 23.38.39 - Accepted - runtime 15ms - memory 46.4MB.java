class Solution {
    public List<Integer> maxPrimeSubset(int n, int s) {
        boolean primes[] = new boolean[n + 1];
        Arrays.fill(primes, true);
        primes[0] = primes[1] =false;
        List<Integer> list = new ArrayList<>();
        for(int i=2;i<=n;i++){
            if(primes[i]){
                list.add(i);
                int j = i + i ;
                while( j <= n){
                    primes[j] = false;
                    j += i;
                }
            }
        }

        if(s < 2){
            return Collections.emptyList();
        }
        
        int dp[] = new int[s + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        boolean flag[][] = new boolean[list.size()][s + 1];
        dp[0] = 0;
        for(int i=list.size() - 1;i>=0;i--){
            int v = list.get(i);
            for(int sum =s;sum >= v;sum--){
                if(dp[sum - v]!= Integer.MAX_VALUE){
                    int cnt = dp[sum -v] + 1;
                    if(cnt <= dp[sum]){
                        dp[sum] = cnt;
                        flag[i][sum] = true;
                    }
                }
            }
        }
        int bestSum =0;
        for(int i= s;i>=1;i--){
            if(dp[i] != Integer.MAX_VALUE){
                bestSum = i;
                break;
            }
        }
        List<Integer> res = new ArrayList<>();
        for(int i=0;bestSum > 0 && i < list.size();i++){
            if(flag[i][bestSum]){
                res.add(list.get(i));
                bestSum -= list.get(i);
            }
        }

        return res;

    }
}