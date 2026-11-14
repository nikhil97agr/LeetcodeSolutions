package find_the_sequence_of_strings_appeared_on_the_screen_3566;

import java.util.*;
class Solution {
    public List<String> stringSequence(String target) {
        List<String> result = new ArrayList<>();
        
        solve(result, 0, new StringBuilder(), target);
        return result;
    }
    
    private void solve(List<String> result, int i, StringBuilder sb, String target){
        if(i >= target.length()) return;
        
        char curr = 'a';
        sb.append(curr);
        
        while(curr != target.charAt(i)){
            sb.setCharAt(i, curr);
            result.add(sb.toString());
            curr++;
        }
        sb.setCharAt(i, curr);
        result.add(sb.toString());
        
        solve(result, i+1, sb, target);
        
    }
}