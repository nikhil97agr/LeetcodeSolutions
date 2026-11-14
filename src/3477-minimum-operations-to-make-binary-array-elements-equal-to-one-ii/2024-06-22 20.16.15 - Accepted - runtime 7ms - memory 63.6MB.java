class Solution {
    public int minOperations(int[] nums) {
        int mod = 0;
        int left = 0;
        int right = 0;
        int n = nums.length;
        for(int i=0;i<n;i++){
            if(nums[i] ==0 && mod==0){
                left++;
                mod = 1;
            }else if(nums[i] == 1 && mod == 1){
                left++;
                mod = 0;
            }
        }
        return left;
    }
    
}