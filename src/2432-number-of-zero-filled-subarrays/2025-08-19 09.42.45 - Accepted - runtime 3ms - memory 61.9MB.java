class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long ans = 0;
        int cnt = 0;

        for(int x : nums){
            if(x==0){
                cnt++;
            }else{
                ans += (1l*cnt*(cnt+1))/2;
                cnt = 0;
            }
        }


        return ans + (1l*cnt*(cnt+1))/2;
    }
}