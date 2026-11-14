package minimum_recolors_to_get_k_consecutive_black_blocks_2463;

class Solution {
    public int minimumRecolors(String blocks, int k) {
        int b = 0;
        int w = 0;
        int ans = 100;

        for(int i=0;i<k-1;i++){
            if(blocks.charAt(i) == 'B') b++;
            else w++;
        }

        int i=0;
        int j=k-1;
        int n =blocks.length();
        while(j< n){
            char c =blocks.charAt(j);
            if(c == 'B') b++;
            else w++;
            j++;
            ans = Math.min(ans, w);
            if(blocks.charAt(i) == 'W') w--;
            else b--;
            i++;
        }
        return ans;

    }
}