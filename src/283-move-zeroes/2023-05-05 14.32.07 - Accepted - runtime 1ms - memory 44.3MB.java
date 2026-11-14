class Solution {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int zeros = 0;
        int i =0;
        int start = 0;
        while(i<n){
            while(i<n&&nums[i]==0){
                zeros++;
                i++;
            }
            if(i==n){
                break;
            }
            nums[start] = nums[i];
            i++;
            start++;
        }
        while(start<n){
            nums[start++] = 0;
        }
    }
}