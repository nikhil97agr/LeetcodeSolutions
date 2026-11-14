package minimum_operations_to_make_elements_within_k_subarrays_equal_3717;

import java.util.*;
class Solution {        
    TreeMap<Integer, Integer> left= new TreeMap<>();
    TreeMap<Integer, Integer> right = new TreeMap<>();
    int leftCnt = 0;
    int rightCnt = 0;
    long leftSum = 0;
    long rightSum = 0;
    public long minOperations(int[] nums, int x, int k) {
        int n = nums.length;
        
        for(int i=0;i<x;i++){
            int val = nums[i];
            add(val);
        }

        long dp[][] = new long[n+1][k+1];
        for(int i=0;i<=n;i++){
            for(int j=1;j<=k;j++){
                dp[i][j] = (1l << 40);
            }
        }

        for(int i=x;i<=n;i++){

            long mid = left.lastKey();
            long totalL = mid * leftCnt;
            long totalR = mid * rightCnt;
            long diff = (totalL - leftSum) + (rightSum - totalR);

            for(int j=1;j<=k;j++){
                dp[i][j] = Math.min(dp[i-1][j], diff + dp[i-x][j-1]);
            }

            if(i==n) break;

            int prev = nums[i-x];
            remove(prev);
            add(nums[i]);


        }

        return dp[n][k];

        
    }

    private void remove(int val){
        if(left.containsKey(val)){
            leftCnt--;
            leftSum -= val;
            remove(val, left);

        }else{
            rightCnt--;
            rightSum -= val;
            remove(val, right);
        }
        balance();
    }

    private void add(int val){
        add(val, left);
        leftSum += val;
        int last = left.lastKey();
        remove(last, left);
        leftSum -= last;
        add(last, right);
        rightCnt++;
        rightSum += last;
        balance();
    }

    private void balance(){
        while(rightCnt < leftCnt){
            int last = left.lastKey();
            leftSum -= last;
            leftCnt--;
            remove(last, left);
            rightSum += last;
            rightCnt++;
            add(last, right);
        }
        while(leftCnt < rightCnt){
            int last = right.firstKey();
            rightSum -= last;
            rightCnt--;
            remove(last, right);
            add(last, left);
            leftSum += last;
            leftCnt++;
        }
    }

    private void remove(int val, Map<Integer, Integer> map){
        map.merge(val,-1, Integer::sum);
        if(map.get(val) ==0) map.remove(val);
    }

    private void add(int val, Map<Integer, Integer> map){
        map.merge(val, 1, Integer::sum);
    }

}