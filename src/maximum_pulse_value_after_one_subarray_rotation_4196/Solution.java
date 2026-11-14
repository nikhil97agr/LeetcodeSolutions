package maximum_pulse_value_after_one_subarray_rotation_4196;

class Solution {
    public long maxValue(int[] nums) {
        long sum = 0;
        long min = Long.MAX_VALUE;
        long even = 0;
        long odd = (long)-1e18;
        int flag = 1;
        for(int i=0;i<nums.length;i++){
            int x = nums[i];
            long xx = flag * x;

            sum +=xx;

            if((i +1)%2 == 0){
                min = Math.min(sum - even , min);
                even = Math.max(sum, even);
            }else{
                min = Math.min(sum - odd, min);
                odd = Math.max(odd, sum);
            }



            flag *= -1;
        }

        return sum - 2 * Math.min(0, min);
    }
}