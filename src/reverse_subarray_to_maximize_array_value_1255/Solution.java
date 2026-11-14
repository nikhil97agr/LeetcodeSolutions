package reverse_subarray_to_maximize_array_value_1255;

class Solution {
    public int maxValueAfterReverse(int[] nums) {
        int n = nums.length;
        int total = 0;
        int maxChange = 0;
        int min = 1_000_000;
        int max = -1_000_000;

        for(int i=0;i<n-1;i++){
            int a= nums[i];
            int b = nums[i+1];
            total += Math.abs(a- b);
            maxChange = Math.max(maxChange, Math.abs(nums[0] - b) - Math.abs(a-b));
            maxChange = Math.max(maxChange, Math.abs(nums[n-1] - a) - Math.abs(a-b));

            min = Math.min(min, Math.max(a,b));
            max = Math.max(max, Math.min(a,b));

            
        }

        return total + Math.max(maxChange, (max - min)*2);
    }
}