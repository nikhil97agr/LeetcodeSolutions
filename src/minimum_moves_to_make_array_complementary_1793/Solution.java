package minimum_moves_to_make_array_complementary_1793;

class Solution {
    public int minMoves(int[] nums, int limit) {
        int n = nums.length;
        int diff[]= new int[limit*2+2];

        for(int i=0;i<n/2;i++){
            int l = nums[i];
            int r = nums[n-i-1];
            int min = Math.min(l,r);
            int max = Math.max(l,r);

            diff[min + 1]--;
            diff[min+max]--;
            diff[min+max+1]++;
            diff[max+limit+1]++;
        }

        int ans = n;
        int op = n;

        for(int i=2;i<=2*limit;i++){
            op += diff[i];
            ans = Math.min(ans, op);
        }

        return ans;
    }
}