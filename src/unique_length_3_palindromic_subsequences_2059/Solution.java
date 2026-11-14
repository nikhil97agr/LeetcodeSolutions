package unique_length_3_palindromic_subsequences_2059;

import java.util.*;
class Solution {
    public int countPalindromicSubsequence(String s) {
        Map<Character, int[]> map  = new HashMap<>();
        int n = s.length();
        int prefix[][] =new int[n+1][26];
        for(int i=1;i<=n;i++){
            char c = s.charAt(i-1);
            if(map.containsKey(c)){
                int index[] = map.get(c);
                index[1] = i-1;
            }else{
                map.put(c, new int[]{i-1, -1});
            }
            prefix[i] = prefix[i-1].clone();
            prefix[i][c-'a']++;
        }

        int ans = 0;
        for(char c : map.keySet()){
            int indices[] = map.get(c);
            if(indices[1]==-1) continue;

            int start = indices[0];
            int end = indices[1];
            int count = 0;
            for(int i=0;i<26;i++){
                if(i==(c-'a') && prefix[end+1][i] - prefix[start+1][i]>1){
                    count++;
                }
                else if(i!=(c-'a') && prefix[start+1][i] < prefix[end+1][i]) count++;
            }

            ans += count;

        }
        return ans;
    }
}