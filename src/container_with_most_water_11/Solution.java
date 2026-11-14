package container_with_most_water_11;

class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int ans = 0;
        int start= 0;
        int end = n-1;
        while(start < end){
            ans = Math.max(ans, (end - start) * Math.min(height[start], height[end]));

            if(height[start] < height[end]){
                 start++;
            }else{
                end--;
            }
        }

        return ans;
    }
}