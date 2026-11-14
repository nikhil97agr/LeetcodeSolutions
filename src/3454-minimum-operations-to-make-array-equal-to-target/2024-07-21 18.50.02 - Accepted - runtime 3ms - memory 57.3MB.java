class Solution {
    public long minimumOperations(int[] nums, int[] target) {
        long ans = 0;
        int n =nums.length;
        int diff[] = new int[n];

        for(int i=0;i<n;i++){
            diff[i] = target[i] - nums[i];
        }
        ans = Math.abs(diff[0]);
        for(int i=1;i<n;i++){
            if(diff[i] < 0 && diff[i-1] < 0){
                if(diff[i] < diff[i-1]){
                    ans +=(diff[i-1] - diff[i]);
                }
            }else if(diff[i] > 0 && diff[i-1] > 0){
                if(diff[i] > diff[i-1]){
                    ans += (diff[i] - diff[i-1]);
                }
            }else{
                ans +=Math.abs(diff[i]);
            }
        }

        return ans;
    }
}