class Solution {
    public int numIdenticalPairs(int[] nums) {
        int cnt[] = new int[100];
        int ans = 0;
        for(int x : nums){
            ans += cnt[x-1];
            cnt[x-1]++;
        }
        return ans;
    }
}