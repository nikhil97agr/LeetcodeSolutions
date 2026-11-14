package count_triplets_with_even_xor_set_bits_ii_3521;

class Solution {
    public long tripletCount(int[] a, int[] b, int[] c) {
        int c1[] = new int[2];
        int c2[] = new int[2];
        int c3[] = new int[2];
        for(int x : a){
            c1[Integer.bitCount(x)%2]++;
        }

        for(int x : b){
            c2[Integer.bitCount(x)%2]++;
        }

        for(int x : c){
            c3[Integer.bitCount(x)%2]++;
        }

        return 1l * c1[0]*c2[0]*c3[0] + 1l*c1[0]*c2[1]*c3[1] + 1l*c1[1]*c2[0]*c3[1] + 1l*c1[1]*c2[1]*c3[0];
    }
}
