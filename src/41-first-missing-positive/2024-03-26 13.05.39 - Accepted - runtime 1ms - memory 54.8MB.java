class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        boolean one = false;
        for(int i=0;i<n;i++){
            if(nums[i]==1) one = true;
            if(nums[i]<=0 || nums[i]>n) nums[i] = 1;
        }

        if(!one) return 1;

        for(int i=0;i<n;i++){
            int index = (nums[i]-1)%n;
            nums[index] += n;

        }

        for(int i=0;i<n;i++){
            if(nums[i]<=n) return i+1;
        }

        return n+1;
    }
}