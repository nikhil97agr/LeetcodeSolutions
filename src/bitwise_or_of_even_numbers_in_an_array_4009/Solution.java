package bitwise_or_of_even_numbers_in_an_array_4009;

class Solution {
    public int evenNumberBitwiseORs(int[] nums) {
        int ans = 0;
        for(int x : nums){
            if(x%2==0) ans |= x;
        }

        return ans;
    }
}