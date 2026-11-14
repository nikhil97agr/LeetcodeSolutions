package maximum_bags_with_full_capacity_of_rocks_2366;

import java.util.*;
class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int n = capacity.length;
        int left[] = new int[n];

        for(int i=0;i<n;i++){
            left[i] = capacity[i] - rocks[i];
        }

        Arrays.sort(left);
        int count = 0;
        for(int i=0;i<n;i++){
            if(left[i] <= additionalRocks){
                count++;
                additionalRocks -= left[i];
            }
        }

        return count;
    }
}