package find_the_integer_added_to_array_ii_3399;

import java.util.*;
class Solution {
    public int minimumAddedInteger(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int n = nums1.length;
        int ans = Integer.MAX_VALUE;
        
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int l =0;
                TreeSet<Integer> set = new TreeSet<>();
                for(int k=0;k<n;k++){
                    if(k==i || k ==j){
                        continue;
                    }
                    
                    set.add(nums2[l] - nums1[k]);
                    l++;
                }
                if(set.size() ==1){
                    ans = Math.min(ans, set.getFirst());
                }
                
            }
        }
        return ans;
        
    }
}