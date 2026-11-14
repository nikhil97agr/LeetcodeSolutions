package missing_element_in_sorted_array_1059;

class Solution {
    public int missingElement(int[] nums, int k) {
        int val = nums[0];
        int start = 0;
        int end = nums.length - 1;
        int ind = nums.length - 1;
        while(start <= end){
            int mid = (start + end)/2;

            int total = nums[mid] - val+1;
            int vals = mid +1;
            int missing = total - vals;
            if(missing >=k){
                ind = mid;
                end = mid - 1;
            }else{
                start = mid + 1;
            }

        }

        int total = nums[ind] - val + 1;

        int missing = total - (ind+1);

        if(missing < k){
            return nums[ind] + (k - missing);
        }

        return nums[ind] - (missing -k + 1);
    }
}