package report_spam_message_3541;

import java.util.*;
class Solution {
    public boolean reportSpam(String[] message, String[] bannedWords) {
        Set<String> set = new HashSet<>();
        for(String s : bannedWords) set.add(s);
        int ans = 0;
        
        for(String s : message){
            if(set.contains(s)){
                ans++;
            }
        }
        
        return ans>=2;
    }
}