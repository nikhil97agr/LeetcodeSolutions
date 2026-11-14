package transformed_array_3651;

class Solution {
    public int[] constructTransformedArray(int[] nums) {
        int  n = nums.length;
        int result[] = new int[n];
        for(int i=0;i<n;i++){
            if(nums[i] > 0){
                int j=i;
                int x = nums[i];
                while(x-->0){
                    j++;
                    j%=n;
                }
                
                result[i] = nums[j];
            }else if(nums[i] < 0){
                int j=i;
                int x = Math.abs(nums[i]);
                while(x-->0){
                    j--;
                    if(j<0) j=n-1;
                }
                result[i] = nums[j];
            }else{
                result[i] = nums[i];
            }
        }
        
        return result;
    }
}