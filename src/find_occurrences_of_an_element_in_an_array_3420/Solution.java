package find_occurrences_of_an_element_in_an_array_3420;

import java.util.*;
class Solution {
    public int[] occurrencesOfElement(int[] nums, int[] queries, int x) {
        Map<Integer, Integer> map = new HashMap<>();
        int cnt = 0;
        for(int i=0;i<nums.length;i++)
        {   
            int y = nums[i];
            if(x==y){
                map.put(++cnt, i);
            }
        }
        int ans[] = new int[queries.length];

        for(int i=0;i<queries.length;i++){
            ans[i] = map.getOrDefault(queries[i], -1);
        }
        return ans;
    }
}