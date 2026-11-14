class Solution {
    public int waysToMakeFair(int[] nums) {
        int n = nums.length;
        int preOdd[] = new int[n+1];
        int preEven[] = new int[n+1];
        int ans =0;

        for(int i=n-1;i>0;i--){
            if(i%2==0){
                preEven[i] = preEven[i+1] + nums[i];
                preOdd[i] = preOdd[i+1];
            }else{
                preEven[i] = preEven[i+1];
                preOdd[i] = preOdd[i+1] + nums[i];
            }
        }

        int even = 0;
        int odd = 0;

        for(int i=0;i<n;i++){
            if(even + preOdd[i+1] == odd + preEven[i+1]){
                    ans++;
                }
            if(i%2==0){
  
                even += nums[i];
            }else{
                odd += nums[i];
            }
        }

        return ans;

    }
}