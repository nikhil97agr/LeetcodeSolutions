package maximum_subarray_min_product_1985;

import java.util.*;
class Solution {
    long mod = (long)1e9 + 7;
    public int maxSumMinProduct(int[] nums) {
        long ans = 0;
        int n = nums.length;
        long pre[] = new long[n+1];
        for(int i=0;i<n;i++){
            pre[i+1] = pre[i] + nums[i];
        }

        int left[] = ngeL(nums, n);
        int right[] = ngeR(nums, n);

        for(int i=0;i<n;i++){
            long l = 0;
            long r= 0;
            if(left[i] == -1){
                l = pre[0];
            }else{
                l = pre[left[i]+1];
            }

            if(right[i] == -1){
                r = pre[n];
            }else{
                r = pre[right[i]];
            }

            long sum = r - l;
            ans = Math.max(ans, sum*nums[i]);
        }

        return (int)(ans%mod);
    }

    private int[] ngeR(int arr[], int n){
        int nge[] = new int[n];
        Arrays.fill(nge, -1);
        Stack<Integer> stack =new Stack<>();
        for(int i=0;i<n;i++){
            while(!stack.isEmpty() && arr[i] < arr[stack.peek()]){
                nge[stack.pop()] =i;
            }
            stack.push(i);
        }

        return nge;
    }

    private int[] ngeL(int arr[], int n){
        int nge[] = new int[n];
        Arrays.fill(nge, -1);
        Stack<Integer> stack = new Stack<>();

        for(int i=n-1;i>=0;i--){
            while(!stack.isEmpty() && arr[i] < arr[stack.peek()]){
                nge[stack.pop()] = i;
            }

            stack.push(i);
        }

        return nge;
    }


}