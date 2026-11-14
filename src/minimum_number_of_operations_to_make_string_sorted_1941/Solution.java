package minimum_number_of_operations_to_make_string_sorted_1941;

class Solution {
    int mod = 1_000_000_007;
    public int makeStringSorted(String s) {
        int n = s.length();
        int fact[] = new int[n+1];
        int inv[] = new int[n+1];

        fact[0] = fact[1] = inv[0] = inv[1] = 1;

        for(int i=2;i<=n;i++){
            fact[i] = prod(fact[i-1], i);
            inv[i] = pow(fact[i], mod - 2);
        }

        int ans = 0;
        int cnt[] = new int[26];
        for(int i=n-1;i>=0;i--){
            int ind = s.charAt(i) - 'a';
            cnt[ind]++;
            int c = 0;
            for(int j=0;j<ind;j++){
                c += cnt[j];
            }

            int p = prod(fact[n - i - 1], c);

            for(int cc : cnt){
                p = prod(p, inv[cc]);
            }

            ans = add(ans,p);
        }

        return ans;

    }

    private int add(int a, int b){
        long s = 1l * a+ b;
        return (int)(s%mod);
    }

    private int prod(int a, int b){
        long p = 1l * a * b;
        return (int)(p%mod);
    }

    private int pow(int a, int b){
        int p = 1;
        while(b > 0){
            if(b%2==1){
                p = prod(p,a);
            }

            a = prod(a,a);
            b>>=1;
        }

        return p;
    }
}