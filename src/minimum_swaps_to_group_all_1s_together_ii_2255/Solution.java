package minimum_swaps_to_group_all_1s_together_ii_2255;

class Solution {
    public int minSwaps(int[] nums) {
        int cnt = 0;
        int ans = Integer.MAX_VALUE;
        for(int x : nums){
            if(x==1) cnt++;
        }

        int one = 0;
        for(int i=0;i<cnt;i++){
            if(nums[i] == 1){
                one++;
            }
        }
        int n = nums.length;
        if(cnt ==0 ) return 0;
        int i=cnt%n;
        int start = 0;
        while(i!=cnt-1){
            ans = Math.min(ans, cnt - one);
            if(nums[i] == 1)one++;
            if(nums[start]==1)one--;
            i++;
            start++;
            i%=n;
            start%=n;
        }

        ans = Math.min(ans, cnt - one);
        return ans;
    }
}