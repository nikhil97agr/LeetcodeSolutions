class Solution {
    public int minOperations(int[] nums) {
        int gcd = nums[0];
        int c= 0;
        for(int x :nums){
            gcd = gcd(x, gcd);
            if(x==1) c++;
        }
        if(gcd !=1) return -1;
        int n = nums.length;
        int cnt = 0;
        int ans = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
             gcd = nums[i];
             cnt = 0;
            for(int j=i;j<n;j++){
                gcd = gcd(nums[j], gcd);
                if(gcd == 1){
                    ans = Math.min(ans, cnt + n-1 - (nums[i] == 1 ? c-1 : c));
                    break;
                }
                cnt++;

            }
        }

        return ans;
    }

    int gcd( int a, int b){
        if(a==0) return b;

        return gcd(b%a,a);
    }
}