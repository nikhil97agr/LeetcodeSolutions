class Solution {
    public int findMiddleIndex(int[] nums) {
        int sum = 0;
        for(int x : nums) sum += x;
        int curr = 0;
        
        for(int i=0;i<nums.length;i++){
            sum -= nums[i];
            if(curr == sum) return i;
            curr += nums[i];
        }   
        return -1;
    }
}