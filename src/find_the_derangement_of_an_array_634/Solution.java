package find_the_derangement_of_an_array_634;

class Solution {
    long mod = (long) 1e9 + 7;

    public int findDerangement(int n) {

        int fact[] = new int[n + 1];
        fact[0] = fact[1] = 1;
        for (int i = 2; i <= n; i++) {
            fact[i] = prod(i, fact[i - 1]);
        }
        int ans = fact[n];

        boolean exc = true;
        for (int i = 1; i <= n; i++) {
            int p = prod(ncr(i, n, fact), fact[n-i]);
            if (exc) {
                ans = sum(ans, -p);
            } else {
                ans = sum(ans, p);
            }
            exc = !exc;
        }

        return ans;
    }

    private int ncr(int r, int n, int fact[]){
        int x = fact[n];
        int y = pow(fact[r], (int)(mod - 2));
        int z = pow(fact[n-r], (int)(mod - 2));

        return prod(x, prod(y, z));
    }


    int pow(int a, int b){
        if(a<=1) return a;

        if(b==0) return 1;

        int p= pow(a, b/2);
        p =prod(p, p);

        if(b%2==1){
            p = prod(p, a);
        }

        return p;
    }

    private int prod(int a, int b) {
        long p = 1l * a * b;

        return (int) (p % mod);
    }

    private int sum(int a, int b) {
        long sum = mod + a + b;

        return (int) (sum % mod);
    }

}