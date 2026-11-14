package maximum_good_people_based_on_statements_2272;

class Solution {
    public int maximumGood(int[][] statements) {
        int ans = 0;
        int n = statements.length;

        for(int mask=0;mask<(1<<n);mask++){
            boolean result= true;
            for(int i=0;i<n;i++){
                if((mask & (1<<i)) ==0) continue;
                for(int j=0;j<n;j++){
                    if(statements[i][j] == 2) continue;

                    if(statements[i][j] == 1){
                        if((mask & (1<<j)) ==0){
                            result = false;
                            break;
                        }
                    }else{
                        if((mask & (1<<j))!=0){
                            result = false;
                            break;
                        }
                    }
                }
                if(!result) break;
            }

            if(result){
                ans = Math.max(ans, Integer.bitCount(mask));
            }
        }

        return ans;
    }
}