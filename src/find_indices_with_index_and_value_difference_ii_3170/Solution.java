package find_indices_with_index_and_value_difference_ii_3170;

import java.util.*;
class Solution {
    public int[] findIndices(int[] nums, int indexDifference, int valueDifference) {
        int ans[] = new int[]{-1,-1};
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<int[]> max = new PriorityQueue<>((a,b)-> a[0] - b[0]);
        PriorityQueue<int[]> min = new PriorityQueue<>((a,b)-> b[0] - a[0]);
        for(int i=indexDifference;i<n;i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
            max.add(new int[]{nums[i], i});
            min.add(new int[]{nums[i], i});
        }
        for(int i=0;i<n-indexDifference;i++){
            if(Math.abs(nums[i] - min.peek()[0]) >= valueDifference){
                ans[0] = i;
                ans[1] = min.peek()[1];
                break;
            }
            if(Math.abs(nums[i] - max.peek()[0]) >= valueDifference){
                ans[0] = i;
                ans[1] = max.peek()[1];
                break;
            }
            
            map.put(nums[i + indexDifference], map.get(nums[i+ indexDifference])-1);
            if(map.get(nums[i+indexDifference])==0){
                map.remove(nums[i+indexDifference]);
            }
            
            while(!max.isEmpty() && !map.containsKey(max.peek()[0])){
                max.poll();
            }
            while(!min.isEmpty() && !map.containsKey(min.peek()[0])){
                min.poll();
            }
        }
        return ans;
    }
}