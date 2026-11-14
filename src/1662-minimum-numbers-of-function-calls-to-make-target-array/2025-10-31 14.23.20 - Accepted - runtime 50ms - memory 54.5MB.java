class Solution {
    public int minOperations(int[] nums) {
        int ans = 0;
        Arrays.sort(nums);
        int div = 0;

        for(int x : nums){
            if(x==0) continue;
            for(int j=0;j<div;j++){
                    if(x%2==1){
                        x--;
                        ans++;
                    }
                    x/=2;
                }
            while( x > 1){
                
                if(x%2==1){
                    x--;
                    ans++;
                }
                x/=2;
                div++;
                ans++;
            }
            ans++;

        }

        return ans;
    }
}