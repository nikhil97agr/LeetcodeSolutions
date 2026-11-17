package apply_operations_to_an_array_2551;

class Solution {
    public int[] applyOperations(int[] nums) {
        int n = nums.length;
        for(int i=0;i<n-1;i++){
            if(nums[i]==nums[i+1]){
                nums[i]*=2;
                nums[i+1] = 0;
            }
        }
        int zeroCount = 0;
        int result[] = new int[n];
        int j=0;
        for(int i=0;i<n;i++){
            if(nums[i]==0){
                continue;
            }
            result[j++] = nums[i];
        }
        while(j<n){
            result[j++] = 0;
        }
        return result;
    }
}