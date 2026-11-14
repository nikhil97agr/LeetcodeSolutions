import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Solution {
    public int bestTeamScore(int[] scores, int[] ages) {
        List<Player> list = new ArrayList<>();
        list.add(new Player(0, 0));
        int n = scores.length;
        for(int i=0;i<n;i++){
            list.add(new Player(scores[i], ages[i]));
        }

        list.sort((p1,p2)->{
            if(p1.age == p2.age) return p1.score - p2.score;

            return p1.age - p2.age;
        });
        Integer dp[][] = new Integer[list.size()][list.size()];
        return solve(1, 0, list, list.size(), dp);
    }

    private int solve(int curr, int prev, List<Player> list, int n, Integer dp[][]){
        if(curr==n) return 0;

        if(dp[curr][prev] !=null) return dp[curr][prev];


        int ans =  solve(curr+1, prev, list, n, dp);
         Player p1 = list.get(curr);
         Player p2 = list.get(prev);

         if(p1.age == p2.age){
             ans = Math.max(ans, p1.score + solve(curr+1, curr, list, n, dp));
         }else if(p1.score > p2.score){
             ans = Math.max(ans, p1.score + solve(curr+1, curr, list, n, dp));
         }else if(p1.score == p2.score){
             ans = Math.max(ans, p1.score + solve(curr+1, prev, list, n, dp));
         }


        return dp[curr][prev] = ans;

    }

    class Player{
        int score;
        int age;

        public Player(int s, int a){
            score= s;
            age = a;
        }
    }
    
}