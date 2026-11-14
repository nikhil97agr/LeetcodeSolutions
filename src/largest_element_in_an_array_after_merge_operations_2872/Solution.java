package largest_element_in_an_array_after_merge_operations_2872;

class Solution {
    public long maxArrayValue(int[] nums) {
       long ans = 0;
       long temp[] = new long[nums.length];
       for(int i=0;i<nums.length;i++) {
        temp[i] = 1L*nums[i];
       }
       for(int i=nums.length-1;i>0;i--){
        if(temp[i] >= temp[i-1]){
            temp[i-1] = temp[i] + temp[i-1];
            ans = Math.max(ans, temp[i-1]);
        }else{
            ans = Math.max(ans, temp[i]);
        }
       }
       ans = Math.max(ans, temp[0]);
       return ans;
    }
}