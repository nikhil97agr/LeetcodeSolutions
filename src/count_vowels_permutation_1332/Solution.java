package count_vowels_permutation_1332;

import java.util.*;
class Solution {
    public int countVowelPermutation(int n) {
        Map<Character, List<Character>> map = new HashMap<>();
        map.put('a', Arrays.asList('e'));
        map.put('e', Arrays.asList('a', 'i'));
        map.put('i', Arrays.asList('a', 'e', 'o' , 'u'));
        map.put('o', Arrays.asList('i', 'u'));
        map.put('u', Arrays.asList('a'));
        Integer dp[][] = new Integer[n][26];
        int mod = (int)1e9 + 7;

        for(char ch : map.keySet()){
            dp[n-1][ch-'a'] = 1;
        }

        for(int i=n-2;i>=0;i--){
            for(char c : map.keySet()){
                dp[i][c-'a'] = 0;
                for(char c1 : map.get(c)){
                    dp[i][c-'a'] = (dp[i][c-'a'] + dp[i+1][c1-'a']%mod)%mod;
                }
            }
        }
        int total = 0;
        for(char c : map.keySet()){
            total += dp[0][c-'a']%mod;
            total %= mod;
        }

        return total;
    }

    private int solve(char current, int mod, Map<Character, List<Character>> map, int ind, int n, Integer dp[][]){
        if(ind==n) return 1;
        if(dp[ind][current-'a']!=null) return dp[ind][current-'a'];
        int total = 0;
        List<Character> list = map.get(current);
        for(char c : list){
            total = (total + solve(c, mod, map, ind+1, n, dp)%mod)%mod;
        }

        return dp[ind][current-'a'] = total;
    }
}