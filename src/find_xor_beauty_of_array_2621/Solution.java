package find_xor_beauty_of_array_2621;

class Solution {
    public int xorBeauty(int[] nums) {
        int n = nums.length;
        int ans = 0;
        for(int i=32;i>=0;i--){
            int c = 0;
            for(int x : nums){
                if((x & (1<<i)) != 0){
                    c++;
                }
            }

            long total = 0;
            for(int x : nums){
                if((x&(1<<i)) !=0){
                    total += 1l*n*c;
                }else{
                    total += 1l*c*c;
                }

                total %=2;
            }

            if(total == 1){
                ans |= (1<<i);
            }
        }

        return ans;
    }
}