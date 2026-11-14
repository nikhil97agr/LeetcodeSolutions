package remove_duplicates_from_sorted_array_ii_80;

class Solution {
    public int removeDuplicates(int[] nums) {
        int cnt = 1;
        int j = 1;
        int n = nums.length;
        for(int i=1;i<n;i++){
            if(nums[i]==nums[i-1]){
                cnt++;
            }else{
                cnt = 1;
            }

            if(cnt <= 2){
                nums[j++] = nums[i];
            }
        }
        return j;
    }
}