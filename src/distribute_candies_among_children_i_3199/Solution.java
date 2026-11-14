package distribute_candies_among_children_i_3199;

class Solution {
    public int distributeCandies(int n, int limit) {
        int ans = 0;

        for(int i=0;i<=Math.min(limit, n);i++){
            for(int j=0;j<=Math.min(limit, n-i);j++){
                if(n-i-j <= limit) ans++;
            }
        }


        return ans;
    }
}