package binary_searchable_numbers_in_an_unsorted_array_2111;

class Solution {
    public int binarySearchableNumbers(int[] nums) {
        int n = nums.length;
        int pre[] = new int[n+1];
        int suff[] = new int[n+1];
        pre[0] = Integer.MIN_VALUE;
        suff[n] =Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            pre[i+1] = Math.max(pre[i], nums[i]);
        }

        for(int i=n-1;i>=0;i--){
            suff[i] = Math.min(suff[i+1], nums[i]);
        }

        int ans = 0;
        for(int i=0;i<n;i++){
            if(pre[i+1] <= nums[i] && suff[i+1] >= nums[i]) ans++;
        }

        return ans;




    }
}