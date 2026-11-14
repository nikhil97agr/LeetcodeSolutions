package minimum_elements_to_add_to_form_a_given_sum_1911;

import java.util.*;
import java.util.Arrays;

class Solution {
    public int minElements(int[] nums, int limit, int goal) {
        long sum = Arrays.stream(nums).mapToLong(a-> a).sum();

        long req = 1l*goal - sum;

        if(req==0) return 0;

            req = Math.abs(req);
            int amt = (int)(Math.ceil((1d*req)/limit));
            return amt;

    }
}