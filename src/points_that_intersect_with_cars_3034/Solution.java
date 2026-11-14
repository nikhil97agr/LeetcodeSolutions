package points_that_intersect_with_cars_3034;

import java.util.*;
class Solution {
    public int numberOfPoints(List<List<Integer>> nums) {
        Set<Integer> ans = new HashSet<>();
        for(List<Integer> num : nums){
            for(int i=num.get(0);i<=num.get(1);i++){
                ans.add(i);
            }
        }
        return ans.size();
    }
}