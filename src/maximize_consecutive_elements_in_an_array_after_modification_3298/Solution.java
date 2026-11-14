package maximize_consecutive_elements_in_an_array_after_modification_3298;

import java.util.*;
class Solution {
    public int maxSelectedElements(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int max = nums[n-1] + 1;
        int cnt[] = new int[max+1];

        for(int x : nums){
            cnt[x+1] = cnt[x] + 1;
            cnt[x] = cnt[x-1] + 1;
        }

        return Arrays.stream(cnt).max().getAsInt();
    }
}