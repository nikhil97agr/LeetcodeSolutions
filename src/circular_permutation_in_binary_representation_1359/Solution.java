package circular_permutation_in_binary_representation_1359;

import java.util.*;
class Solution {
    public List<Integer> circularPermutation(int n, int start) {
        List<Integer> list = new ArrayList<>();

        for(int i=0;i<(1<<n);i++){
            list.add(start^i^(i>>1));
        }

        return list;
    }
}