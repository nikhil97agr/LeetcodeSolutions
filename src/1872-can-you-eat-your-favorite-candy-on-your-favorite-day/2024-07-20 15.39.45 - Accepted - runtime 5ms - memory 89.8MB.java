class Solution {
    public boolean[] canEat(int[] candies, int[][] queries) {
        int n = candies.length;
        int m = queries.length;
        boolean ans[] = new boolean[m];
        long prefix[] = new long[n];
        for(int i=1;i<n;i++){
            prefix[i] = prefix[i-1] + 1L*candies[i-1];
        }

        for(int i=0;i<queries.length;i++){
            int type = queries[i][0];
            int day = queries[i][1];
            int limit = queries[i][2];

            long req = prefix[type]/(1L*limit);
            
            if(req-1 >= 1L*day){
                ans[i] = false;
            }else{
                if(prefix[type] + 1L*candies[type] -1 < 1L*day){
                    ans[i] = false;
                }else{
                    ans[i] = true;
                }
            }
        }

        return ans;
    }
}