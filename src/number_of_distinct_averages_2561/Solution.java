package number_of_distinct_averages_2561;

import java.util.*;
class Solution {
    public int distinctAverages(int[] nums) {
        Arrays.sort(nums);
        Set<Double> set = new HashSet<Double>();
        int i=0, j=nums.length-1;
        while(i<j){
            double avg = ((double)(nums[i]+nums[j]))/2d;
            set.add(avg);
            i++;
            j--;
        }
        return set.size();
    }
}