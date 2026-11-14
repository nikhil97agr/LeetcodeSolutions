class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int length = Integer.MAX_VALUE;
        int left = 0;
        int n = nums.length;
        int total = 0;
        for(int i=0;i<n;i++){
            total += nums[i];
            if(nums[i]>=target){
                return 1;
            }
        }
        if(total<target){
            return 0;
        }
        total = 0;
       for(int i=0;i<n;i++){
           total += nums[i];
           if(total>=target){
               while(left<i&&total>=target){
                   length = Math.min(length, i-left+1);
                   total -= nums[left];
                   left++;
                   
               }
               
           }
       }
        if(length==Integer.MAX_VALUE){
            return 0;
        }
        return length;
        
    }
}