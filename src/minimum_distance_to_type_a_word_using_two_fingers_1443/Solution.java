package minimum_distance_to_type_a_word_using_two_fingers_1443;

import java.util.*;
class Solution {
    public int minimumDistance(String word) {
        Map<Character, int[]> map = new HashMap<>();
        char c = 'A';

        for(int i=0; c<='Z' && i<6;i++){
            for(int j=0;j<6 && c<='Z';j++){
                map.put(c, new int[]{i, j});
                c++;
            }
        }
        Integer dp[][][] = new Integer[word.length()][26][26];
        int ans = Integer.MAX_VALUE;
        for(char c1 = 'A';c1<='Z';c1++){
            for(char c2 = 'A';c2<='Z';c2++){


                ans = Math.min(ans, solve(c1,c2, map, word.toCharArray(), 0, word.length(), dp));
            }
        }

        return ans;
    }

    private int solve(char c1, char c2, Map<Character, int[]>map, char ch[], int i, int n, Integer dp[][][]){
        if(i==n) return 0;

        if(dp[i][c1-'A'][c2-'A']!=null) return dp[i][c1-'A'][c2-'A'];
        int co1[] = map.get(c1);
        int co2[] = map.get(c2);
        int x1 = co1[0], x2 = co2[0], y1 = co1[1], y2 = co2[1];
        int coor[] = map.get(ch[i]);

        return dp[i][c1-'A'][c2-'A'] = Math.min( Math.abs(x1-coor[0]) + Math.abs(y1 - coor[1]) + solve(ch[i], c2, map, ch, i+1, n, dp), Math.abs(x2-coor[0]) + Math.abs(y2 - coor[1]) + solve(c1, ch[i],  map, ch, i+1, n, dp) );
    }
}