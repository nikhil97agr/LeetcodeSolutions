package maximize_value_of_function_in_a_ball_passing_game_3032;

import java.util.*;
class Solution {
    public long getMaxFunctionValue(List<Integer> receiver, long k) {
        int log = 35;
        int n = receiver.size();
        int parent[][] = new int[n][log];
        long profit[][] = new long[n][log];

        for(int i=0;i<n;i++){
            int r = receiver.get(i);
            profit[i][0] = parent[i][0] = r;
        
        }

        for(int j=1;j<log;j++){
            for(int i=0;i<n;i++){
                int p= parent[i][j-1];
                parent[i][j] = parent[p][j-1];
                profit[i][j] = profit[i][j-1] + profit[p][j-1];
            }
        }
        long ans=0;

        for(int i=0;i<n;i++){
            long score =i;
            int curr = i;
            for(int j=0;j<log;j++){
                long bit = (k >> j)&1;
                if(bit == 1){
                    score += profit[curr][j];
                    curr = parent[curr][j];
                }

            
            }
            ans = Math.max(ans, score);
        }
        return ans;
    }
}