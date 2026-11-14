class Solution {
    public int scoreDifference(int[] nums) {
        int first = 0;
        int second = 0;
        boolean f= true;
        boolean s = false;
        int n= nums.length;
        for(int i=0;i<n;i++){
            if(nums[i]%2==1){
                f ^= true;
                s ^= true;
            }

            if(i%6==5){
                f ^= true;
                s ^= true;
            }

            if(f ) first+=nums[i];
            else second += nums[i];
        }

        return first - second;
    }
}