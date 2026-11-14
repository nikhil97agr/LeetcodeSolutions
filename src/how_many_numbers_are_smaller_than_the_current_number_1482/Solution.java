package how_many_numbers_are_smaller_than_the_current_number_1482;

class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int n = nums.length;
        int ans[] = new int[n];

        for(int i=0;i<n;i++){
            int cnt = 0;
            for(int j=0;j<n;j++){
                if(i!=j){
                    if(nums[i] > nums[j]){
                        cnt++;
                    }
                }
            }
            ans[i] = cnt;
        }

        return ans;
    }
}