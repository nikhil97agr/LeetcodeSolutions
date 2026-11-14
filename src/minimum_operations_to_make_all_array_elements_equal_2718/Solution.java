package minimum_operations_to_make_all_array_elements_equal_2718;

import java.util.*;
class Solution {
    public List<Long> minOperations(int[] nums, int[] queries) {
        Arrays.sort(nums);
        int n = nums.length;
        List<Long> result = new ArrayList<>();
        long pre[] = new long[n+1];
        for(int i=0;i<nums.length;i++){
            pre[i+1] = pre[i] + nums[i];
        }

        for(int q : queries){
            int i1 = left(nums, q);
            int i2 = right(nums, q);
            
            long steps = 0;
            if(i1 != -1){
                long req = 1l*(i1+1)*q;
                long sum = pre[i1+1];

                steps += req - sum;
            }

            if(i2 != -1){
                long req = 1l*(n-i2)*q;
                long sum = pre[n] - pre[i2];
                steps += (sum - req);
            }

            result.add(steps);
        }

        return result;
    }
    private int right(int nums[], int val){
        int ind = -1;
        int start = 0;
        int end = nums.length - 1;
        while(start <= end){
            int mid = (start + end)/2;

            if(nums[mid] > val){
                ind = mid;
                end = mid -1 ;
            }else{
                start = mid + 1;
            }
        }

        return ind;
    }

    private int left(int nums[], int val){
        int ind = -1;
        int start = 0;
        int end = nums.length -1;
        while(start <= end){
            int mid = (start + end)/2;
            if(nums[mid] < val){
                ind = mid;
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }

        return ind;
    }
}