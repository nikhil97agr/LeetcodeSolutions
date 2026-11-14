class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int ans = 0;
        int cnt = 0;

        for(int x : nums){
            if(x==1) cnt++;
            else{
                ans = Math.max(ans, cnt);
                cnt = 0;
            }
        }

        return Math.max(ans, cnt);
    }
}