package next_greater_element_ii_503;

import java.util.*;
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int ans[] = new int[n];
        Arrays.fill(ans, Integer.MIN_VALUE);
        nge(ans, nums, n);
        List<Integer> list = new ArrayList<>();

        for(int i=0;i<n;i++){


            if(ans[i] == Integer.MIN_VALUE){
                int val = find(list, nums[i]);
                ans[i] = val;
            }

            if(list.isEmpty() || nums[i] > list.get(list.size() - 1)){
                list.add(nums[i]);
            }
        }
        return ans;
        
    }

    private int find(List<Integer> list, int n){
        int start = 0;
        int end = list.size() - 1;
        int ans = -1;

        while(start <= end){
            int mid = (start + end) / 2;
            if(list.get(mid) > n){
                ans = list.get(mid);
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }

        return ans;
    }

    private void nge(int ans[], int nums[], int n){
        Stack<Integer> stack = new Stack<>();

        for(int i=0;i<n;i++){
            while(!stack.isEmpty() && nums[stack.peek()] < nums[i]){
                ans[stack.pop()] = nums[i];
            }
            stack.push(i);
        }
    
    }
}