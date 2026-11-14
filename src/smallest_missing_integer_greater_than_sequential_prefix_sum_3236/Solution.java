package smallest_missing_integer_greater_than_sequential_prefix_sum_3236;

class Solution {
    public int missingInteger(int[] nums) {
        int sum =  nums[0];
        for(int i = 1;i<nums.length;i++){
            if(nums[i] == nums[i-1] + 1){
                sum += nums[i];
            }else{
                break;
            }
        }
        if(sum > 50){
            return sum;
        }

        boolean vis[] = new boolean[52];
        for(int x : nums) vis[x] = true;
        while(vis[sum]){
            sum++;
        }

        return sum;

    }
}