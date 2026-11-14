package remove_k_balanced_substrings_4019;

import java.util.*;
import java.util.Stack;

class Solution {
    public String removeSubstring(String s, int k) {
        
        Stack<Pair> stack = new Stack<>();
        int cnt = 0;
        for(char c : s.toCharArray()){
            if(c=='('){
                if (cnt != 0) {
                    stack.push(new Pair(')', cnt));
                    cnt= 0;
                }
                if(stack.isEmpty()){
                    stack.push(new Pair(c, 1));
                }else if(stack.peek().ch == c){
                    stack.peek().cnt++;
                }else{
                    stack.push(new Pair(c,1));
                }
                continue;
            }
            
            cnt++;
            
            while(!stack.isEmpty()){
                if(stack.peek().ch == ')'){
                    cnt += stack.pop().cnt;
                    continue;
                }
                
                int min = Math.min(cnt / k, stack.peek().cnt / k);
                
                cnt -= min*k;
                stack.peek().cnt -= min*k;
                
                if(stack.peek().cnt ==0){
                    stack.pop();
                    continue;
                }else{
                    break;
                }
            }
        }
        
        if(cnt !=0){
            stack.push(new Pair(')', cnt));
        }
        
        StringBuilder res = new StringBuilder();
        
        while(!stack.isEmpty()){
            Pair p = stack.pop();
            
            res.append((""+p.ch).repeat(p.cnt));
        }
        
        
        return res.reverse().toString();
        
    }
    
    class Pair{
        char ch;
        int cnt;
        
        public Pair(char ch, int cnt){
            this.ch = ch;
            this.cnt = cnt;
        }
    }
}