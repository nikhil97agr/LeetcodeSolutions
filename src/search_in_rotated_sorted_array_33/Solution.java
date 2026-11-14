package search_in_rotated_sorted_array_33;

class Solution {
    public int search(int[] nums, int target) {
        int start = 0;
        int n = nums.length;
        int end = n - 1;
        if (target == nums[0]) {
            return 0;
        }
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;
            }

            if (nums[mid] < target) {
                if (nums[mid] < nums[0] && target >= nums[0]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }

            } else {
                if (target < nums[0] && nums[mid] >= nums[0]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }
}