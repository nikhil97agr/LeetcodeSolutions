package smallest_subsequence_of_distinct_characters_1159;

import java.util.*;
class Solution {
    public String smallestSubsequence(String s) {
        var n= s.length();
        int ind[] = new int[26];
        boolean vis[] = new boolean[26];
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<n;i++){
            ind[s.charAt(i) -'a'] = i;
        }
        for(int i=0;i<n;i++){
            char c = s.charAt(i);

            if(vis[c-'a']){
                continue;
            }

            while(!stack.isEmpty() && stack.peek() > c && ind[stack.peek()-'a'] > i){
                vis[stack.pop()-'a'] = false;
            }

            stack.push(c);
            vis[c-'a'] = true;
        }

        StringBuilder res = new StringBuilder();

        while(!stack.isEmpty()){
            res.append(stack.pop());
        }

        return res.reverse().toString();
    }
}