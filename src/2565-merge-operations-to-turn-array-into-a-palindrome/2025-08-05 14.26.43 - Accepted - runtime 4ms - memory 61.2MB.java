class Solution {
    public int minimumOperations(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        int ans = 0;
        int n = nums.length;
        if(n==1) return 0;
        if(n==2){
            if(nums[0] == nums[1]) return 0;
            return 1;
        }
        while(start < end){
            if(nums[start] == nums[end]){
                start++;
                end--;
            }else if(nums[start] < nums[end]){
                nums[start+1] += nums[start];
                start++;
                ans++;
            }else{
                nums[end-1] += nums[end];
                end--;
                ans++;
            }
        }
        return ans;
    }
}