package minimize_length_of_array_using_operations_3244;

import java.util.*;
class Solution {
    public int minimumArrayLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int low = Integer.MAX_VALUE;
        for(int x : nums){
            map.merge(x, 1, Integer::sum);
            low = Math.min(x, low);
        }

        int gcd = low;
        for(int key : map.keySet()){
            gcd = gcd(gcd, key);
        }

        if(gcd != low){
            return 1;
        }

        return (map.get(low) + 1)/2;

    }

    int gcd(int a, int b){
        if(a==0) return b;

        return gcd(b%a, a);
    }
}