import java.util.List;

class Solution {
    
    public int[] pathsWithMaxScore(List<String> board) {

        var n = board.size();
        int cnt[][] = new int[n][n];
        int sum[][] = new int[n][n];
        cnt[n-1][n-1] = 1;

        int dir[][] = new int[][]{{0, -1}, {-1, 0}, {-1, -1}};
        
        for(var i=n-1;i>=0;i--){
            for(var j =n-1;j>=0;j--){
                if(cnt[i][j] == 0) continue;
                
                for(int d[] : dir){
                    int ni = i + d[0];
                    int nj = j + d[1];
                    
                    if(ni < 0 || nj < 0 || board.get(ni).charAt(nj) == 'X'){
                        continue;
                    }
                    
                    char c = board.get(ni).charAt(nj);
                    var newSum = sum[i][j];
                    if( c != 'E'){
                        newSum += ( c - '0' );
                    }
                    
                    if(newSum > sum[ni][nj]){
                        sum[ni][nj] = newSum;
                        cnt[ni][nj] = cnt[i][j];
                    }else if(newSum == sum[ni][nj]){
                        cnt[ni][nj] = add(cnt[ni][nj], cnt[i][j]);
                    }
                }
            }
        }
        
        return new int[]{sum[0][0], cnt[0][0]};
    }
    
    private int add(long a, long b){
        long mod = (long )1e9 + 7;
        
        return (int)((a+b)%mod);
    }


}