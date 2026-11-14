class Solution {
    public int getSum(int[] nums) {
        int n = nums.length;
        int ans = 0;
        int len[] = new int[n];
        len[0] = 1;
        for(int i=1;i<n;i++){
            if(nums[i] - nums[i-1] == 1){
                len[i] = len[i -1] + 1;
            }else{
                len[i] = 1;
            }
        }

        ans = calc(n, len, nums);
        len = new int[n];
        len[0] = 1;
        for(int i=1;i<n;i++){
            if(nums[i] - nums[i-1] == -1){
                len[i] = len[i-1] + 1;
            }else{
                len[i] = 1;
            }
        }

        ans = sum(ans, calc(n, len, nums));
        for(int i=0;i<n;i++){
            ans = sum(ans, -nums[i]);
        }
        
        return ans;
    }

    private int calc(int n, int len[], int nums[]){
        int ans = 0;
        for(int i=n-1;i>=0;i--){
            int cnt =len[i];
            int c= len[i];
            while(cnt > 0){
                int left = cnt - 1;
                int right = c - cnt;

                ans = sum(ans, prod(left, nums[i]));
                ans = sum(ans, prod(right, nums[i]));
                ans = sum(ans, prod(prod(left, right), nums[i]));
                ans = sum(ans, nums[i]);
                cnt--;
                i--;
            }
            i++;

        }
        return ans;
    }

    private int prod(int a, int b){
        long prod = 1l * a * b;
        long mod = (long) 1e9 + 7;

        return (int)(prod%mod);
    }

    private int sum(int a, int b){
        long mod = (long)1e9 + 7;

        long sum = mod + a + b;

        return (int)(sum%mod);
    }
}