package decode_xored_permutation_1835;

class Solution {
    public int[] decode(int[] encoded) {
        int xor = 0;
        int n = encoded.length+1;
        for(int i=1;i<=n;i++){
            xor ^= i;
        }

        for(int i=1;i<n-1;i+=2){
            xor ^= encoded[i];
        }

        int ans[] = new int[n];
        ans[0] = xor;

        for(int i=1;i<n;i++){
            ans[i] = ans[i-1] ^ encoded[i-1];
        }

        return ans; 
    }
}