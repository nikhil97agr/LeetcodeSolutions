package rearrange_array_by_removing_distinct_values_4429;

class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        int ans[] = new int[n];
        int i=0;
        int cnt[] = new int[101];
        for(int x : nums){
            cnt[x]++;
        }

        while(i < nums.length){
            for(int j=1;j<=100;j++){
                if(cnt[j] != 0){
                    ans[i++] = j;
                    cnt[j]--;
                }
            }
        }

        return ans;
    }
}