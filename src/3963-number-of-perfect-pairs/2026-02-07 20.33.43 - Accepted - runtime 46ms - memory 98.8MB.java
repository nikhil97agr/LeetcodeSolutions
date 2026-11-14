class Solution {
    public long perfectPairs(int[] nums) {
        int n = nums.length;
        int abs[] = new int[n];
        for(int i=0;i<n;i++){
            abs[i] =Math.abs(nums[i]);
        }
        Arrays.sort(abs);
        int start = 0;
        int end = 1;
        long ans= 0;
        for(;start < n;start++){
            while(end < n && abs[end] <= 2 * abs[start]){
                end++;
            }
            ans += (end - start - 1);
        }

        return ans;
    }
}