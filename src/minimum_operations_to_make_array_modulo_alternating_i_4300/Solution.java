package minimum_operations_to_make_array_modulo_alternating_i_4300;

class Solution {
    public int minOperations(int[] nums, int k) {
        int ans = Integer.MAX_VALUE;
        int n = nums.length;
        for(int x =0;x < k;x++){
            
            for(int y=0;y < k;y++){
                if(x ==y) continue;
                int cnt = 0;
                for(int i=0;i<n;i++){
                    int mod = nums[i]%k;
                    int d = x;
                    if(i%2==1){
                        d = y;
                    }

                    cnt += Math.min(Math.abs( d - mod), k - Math.abs(mod - d));
                }

                ans = Math.min(ans, cnt);
            }
        }

        return ans;
    }
}