package number_of_valid_subarrays_1061;

import java.util.*;
class Solution {
    public int validSubarrays(int[] nums) {
        int nge[] = nge(nums);
        int ans = 0;
        int n = nums.length;
        for(int i=0;i<n;i++){
            ans += (nge[i] - i);
        }

        return ans;
    }

    int[] nge(int nums[]){
        int n = nums.length;
        Stack<Integer> stack = new Stack<>();

        int nge[] = new int[n];
        Arrays.fill(nge, n);
        for(int i=0;i<n;i++){
            while(!stack.isEmpty() && nums[stack.peek()] > nums[i]){
                nge[stack.pop()] = i;
            }

            stack.push(i);
        }
        return nge;
    }
}