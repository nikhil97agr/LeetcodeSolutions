package find_the_array_concatenation_value_2698;

class Solution {
    public long findTheArrayConcVal(int[] nums) {
        int start = 0;
        int end = nums.length-1;
        long ans =0;

        while(start < end){
            String s= ""+nums[start]+nums[end];
            ans += Long.parseLong(s);
            start++;
            end--;
        }

        if(start == end) ans += nums[end];

        return ans;
    }
}