import java.util.ArrayList;
import java.util.List;

class Solution {

    public long countGoodIntegersOnPath(long l, long r, String directions) {
        return solve(r, directions) - solve(l-1, directions);
    }

    private long solve(long n, String directions){
        String s = String.format("%016d", n);
        
        List<Integer> path = new ArrayList<>();
        int r = 0;
        int c = 0;
        path.add(0);
        for(char ch : directions.toCharArray()){
            if(ch == 'D') r++;
            else c++;
            path.add(4 * r + c);
        }
        
        
        
        Long dp[][][][] = new Long[17][2][11][8];
        
        return solve(0, 1, 10, 0, s, path, dp);
                
    }
    
    private long solve(int i, int flag, int prev, int ind, String num, List<Integer> path, Long dp[][][][]){
        if(i == 16){
            return 1;
        }
        
        if(dp[i][flag][prev][ind] !=null) return dp[i][flag][prev][ind];
        
        int limit = (flag == 1) ? (num.charAt(i) - '0') : 9;
        
        long ans = 0;
        
        for(int dig = 0;dig <= limit;dig++){
            int newFlag = (flag == 1 && dig == limit) ? 1 : 0;
            if(ind < 7 && i == path.get(ind)){
                if(prev == 10 || dig >= prev){
                    ans += solve(i+1, newFlag, dig, ind+1, num, path, dp);
                }
            }else{
                ans += solve(i+1, newFlag, prev, ind,num, path, dp);
            }
        }
        
        return dp[i][flag][prev][ind] = ans;
    }
}