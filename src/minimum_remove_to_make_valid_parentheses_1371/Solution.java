package minimum_remove_to_make_valid_parentheses_1371;

import java.util.*;
class Solution {
    public String minRemoveToMakeValid(String s) {
        char ch[] = s.toCharArray();
        int n = s.length();
        Queue<Integer> que = new LinkedList<>();
        for(int i=0;i<n;i++){
            if(ch[i] == '('){
                que.offer(i);
            }else if(ch[i] == ')'){
                if(que.isEmpty()){
                    ch[i] = ' ';
                }else{
                    que.poll();
                }
            }
        }

        while(!que.isEmpty()){
            ch[que.poll()] = ' ';
        }
        StringBuilder res = new StringBuilder();
        for(char c : ch){
            if(c != ' '){
                res.append(c);
            }
        }
        return res.toString();
    }
}