package prime_in_diagonal_2722;

class Solution {
    public int diagonalPrime(int[][] nums) {
       int ans = Integer.MIN_VALUE;
        int n = nums.length;
        for(int i=0;i<n;i++){
            if(nums[i][i]>ans){
                if(checkPrime(nums[i][i])){
                    ans = nums[i][i];
                }
            }
            
            if(nums[i][n-1-i]>ans){
                if(checkPrime(nums[i][n-1-i])){
                    ans = nums[i][n-1-i];
                }
            }
        }
        return ans==Integer.MIN_VALUE ? 0 : ans;
    }
    
    private boolean checkPrime(int n){
        if(n==1){
            return false;
        }
        if(n==2){
            return true;
        }
        if(n==3){
            return true;
        }
        if(n%2==0){
            return false;
        }
        for(int i=3;i<=Math.sqrt(n);i+=2){
            if(n%i==0){
                return false;
            }
        }
        
        return true;
    }
}