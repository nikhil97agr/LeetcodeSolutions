package house_robber_198;

class Solution {
    public int rob(int[] nums) {
       int n = nums.length;
        int a = 0;
        int b = 0;
        for(int i=0;i<n;i++){
            if(i%2==0){
                a = Math.max(b, a+nums[i]);
            }else{
                b = Math.max(a, b+nums[i]);
            }
        }
        return Math.max(a,b);
    }
    
  
}