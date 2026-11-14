package determine_the_minimum_sum_of_a_k_avoiding_array_2811;

import java.util.*;
class Solution {
    public int minimumSum(int n, int k) {
        int sum = 0;
        int start = 1;
        Set<Integer> set = new HashSet<>();

        while(set.size()!= n){
            int diff= k - start;
            if(!set.contains(diff)){
                set.add(start);
                sum += start;
            }

            start++;
        }

        return sum;
    }
}