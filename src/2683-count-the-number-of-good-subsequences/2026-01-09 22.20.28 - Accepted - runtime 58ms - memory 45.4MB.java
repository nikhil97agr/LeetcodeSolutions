class Solution {
    int mod = (int)1e9 + 7;
    public int countGoodSubsequences(String s) {
        int n = s.length();
        int fact[] = new int[n+1];
        fact[0] = fact[1] = 1;
        for(int i=2;i<=n;i++){
            fact[i] = prod(i, fact[i-1]);
        }

        int inv[] = new int[n+1];
        for(int i=0;i<=n;i++){
            inv[i] = pow(fact[i], mod - 2);
        }
        int ans = 0;
        int cnt[] = new int[26];
        for(char c : s.toCharArray()){
            cnt[c-'a']++;
        }

        for(int i=1;i<=n;i++){
            int prod = 1;

            for(int c : cnt){
                if( c >= i){
                    prod = prod(add(comb(c, i, fact, inv), 1), prod);
                }
            }
            ans = add(ans, add(prod, -1));
        }
        return ans;
    }
    
    private int comb(int n, int r, int fact[], int inv[]){
        return prod(fact[n], prod(inv[r], inv[n-r]));
    }

    private int pow(int a, int b){
        if(a <=1) return a;
        if(b==0) return 1;

        int p = pow(a, b/2);
        p = prod(p,p);
        if(b%2==1){
            p = prod(p, a);
        }

        return p;
    }

    private int prod(int a, int b){
        long p =1l*a*b;

        return (int)(p%mod);
    }

    private int add(int a, int b){
        long sum = 1l*mod + a + b;
        return (int)(sum%mod);
    }
}