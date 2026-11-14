package number_of_unique_xor_triplets_i_3824;

class Solution {
    public int uniqueXorTriplets(int[] nums) {
        int n = nums.length;
        int len = Integer.toBinaryString(n).length();
        if(n >= 3){
            return (int)Math.pow(2, len);
        }

        return n;


    }
}

/**
1 - 0 0 1
2 - 0 1 0
3 - 0 1 1
4 - 1 0 0
5 - 1 0 1
6 - 1 1 0
7 - 1 1 1

 */