package zero_array_transformation_i_3639;

class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;
        int cnt[] = new int[n+1];

        for(int q[] : queries){
            cnt[q[0]]++;
            cnt[q[1]+1]--;
        }

        int sum = 0;

        for(int i=0;i<n;i++){
            sum += cnt[i];
            if(nums[i] > sum) return false;
        }

        return true;
    }
}