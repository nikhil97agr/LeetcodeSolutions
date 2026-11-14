class Solution {
    public int countKDifference(int[] nums, int k) {
        int ans = 0;
        int cnt[] = new int[101];
        for(int x : nums) cnt[x]++;
        for(int i=1;i+k <= 100;i++){
            ans += cnt[i]*cnt[i+k];
        }
        return ans;
    }
}