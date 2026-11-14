package number_of_sub_arrays_with_odd_sum_1631;

class Solution {
    public int numOfSubarrays(int[] arr) {
        long cnt[] = new long[2];

        long ans = 0;
        long mod = (long)1e9+7;

        int sum = 0;
        for(int x : arr){
            sum += x;

            int rem =sum%2;

            if(rem==1) ans++;
            if(rem == 1) ans += cnt[0];
            else ans+=cnt[1];
            ans%=mod;
            cnt[rem]++;
        }

        return (int)ans;
    }
}