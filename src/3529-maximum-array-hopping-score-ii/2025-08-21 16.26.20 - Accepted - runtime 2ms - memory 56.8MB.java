class Solution {
    public long maxScore(int[] nums) {
        int n = nums.length;
        int ind[]= new int[n];
        long ans = 0;

        ind[n-1] = n-1;

        for(int i=n-2;i>=0;i--){
            if(nums[i+1] > nums[ind[i+1]]){
                ind[i] = i+1;
            }else{
                ind[i] = ind[i+1];
            }
        }

        int curr = 0;
        while(curr != n-1){
            int next = ind[curr];
            ans += 1l*(next - curr)*nums[next];
            curr = next;
        }

        return ans;
    }
}