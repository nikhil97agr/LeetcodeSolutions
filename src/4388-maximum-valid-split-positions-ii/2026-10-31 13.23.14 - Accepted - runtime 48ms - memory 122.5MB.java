class Solution {
    public int maxValidSplits(int[] nums) {
        int n = nums.length;
        int pre[] = new int[n + 1];
        for(int i=1;i<=n;i++){
            pre[i] = gcd(pre[i-1], nums[i-1]);
        }
        int ans = 0;

        for(int i=0;i<=n;i++){
            if( i > 0 && pre[i] == pre[i-1]){
                continue;
            }

            ans = Math.max(ans, compute(nums, i - 1, n));
        }

        return ans;
    }

    private int compute(int nums[], int delIndex, int n){
        int pre[] = new int[n+1];
        int suff[] = new int[n+1];
        
        for(int i=1;i<=n;i++){
            if( i -1 == delIndex){
                pre[i] = pre[i-1];
            }else{
                pre[i] = gcd(pre[i-1], nums[i-1]);
            }
        }

        for(int i=n-1;i>=0;i--){
            if(i == delIndex){
                suff[i] = suff[i + 1];
            }else{
                suff[i] = gcd(suff[i + 1], nums[i]);
            }
        }

        int ans = 0;

        for(int i=0;i<n-1;i++){
            if( i != delIndex && pre[i + 1] == suff[i + 1]){
                ans++;
            }
        }

        return ans;
    }

    private int gcd(int a, int b){
        if(a == 0) return b;
        return gcd(b%a, a);
    }
}