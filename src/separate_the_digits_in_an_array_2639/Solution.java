package separate_the_digits_in_an_array_2639;

import java.util.*;
class Solution {
    public int[] separateDigits(int[] nums) {
        List<Integer> result = new ArrayList<Integer>();
        int n = nums.length;
        for(int j=0;j<n;j++){
            String s  = ""+nums[j];
            for(char c : s.toCharArray()){
                    result.add(c-'0');
                
            }
        }
        int ans[] = new int[result.size()];
        for(int i=0;i<result.size();i++){
            ans[i] = result.get(i);
        }
        return ans; 
    }
}