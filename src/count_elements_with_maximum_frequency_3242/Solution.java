package count_elements_with_maximum_frequency_3242;

import java.util.*;
class Solution {
    public int maxFrequencyElements(int[] nums) {
        int max = Arrays.stream(nums).max().getAsInt();
        int cnt[] = new int[max+1];
        for(int x : nums){
            cnt[x]++;
        }
        final int m = Arrays.stream(cnt).max().getAsInt();
        int total = Arrays.stream(cnt).filter(a -> a == m).reduce(0, Integer::sum);
        return total;
    }
}