class Solution {
    public int specialTriplets(int[] nums) {
        int ans =0;
        Map<Integer, Integer> right = new HashMap<>();
        Map<Integer, Integer> left = new HashMap<>();
        for(int x : nums){
            right.merge(x, 1, Integer::sum);
        }

        for(int x : nums){
            int req = x * 2;
            int c1 = left.getOrDefault(req, 0);
            right.merge(x, -1, Integer::sum);
            int c2 = right.getOrDefault(req, 0);
            int p = prod(c1, c2);
            ans = sum(ans, p);
            left.merge(x, 1, Integer::sum);
        }

        return ans;
    }

    int prod(int a, int b){
        long prod = 1l*a*b;
        long mod = (long)1e9 + 7;

        return (int)(prod%mod);
    }

    int sum(int a, int b){
        int mod = (int)1e9 +7 ;

        return (a+b)%mod;
    }
}