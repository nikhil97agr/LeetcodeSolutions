package remove_boxes_546;

class Solution {
    Integer dp[][][];
    public int removeBoxes(int[] boxes) {
        int n = boxes.length;
        dp= new Integer[n][n][n];
        return solve(boxes, 0, n-1, 0);
    }   
    
    private int solve(int nums[], int start, int end, int cnt){
        if(start > end) return 0;
        if(dp[start][end][cnt] !=null) return dp[start][end][cnt];
        int l = start;
        int r = end;
        int c = cnt;
        while( l + 1 <= r && nums[l] == nums[l+1]){
            c++;
            l++;
        }
        
        int ans = (c+1) * (c+1) + solve(nums, l+1, r, 0);
        
        for(int j=l+1;j<=r;j++){
            if(nums[j] == nums[l]){
                ans = Math.max(ans, 
                        solve(nums, l+1, j-1, 0) + solve(nums, j, r, c + 1)
                        );
            }
        }
        
        return dp[start][end][cnt] = ans;
    }
}