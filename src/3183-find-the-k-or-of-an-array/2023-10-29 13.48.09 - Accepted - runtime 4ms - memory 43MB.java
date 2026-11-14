class Solution {
    public int findKOr(int[] nums, int k) {
        int n = nums.length;
        int cnt[] = new int[32];
        for(int i=0;i<n;i++){
            int j=0;
            int x= nums[i];
            while(x>0){
                int bit = x%2;
                if(bit==1){
                    cnt[j]++;
                }
                j++;
                x/=2;
            }
        }
        int ans = 0;
        for(int i=0;i<32;i++){
            if(cnt[i]>=k){
                ans += (1<<i);
            }
        }

        return ans;


    }
}