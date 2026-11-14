class Solution {
    public int subarrayGCD(int[] nums, int k) {
        int n = nums.length;
        int count = 0;
        for(int i=0;i<n;i++){
            int gcd = gcd(nums[i], nums[i]);
            if(gcd<k){
                continue;
            }
            if(gcd==k){
                count++;
            }
            for(int j=i+1;j<n;j++){
               gcd = gcd(gcd, nums[j]);
                if(gcd==k){
                    count++;
                }else if(gcd<k){
                    break;
                }
            }
        }
        return count;
    }
    
    public int gcd(int a, int b){
        if(b==0){
            return a;
        }
        return gcd(b, a%b);
    }
}