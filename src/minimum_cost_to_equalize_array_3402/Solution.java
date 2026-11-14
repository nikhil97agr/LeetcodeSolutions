package minimum_cost_to_equalize_array_3402;

import java.util.*;
class Solution {
    public int minCostToEqualizeArray(int[] nums, int cost1, int cost2) {
        return solve(nums, cost1, cost2);
    }

    private  int solve(int arr[], int c1, int c2){
        long mod = (long)1e9+7;
        int n = arr.length;
        long last = arr[n-1];
        long max = Arrays.stream(arr).max().getAsInt();
        long min = Arrays.stream(arr).min().getAsInt();
        if(n==1) return 0;
        if(n==2){
            return (int)(((max - min) * c1)%mod);
        }

        long sum = Arrays.stream(arr).mapToLong(a -> a).sum();
        

        
        if(c2>=c1*2){
            return (int)(((max*n - sum)*c1)%mod);
        }
        
        long ans = Long.MAX_VALUE;
        for(long i=max;i<=max*2;i++){
            ans = Math.min(ans, solve(sum, max, min, i, n, c1, c2));
        }
        return (int)(ans%mod);
    }
    
    private long solve(long sum, long max, long min, long numberToMake, int n, int c1, int c2){
        long opRequeired = numberToMake*n - sum;
        long maxDiff = numberToMake - min;
        
        long left = opRequeired - maxDiff;
        if(maxDiff > opRequeired/2){
            return left*c2 + (maxDiff-left)*c1;
        }
        
        if(opRequeired%2==0){
            return (opRequeired/2)*c2;
        }else{
            return (opRequeired/2)*c2 + c1;
        }
    }
}