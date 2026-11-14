class Solution {
    public int selfDivisiblePermutationCount(int n) {
        return solve(n, 0,1,  (1<<n)-1);
    }

    private int solve(int n, int state, int ind,  int finalState){
        if(state == finalState){
            return 1;
        }
        int ans = 0;
        for(int i=0;i<n;i++){
            if((state & (1<<i)) ==0 && gcd(i+1, ind)==1){
                ans += solve(n, state | (1<<i), ind + 1, finalState);
            }
        }
        return ans;
    }

    int gcd(int a, int b){
        return a==0 ? b : gcd(b%a, a);
    }
}