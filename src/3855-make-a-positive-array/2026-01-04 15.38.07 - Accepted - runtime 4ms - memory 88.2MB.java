class Solution {
    public int makeArrayPositive(int[] nums) {
        int n = nums.length;
        long pre[] = new long[n];
        pre[0] = nums[0];

        for(int i=1;i<n;i++){
            pre[i] = pre[i-1] + nums[i];
        }
        int ans = 0;
        long max = 0;


        for(int i=0;i<n-2;i++){
            if(pre[i+2] - max <= 0){
                ans++;
                i+=2;
                max = pre[i];
            }else{
                max = Math.max(max, pre[i]);
            }
        }
        return ans;
    }
}