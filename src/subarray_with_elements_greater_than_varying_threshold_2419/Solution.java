package subarray_with_elements_greater_than_varying_threshold_2419;

import java.util.*;
class Solution {
    public int validSubarraySize(int[] nums, int threshold) {
        int n = nums.length;
        int right[] = nextSmaller1(nums, n);
        int left[] = nextSmaller2(nums, n);

        for(int i=0;i<n;i++){
            int len = (i - left[i]) + (right[i] - i) - 1;

            if(1l*nums[i] * len > threshold) return len;
        }
        return -1;
    }

    private int[] nextSmaller1(int nums[], int n){
        int nse[] = new int[n];
        Arrays.fill(nse, n);
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<n;i++){
            if(stack.isEmpty()){
                stack.push(i);
                continue;
            }

            while(!stack.isEmpty() && nums[stack.peek()] > nums[i]){
                nse[stack.pop()] = i;
            }
            stack.push(i);
        }

        return nse;
    }

    private int[] nextSmaller2(int nums[], int n){
        int nse[] = new int[n];
        Arrays.fill(nse, -1);
        Stack<Integer> stack = new Stack<>();

        for(int i=n-1;i>=0;i--){
            if(stack.isEmpty()){
                stack.push(i);
                continue;
            }

            while(!stack.isEmpty() && nums[stack.peek()] > nums[i]){
                nse[stack.pop()] = i;
            }
            stack.push(i);
        }

        return nse;
    }
}