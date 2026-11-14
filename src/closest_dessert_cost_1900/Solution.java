package closest_dessert_cost_1900;

class Solution {
    public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
        int ans = Integer.MAX_VALUE;
        int diff= Integer.MAX_VALUE;

        int n = baseCosts.length;
        int m = toppingCosts.length;
        int map[] = new int[1<<m];
        for(int i=0;i<1<<m;i++){
            int total =0;
            for(int j=0;j<m;j++){
                if((i &( 1<<j))!=0){
                    total += toppingCosts[j];
                }
            }
            map[i] = total;
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<1<<m;j++){
                for(int k=0;k<1<<m;k++){
                    int total = baseCosts[i] + map[j] + map[k];
                    int d = Math.abs(target - total);

                    if(d < diff){
                        diff = d;
                        ans = total;
                    }else if(d == diff && total < ans){
                        ans = total;
                    }
                }
            }
        }

        return ans;
    }
}