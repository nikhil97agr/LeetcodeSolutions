package minimum_number_of_k_consecutive_bit_flips_1037;

import java.util.*;
class Solution {

    public int minKBitFlips(int[] nums, int k) {
        int n = nums.length;
        BitSet bitset = new BitSet(n);
        for(int i=0;i<n;i++){
            if(nums[i] == 1) bitset.set(i);
        }
        int cnt = 0;
        int i=0;
        while(i+k<=n){
            if(!bitset.get(i)){
                bitset.flip(i, i+k);
                cnt++;
            }
            i++;
        }
        return bitset.cardinality()==n ? cnt : -1;
    }

}