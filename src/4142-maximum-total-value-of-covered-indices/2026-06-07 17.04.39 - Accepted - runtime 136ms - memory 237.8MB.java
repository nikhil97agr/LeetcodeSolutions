class Solution {
    Long dp[][];
    public long maxTotal(int[] nums, String s) {
        char ch[] = s.toCharArray();
        dp = new Long[s.length()][2];
        return (ch[0] == '0' ? 0 : nums[0]) + sum(1, nums, ch, ch[0] - '0');
    }

    private long sum(int i, int nums[], char ch[], int prev){
        if(i == nums.length) return 0;

        if(dp[i][prev] != null) return dp[i][prev];

        if(ch[i] == '0'){
            return dp[i][prev]= sum(i + 1, nums, ch, 0);
        }

        if(prev == 1){
            return dp[i][prev] = nums[i] + sum(i + 1, nums, ch, 1);
        }

        return dp[i][prev] = Math.max(nums[i] + sum(i + 1, nums, ch, 1), nums[i-1] + sum(i +1, nums, ch, 0));
    }
}