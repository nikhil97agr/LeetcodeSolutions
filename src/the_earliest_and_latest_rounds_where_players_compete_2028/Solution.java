package the_earliest_and_latest_rounds_where_players_compete_2028;

class Solution {
    int min = 6;
    int max = 0;
    public int[] earliestAndLatest(int n, int firstPlayer, int secondPlayer) {
        solve((1<<n)-1, n, 0, n-1, firstPlayer-1, secondPlayer-1, 1);
        return new int[]{min, max};
    }

    private void solve(int mask, int n, int start, int end, int f, int s, int round){
        if(start >= end){
            solve(mask, n, 0, n-1, f, s, round+1);
        }else if((mask&(1<<start)) ==0){
            solve(mask, n, start+1, end, f, s, round);
        }else if((mask&(1<<end)) ==0){
            solve(mask, n, start, end - 1, f, s, round);
        }else if(start == f && end == s){
            min = Math.min(min, round);
            max = Math.max(max, round);
        }else{
            if(start != f && start != s){
                solve((mask^(1<<start)), n, start+1, end-1, f, s, round);
            }

            if(end != f && end != s){
                solve((mask^(1<<end)), n, start+1, end-1, f, s, round);
            }
        }
    }


}