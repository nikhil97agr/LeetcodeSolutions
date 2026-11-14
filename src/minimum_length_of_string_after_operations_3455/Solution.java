package minimum_length_of_string_after_operations_3455;

import java.util.*;
class Solution {
    public int minimumLength(String s) {
        Stack<Integer> stack[] = new Stack[26];
        Stack<Integer> s2[] = new Stack[26];
        for(int i=0;i<26;i++){
            stack[i]= new Stack<>();
            s2[i] = new Stack<>();
        }

        for(int i=s.length()-1;i>=0;i--){
            char c = s.charAt(i);
            stack[c-'a'].push(i);
        }

        char c[] = s.toCharArray();
        for(int i=0;i<s.length();i++){
            if(c[i] == ' ') continue;
            char ch = c[i];
            int ind = ch-'a';
            stack[ind].pop();
            if(stack[ind].isEmpty() || s2[ind].isEmpty()){
                s2[ind].push(i);
                continue;
            }
            if(!s2[ind].isEmpty()){
                c[s2[ind].pop()] = ' ';
            }
            s2[ind].push(i);
            if(!stack[ind].isEmpty()){
                c[stack[ind].pop()] = ' ';
            }

        }
        int ans = 0;
        for(char ch : c){
            if(ch!=' ')ans++;
        }
        
        return ans;
    }
}