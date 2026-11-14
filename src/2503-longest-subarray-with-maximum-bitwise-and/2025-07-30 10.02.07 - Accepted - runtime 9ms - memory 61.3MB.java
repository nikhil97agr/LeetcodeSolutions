class Solution {
    public int longestSubarray(int[] nums) {
        int max= Arrays.stream(nums).max().getAsInt();
        int cnt = 0;
        int ans = 0;

        for(int x : nums){
            if(x == max){
                cnt++;
            }else{
                cnt = 0;
            }
            ans = Math.max(ans, cnt); 
        }

        return ans;
    }
}