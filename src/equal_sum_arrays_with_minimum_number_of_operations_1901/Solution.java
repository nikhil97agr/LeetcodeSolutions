package equal_sum_arrays_with_minimum_number_of_operations_1901;

import java.util.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

class Solution {
    public int minOperations(int[] nums1, int[] nums2) {
        int sum1 = Arrays.stream(nums1).sum();
        int sum2 = Arrays.stream(nums2).sum();

        if(sum1 == sum2) return 0;

        if(sum2 > sum1){
            return minOperations(nums2, nums1);
        }

        int req = sum1 - sum2;

        PriorityQueue<Integer> q1 = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> q2 = new PriorityQueue<>();

        for(int x : nums1){
            q1.offer(x);
        }

        for(int x : nums2){
            q2.offer(x);
        }
        int ans = 0;

        while(req > 0 && !q1.isEmpty() && !q2.isEmpty()){
            int x1 = q1.poll();
            int x2 = q2.poll();

            int diff1 = x1 - 1;
            int diff2 = 6 - x2;

            if(diff1 >= diff2){
                req -= diff1;
                q2.offer(x2);
            }else{
                q1.offer(x1);
                req -= diff2;
            }
            ans++;

        }
        while(req > 0 && !q1.isEmpty()){
            int x = q1.poll();
            
            req -= (x - 1);
            ans++;
        }
        
        while(req > 0 && !q2.isEmpty()){
            int x = q2.poll();
            req -= (6 - x);
            ans++;
        }
        

        return req > 0 ? -1 : ans;



    }
}