package find_all_duplicates_in_an_array_442;

import java.util.*;
class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList();
        int n = nums.length;
        for(int i=0;i<n;i++){
            nums[i]--;
        }
        for(int i=0;i<n;i++){
            nums[nums[i]%n]+=n;
        }
        for(int i=0;i<n;i++){
            if(nums[i]/n>1){
                result.add(i+1);
            }
        }
        return result;
    }
}