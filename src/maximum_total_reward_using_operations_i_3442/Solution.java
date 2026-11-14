package maximum_total_reward_using_operations_i_3442;

import java.util.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

class Solution {
    
    class Pair{
        int i,x;
        public Pair(int i, int x){
            this.i = i;
            this.x = x;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return i == pair.i && x == pair.x;
        }

        @Override
        public int hashCode() {
            return Objects.hash(i, x);
        }
    }

    public static void main(String[] args) {

        System.out.println(new Solution().maxTotalReward(new int[]{1,6,4,3,2}));
    }
    public int maxTotalReward(int[] arr) {
        Map<Pair, Integer> map = new HashMap<>();
        int x= 0;
        Arrays.sort(arr);
        int n = arr.length;
        return solve(0, 0, n, arr, map);
    }
    
    private int solve(int x, int start, int n, int arr[], Map<Pair, Integer> map){
        if(start >=n) return x;
        Pair pair = new Pair(start, x);
        if(map.containsKey(pair)) {
            return map.get(pair);
        }
        int ans = x;
        for(int i= start;i<n;i++){
            int ind = binarySearch(arr, i+1, x+arr[i], n-1);
            if(ind !=-1){
                ans = Math.max(ans, solve(x+arr[i], ind, n, arr, map));
            }else{
                ans = Math.max(ans, x + arr[i]);
            }
        }
        
        map.put(pair, ans);
        
        return ans;
        
        
    }
    
    private int binarySearch(int arr[], int start, int val, int end){
        int ind = -1;
        while(start <= end){
            int mid = (start + end)/2;
            if(arr[mid] > val){
                ind = mid;
                end = mid-1;
            }else{
                start = mid+1;
            }
        }
        
        return ind;
    }
}