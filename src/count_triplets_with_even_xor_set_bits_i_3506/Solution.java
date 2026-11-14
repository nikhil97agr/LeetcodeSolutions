package count_triplets_with_even_xor_set_bits_i_3506;

class Solution {
    public int tripletCount(int[] a, int[] b, int[] c) {
        int ans = 0;
        for(int i=0;i<a.length;i++){
            for(int j=0;j<b.length;j++){
                for(int k=0;k<c.length;k++){
                    int xor = a[i]^b[j]^c[k];
                    int cnt = Integer.bitCount(xor);
                    if(cnt%2==0){
                        ans++;
                    }
                }
            }
        }

        return ans;
    }
}