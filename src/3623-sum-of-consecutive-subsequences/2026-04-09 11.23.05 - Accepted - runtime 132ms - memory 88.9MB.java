class Solution {
    private int mod = 1_000_000_007;
    public int getSum(int[] nums) {
        var n = nums.length;
        var total = 0;
        for(var x : nums){
            total =add(total, x);
        }
        var max = Arrays.stream(nums).max().getAsInt();
        return add(solve(nums, -1, max), solve(nums, 1, max), -total);
    }

    private int solve(int nums[], int diff, int max){
        var cnt = new int[max + 2];
        var sum = new int[max + 2];

        for(var x : nums){
            var total = add(cnt[x +diff], 1);
            cnt[x] = add(cnt[x], total);
            sum[x]=  add(sum[x], sum[x + diff], prod(total, x));
        }

        var ans = 0;

        for(var x : sum){
            ans = add(ans, x);
        }

        return ans;
    }

    private int add(long...arr){
        long ans = 0;

        for(long x : arr){
            ans +=x;
            ans += mod;
            ans%=mod;
        }

        return (int)ans;
    }

    private int prod(long a, long b){
        return (int)((a*b)%mod);
    }
}