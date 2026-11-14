package summary_ranges_228;

import java.util.*;
class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            int start = nums[i];
            while(i+1<nums.length && nums[i]+1 == nums[i+1]){
                i++;
            }
            if(nums[i]!=start){
                StringBuilder sb = new StringBuilder();
                sb.append(start);
                sb.append("->");
                sb.append(nums[i]);
                result.add(sb.toString());
            }else{
                StringBuilder sb = new StringBuilder();
                sb.append(start);
                result.add(sb.toString());
            }
        }

        return result;
    }
}