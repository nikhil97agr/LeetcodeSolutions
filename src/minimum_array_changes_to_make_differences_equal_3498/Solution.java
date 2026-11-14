package minimum_array_changes_to_make_differences_equal_3498;

class Solution {
    public int minChanges(int[] nums, int k) {
        int n = nums.length;
        int ans = n;
        int cnt[] = new int[k+2];
        for(int i=0;i<n/2;i++){
            int min = Math.min(nums[i], nums[n-i-1]);
            int max = Math.max(nums[i], nums[n-i-1]);
            cnt[Math.max(k-min, max)+1]++;
            cnt[max - min]--;
            cnt[max - min + 1]++;
        }

        int total =n/2;

        for(int i=0;i<=k;i++){
            total += cnt[i];
            ans = Math.min(ans, total);
        }

        return ans;
    }
}