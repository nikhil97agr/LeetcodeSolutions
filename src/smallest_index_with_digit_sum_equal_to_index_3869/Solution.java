package smallest_index_with_digit_sum_equal_to_index_3869;

class Solution {
    public int smallestIndex(int[] nums) {
        
        for(int i=0;i<nums.length;i++){
            int sum = get(nums[i]);

            if(sum == i) return i;
        }

        return -1;
    }

    private int get(int x){
        int sum = 0;
        while(x > 0){
            sum+= x%10;
            x/=10;
        }
        return sum;
    }
}