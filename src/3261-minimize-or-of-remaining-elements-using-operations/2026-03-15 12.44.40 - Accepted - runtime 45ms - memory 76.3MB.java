class Solution {
    public int minOrAfterOperations(int[] nums, int k) {
        int ans = 0;
        int canZero = 0;

        for(int i=29;i>=0;i--){
            int curr = 0;
            int req = canZero | (1<<i);
            int op = 0;

            for(int x : nums){
                if(curr == 0){
                    curr= x;
                }else{
                    curr &= x;
                }

                if((curr & req) !=0){
                    op++;
                }else{
                    curr = 0;
                }
            }

            if(op > k){
                ans |= (1<<i);
            }else{
                canZero |= (1<<i);
            }
        }

        return ans;
    }
}