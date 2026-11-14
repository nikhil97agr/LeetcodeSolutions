package number_of_ways_to_split_array_2358;

class Solution {
    public int waysToSplitArray(int[] nums) {
        int n = nums.length;
        long sum = 0;
        for(int x : nums){
            sum += 1l*x;

        }

        int cnt = 0;
        long total = 0;
        for(int i=0;i<n-1;i++){
            sum -= 1l*nums[i];
            total += 1l*nums[i];
            if(total>=sum){
                cnt++;
            }
        }
        return cnt;
    }
}