class Solution {
        long mod =(long)1e9 + 7;
    public int minMaxSums(int[] nums, int k) {
        int ans = 0;
        int n = nums.length;
        Arrays.sort(nums);
        int fact[] = new int[n + 1];
        int invFact[] = new int[n+1];
        fact[0] = fact[1] = 1;

        for (int i = 2; i <= n; i++) {
            fact[i] = prod(fact[i - 1], i);
        }


        for(int i=n;i>=0;i--){
            invFact[i] = pow(fact[i], (int)mod-2);
        }
        for (int i = 1; i <= k; i++) {
            ans = add(ans, count(nums, i, fact, invFact));
        }
        return ans;
    }

    private int count(int nums[], int len, int fact[], int invFact[]) {
        int total = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int left = i;
            int right = n - (i + 1);
            
            total = add(total, prod(nums[i], combinations(left, len-1, fact,invFact)));
            total = add(total, prod(nums[i], combinations(right, len - 1, fact,invFact)));
        }

        return total;
    }


    private int combinations(int n, int r, int fact[], int invFact[]) {
        if (r > n)
            return 0;

        if (r == n)
            return 1;

        return prod(fact[n], prod(invFact[r], invFact[n-r]));
    }

    private int add(int a, int b) {
        long sum = 1l * a + b;

        return (int) (sum % mod);
    }

    private int prod(int a, int b) {
        long prod = 1l * a * b;

        return (int) (prod % mod);
    }

    private int pow(int x, int y){
        if(x==0)return 0;
        if(y==0) return 1;
        if(x==1)return 1;

        int ans = pow(x, y/2);
        ans = prod(ans, ans);
        if(y%2==1){
            ans = prod(ans, x);
        }

        return ans;
    }

}