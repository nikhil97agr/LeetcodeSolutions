package max_pair_sum_in_an_array_2902;

import java.util.*;
class Solution {
    public int maxSum(int[] nums) {
        Map<Integer, List<Integer>> map = new HashMap<>();

        for(int x : nums){
            int temp = x;
            int max = 0;
            while(temp > 0){
                int dig = temp%10;
                max = Math.max(max, dig);
                temp/=10;
            }

            map.computeIfAbsent(max, l -> new ArrayList<>()).add(x);
        }

        int ans = -1;
        for(List<Integer> l : map.values()){
            int m1 = 0;
            int m2 = 0;
            if(l.size() ==1) continue;
            for(int x : l){
                if(x >m1){
                    m2 = m1;
                    m1 = x;
                }else if(x > m2){
                    m2 = x;
                }
            }

            ans = Math.max(ans, m1 + m2);
        }

        return ans;
    }
}